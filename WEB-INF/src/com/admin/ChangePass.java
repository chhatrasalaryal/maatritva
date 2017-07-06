
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.DAO.AdminDAO;

public class ChangePass extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			HttpSession hs=request.getSession();
           String admin=(String) hs.getAttribute("admin");
          System.out.println("admin is >>>>>>>>>>>>>>>>>>>>>>>>"+admin);
			int no=Integer.parseInt(request.getParameter("no"));
			System.out.println("no is >>>>>>>>>>"+no);
			if(no==1)
			{
				
				System.out.println("no is >>>>>>>>>>"+no);
				String name=request.getParameter("name");
				request.setAttribute("user",name);
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin/changepassword.jsp");
				rd.forward(request, response);
			}
		if(no==2)
			{
			
			
			System.out.println("no is >>>>>>>>>>"+no);
			AdminDAO adminDAO=AdminDAO.getInstance();
				String adminid=request.getParameter("adminid");
				String oldpass=request.getParameter("oldpass");
				String newpass=request.getParameter("newpass");
				String conpass=request.getParameter("conpass");
				
				
				
			
				boolean result=adminDAO.checkAdmin(admin, oldpass);
			
				
				if(result)
				{
					if(newpass.equals(conpass))
					{
					
						boolean result1=adminDAO.chnagePass(admin, newpass);
						
						if(result1)
						{
							
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin/changepassword.jsp?no=6");
							rd.forward(request, response);
						}
						else
						{
							RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin/changepassword.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin/changepassword.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin/changepassword.jsp?no=4");
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

