
package com.experts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.DAO.AdminDAO;

public class ChangePasss extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			HttpSession hs=request.getSession();
           String expert=(String) hs.getAttribute("expert");
          System.out.println("expert is >>>>>>>>>>>>>>>>>>>>>>>>"+expert);
			int no=Integer.parseInt(request.getParameter("no"));
			System.out.println("no is >>>>>>>>>>"+no);
			if(no==1)
			{
				
				
				hs.setAttribute("expert",expert);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/expert/changepassword.jsp");
				rd.forward(request, response);
			}
		if(no==2)
			{
			
			
			System.out.println("no is >>>>>>>>>>"+no);
			    AdminDAO adminDAO=AdminDAO.getInstance();
			 expert=request.getParameter("exid");
				String oldpass=request.getParameter("oldpass");
				String newpass=request.getParameter("newpass");
				String conpass=request.getParameter("conpass");
				
				
				
			
				boolean result=adminDAO.checkExpert(expert, oldpass);
			
				
				if(result)
				{
					if(newpass.equals(conpass))
					{
					
						boolean result1=adminDAO.chnageExpert(expert, newpass);
						
						if(result1)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/expert/changepassword.jsp?no=6");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/expert/changepassword.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/expert/changepassword.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/expert/changepassword.jsp?no=4");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User ChangePass Servlet......"+e);
			out.println("Opps's Error is in User ChangePass Servlet......"+e);
		}
	}
}

