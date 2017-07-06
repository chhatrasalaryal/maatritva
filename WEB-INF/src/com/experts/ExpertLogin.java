package com.experts;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;

public class ExpertLogin  extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		
		try
		{
			String expert=request.getParameter("username");
			String pass=request.getParameter("password");
			System.out.println(expert+"---"+pass);
			
			
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			boolean result=adminDAO.checkExpert(expert, pass);
			if(result)
			{
				RequestDispatcher rd=null;
				HttpSession hs=request.getSession();
				hs.setAttribute("expert", expert);
				rd=request.getRequestDispatcher("/jsp/expert/experthome.jsp");
				rd.forward(request,response);
			}
			else
			{
				response.sendRedirect("experts.jsp?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("********* Exception In AdminLogin Servlet ********\n");
			e.printStackTrace();
		}
	}

}
