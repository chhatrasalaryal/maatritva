
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
public class Expert extends HttpServlet 
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
			
			rs=AdminDAO.getexpert();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp");
				rd.forward(request, response);
			}
			
		if(submit.equals("AddExpert"))
			{
			
			/*rd=request.getRequestDispatcher("/jsp/admin/addexpert.jsp?no=2");
			rd.forward(request, response);*/
			
			if(Utility.parse1(request.getParameter("add")).equals("YES"))
			{
				
			uid = request.getParameter("uid");
					System.out.println("uid>>>>>>>>>>>>>>>>>>>>>>>>>>"+uid);
					
					pass = request.getParameter("pass");
					System.out.println("pass>>>>>>>>>>>>>>>>>>>>>>>>>>"+pass);
					
					name = request.getParameter("name");
					//cmpnycode =	Integer.parseInt("companycode");
					System.out.println("name>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
					
					age = request.getParameter("age");
					//companycell11 =	Integer.parseInt("companycell");
					System.out.println("age>>>>>>>>>>>>>>>>>>>>>>>>>>"+age);
				
					city = request.getParameter("city");
					//landline =	Integer.parseInt("companylandline");
					System.out.println("city>>>>>>>>>>>>>>>>>>>>>>>>>>"+city);
					
					state = request.getParameter("state");
					//userid =	Integer.parseInt("companyuserid");
					System.out.println("state>>>>>>>>>>>>>>>>>>>>>>>>>>"+state);
					
					sex = request.getParameter("sex");
					System.out.println("sex>>>>>>>>>>>>>>>>>>>>>>>>>>"+sex);
					
					spec = request.getParameter("spec");
					System.out.println("spec>>>>>>>>>>>>>>>>>>>>>>>>>>"+spec);
				email = request.getParameter("email");
					System.out.println("email>>>>>>>>>>>>>>>>>>>>>>>>>>"+email);
						cell = request.getParameter("cell");
						System.out.println("cell>>>>>>>>>>>>>>>>>>>>>>>>>>"+cell);
				 flag = AdminDAO.checkExpertExistance(uid);
					
					if(!flag)
					{
						flag = AdminDAO.addexpertDetails(uid, pass, name, age,city,state,sex,spec,email,cell);
						
						
						if(flag)
						{
							rs=AdminDAO.getexpert();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/jsp/admin/addexpert.jsp?no=2");
							rd.forward(request, response);
						}
							 
					}
					else
					{
						rd=request.getRequestDispatcher("/jsp/admin/addexpert.jsp?no=3");
						rd.forward(request, response);
					}
			   }
			else
			{
				rd=request.getRequestDispatcher("/jsp/admin/addexpert.jsp");
				rd.forward(request, response);
			}
				}
				
			
			
if(submit.equals("Edit"))
	{
	System.out.println("submit is  editttttttt>>>>>>>>>>>"+submit);
	String [] chk=request.getParameterValues("chk");
	
 	if(Utility.parse1(request.getParameter("edit")).equals("YES"))
	{
				System.out.println("submit is  indisde isf>>>>>>>>>>>"+chk);
					String id =request.getParameter("eid");
					
					System.out.println("id is  indisde isf>>>>>>>>>>>"+id);
				  String	name1 = request.getParameter("name");
				  String	age1 = request.getParameter("age");
				   String city1  = request.getParameter("city");
					String statee = request.getParameter("state");
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
					list.add(sexx);
					list.add(specc);
					list.add(eamill);
					list.add(cell1);
					
					flag = AdminDAO.updateExpertDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getexpert();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getexpert(chk[0]);
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/editexpert.jsp?no=2");
						rd.forward(request,response);
					}
			}	
			
				else if(chk==null)
				{
					rs=AdminDAO.getexpert();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getexpert();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getexpert(chk[0]);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/jsp/admin/editexpert.jsp");
					rd.forward(request,response);
				}
		
			}


if(submit.equals("Update"))
{
System.out.println("submit is  editttttttt>>>>>>>>>>>"+submit);


if(Utility.parse1(request.getParameter("edit")).equals("YES"))
{
	
		String id =request.getParameter("id");
		
		System.out.println("id is  indisde isf>>>>>>>>>>>"+id);
	  String	name1 = request.getParameter("name");
	  String	age1 = request.getParameter("age");
	   String city1  = request.getParameter("city");
		String statee = request.getParameter("state");
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
		list.add(sexx);
		list.add(specc);
		list.add(eamill);
		list.add(cell1);
		
		flag = AdminDAO.updateExpertDetails(list);
		
		if(flag)
		{
			rs=AdminDAO.getexpert();
			request.setAttribute("rs", rs);
			rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=5");
			rd.forward(request,response);
		}
		else
		{
			rs=AdminDAO.getexpert(id);
			request.setAttribute("rs", rs);
			rd=request.getRequestDispatcher("/jsp/admin/editexpert.jsp?no=2");
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
						rs=AdminDAO.getexpert();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=2");
						rd.forward(request,response);
					}
					else
					{
						
					
				
				
				//With Delete Confirmation
				
				for(int i=0;i<chk1.length;i++)
				{
					String eid = chk1[i];
					AdminDAO.deleteExpertDetails(eid);
					
				}
				rs=AdminDAO.getexpert();
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/jsp/admin/Expert.jsp?no=3");
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
