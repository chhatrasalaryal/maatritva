
package com.admin;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DAO.AdminDAO;
import com.util.Utility;

@SuppressWarnings("serial")
public class ManageGyano extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{

		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
	
		
		try
		{
			
			
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getGyano();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp");
				rd.forward(request, response);
			}
			
			
		if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit")).equals("YES"))
				{
					if(flag)
					{
						rs=AdminDAO.getGyano();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getGyano(chk[0]);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/editgynocolist.jsp?no=2");
						rd.forward(request,response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getGyano();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getGyano();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getGyano(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/editgynocolist.jsp");
					rd.forward(request,response);
				}
			}

			
		
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				
			
					
					if(chk==null)
					{
						rs=AdminDAO.getGyano();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=2");
						rd.forward(request,response);
					}
					else
					{
						
					
				
				
				
				
				for(int i=0;i<chk.length;i++)
				{
					String compantid = chk[i];
					AdminDAO.deletegyano(compantid);
					
				}
				rs=AdminDAO.getGyano();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=3");
				rd.forward(request,response);
			}
		
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
	}
}
