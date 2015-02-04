package com.leonardoz;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leonardoz.command.Command;

@WebServlet(urlPatterns="/z/*")
public class ZFrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String BASE_PACKAGE = "com.leonardoz.command.";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String action = req.getParameter("act");
			Class<?> loadedClass = Class.forName(BASE_PACKAGE+action+"Command");
			Command command = (Command) loadedClass.newInstance();
			String resultPage = command.execute(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(resultPage);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException |IllegalAccessException e) {
			e.printStackTrace();
		}
	
	}
}
