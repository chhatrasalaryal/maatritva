package com.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Gyredirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	String action=	req.getParameter("action");
	if(action.equals("get"))
	{
		
		RequestDispatcher rd1=req.getRequestDispatcher("/jsp/admin/addgynocolist.jsp");
		rd1.forward(req, resp);
		
		
		
		
	}
		
	}

}
