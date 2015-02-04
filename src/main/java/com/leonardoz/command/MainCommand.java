package com.leonardoz.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Executing on MainCommand");
		return "/WEB-INF/static/jsp/Main.jsp";
	}

}
