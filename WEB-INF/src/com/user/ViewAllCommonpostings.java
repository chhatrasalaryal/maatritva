package com.user;



import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AdminDAO;

@SuppressWarnings("serial")
public class ViewAllCommonpostings extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd1=null;	
	String action=	req.getParameter("action");
	if(action.equals("get"))
	{
		
        ResultSet rs= AdminDAO.commonresult();	
		req.setAttribute("rs",rs);
	
	
	 rd1=req.getRequestDispatcher("/jsp/user/viewCommonpostings.jsp");
		rd1.forward(req, resp);
		
		
	
	}
	
		}
		

}

