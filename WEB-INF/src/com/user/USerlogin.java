package com.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;

public class USerlogin  extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		
		try
		{
			String uid=request.getParameter("uid");
			String pass=request.getParameter("pass");
			System.out.println(uid+"---"+pass);
			
			
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.checkuser(uid, pass);
			if(result)
			{
				RequestDispatcher rd=null;
				
			
				HttpSession session = request.getSession(true);
				session.setAttribute("uid",uid);
				
				
				
				rd=request.getRequestDispatcher("/jsp/user/userhome.jsp");
				rd.forward(request,response);
			}
			else
			{
				response.sendRedirect("pllogin.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("********* Exception In AdminLogin Servlet ********\n");
			e.printStackTrace();
		}
	}

}
