
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.AdminDAO;
import com.util.Utility;


@SuppressWarnings("serial")
public class Users extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
	
		String uid="",pass="",name="",age="",city="",state="",sex="",spec="",email="",cell="";
		
		
		try
		{
			
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getUsesr();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/Users.jsp");
				rd.forward(request, response);
			}
			
	
			
			
if(submit.equals("Edit"))
	{
	System.out.println("submit is  editttttttt>>>>>>>>>>>"+submit);
	String [] chk=request.getParameterValues("chk");
	
 	if(Utility.parse1(request.getParameter("edit")).equals("YES"))
	{
				
					String id =request.getParameter("uid");
					
					System.out.println("id is  indisde isf>>>>>>>>>>>"+id);
				  String	name1 = request.getParameter("name");
				  String	age1 = request.getParameter("age");
				   String city1  = request.getParameter("city");
					String statee = request.getParameter("state");
					 String status  = request.getParameter("status");
						String gyano = request.getParameter("gyano");
						
					String sexx = request.getParameter("sex");
					String specc = request.getParameter("spec");
					String eamill = request.getParameter("email");
					String cell1 = request.getParameter("cell");
					
				
				System.out.println(""+id+name1+age1+city1+statee+sexx+eamill+cell1);	
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(id);
					list.add(name1);
					list.add(age1);
					list.add(city1);
					list.add(statee);
					list.add(status);
					list.add(gyano);
					list.add(sexx);
					list.add(specc);
					list.add(eamill);
					list.add(cell1);
					
					flag = AdminDAO.updateUSesrDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getUsesr();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getUsesr(chk[0]);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/edituser.jsp?no=2");
						rd.forward(request,response);
					}
			}	
			
				else if(chk==null)
				{
					rs=AdminDAO.getUsesr();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getUsesr();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getUsesr(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/edituser.jsp");
					rd.forward(request,response);
				}
		
			}


if(submit.equals("Update"))
{
System.out.println("submit is  editttttttt>>>>>>>>>>>"+submit);


if(Utility.parse1(request.getParameter("edit")).equals("YES"))
{
	

	String id =request.getParameter("uid");
	
	System.out.println("id is  indisde isf>>>>>>>>>>>"+id);
  String	name1 = request.getParameter("name");
  String	age1 = request.getParameter("age");
   String city1  = request.getParameter("city");
	String statee = request.getParameter("state");
	 String status  = request.getParameter("status");
		String gyano = request.getParameter("gyano");
		
	String sexx = request.getParameter("sex");
	String specc = request.getParameter("spec");
	String eamill = request.getParameter("email");
	String cell1 = request.getParameter("cell");
	

System.out.println(""+id+name1+age1+city1+statee+sexx+eamill+cell1);	
	
	ArrayList<String> list = new ArrayList<String>();
	list.add(id);
	list.add(name1);
	list.add(age1);
	list.add(city1);
	list.add(statee);
	list.add(status);
	list.add(gyano);
	list.add(sexx);
	list.add(specc);
	list.add(eamill);
	list.add(cell1);
		
		flag = AdminDAO.updateUSesrDetails(list);
		
		if(flag)
		{
			rs=AdminDAO.getUsesr();
			request.setAttribute("rs", rs);
			rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=5");
			rd.forward(request,response);
		}
		else
		{
			rs=AdminDAO.getUsesr(id);
			request.setAttribute("rs", rs);
			rd=request.getRequestDispatcher("/jsp/admin/edituser.jsp?no=2");
			rd.forward(request,response);
		}
}	

	

}
			
		
			if(submit.equals("Delete"))
			{
				String []chk1=request.getParameterValues("chk");
				
			
					//Without Delete Confirmation
					if(chk1==null)
					{
						rs=AdminDAO.getUsesr();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=2");
						rd.forward(request,response);
					}
					else
					{
						
					
				
				
				//With Delete Confirmation
				
				for(int i=0;i<chk1.length;i++)
				{
					String eid = chk1[i];
					AdminDAO.deleteUsersDetails(eid);
					
				}
				rs=AdminDAO.getUsesr();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/Users.jsp?no=3");
				rd.forward(request,response);
			}
		
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin Companylist  Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin companylist Servlet : "+e);
		}
	}
}
