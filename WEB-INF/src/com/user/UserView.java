package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;

public class UserView  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try
		{
			RequestDispatcher rd=null;
			boolean result=false;
			boolean flag=false;
			HttpSession hs=req.getSession();
			String action=	req.getParameter("action");
			
			System.out.println("action is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+action);
			if(action.equals("get"))
			{
				
				RequestDispatcher rd1=req.getRequestDispatcher("/jsp/user/ViewUserDetail.jsp");
				rd1.forward(req, resp);
				
				
				
				
			}
			
			
			if(action.equals("EDIT"))
			{
				
			String ucode=	req.getParameter("ucode");
			System.out.println(" ucode is >>>>>>>>>>>>>>>>>>"+ucode);
			
			  hs.setAttribute("ucode", ucode);
			
				RequestDispatcher rd1=req.getRequestDispatcher("/jsp/user/EditUserDetail.jsp");
				rd1.forward(req, resp);
				
				
				
				
			}
				
			
			
			if(action.equals("UPDATE"))
			{
				
			String ucode=	req.getParameter("ucode");
			System.out.println(" ucode is ddd>>>>>>>>>>>>>>>>>>"+ucode);
			
		
			
String uid=		req.getParameter("uid");

String name=		req.getParameter("name");
String city=		req.getParameter("city");
String state=		req.getParameter("state");

String email=		req.getParameter("email");
String cell=		req.getParameter("cell");
/*String prob=		req.getParameter("message");*/
String age=		req.getParameter("age");
String gname=		req.getParameter("gname");
String sex=		req.getParameter("sex");
/*String pl=		req.getParameter("pl");*/

System.out.println("uid>>>>>>>>>"+uid);

System.out.println("name>>>>>>>>>"+name);
System.out.println("city>>>>>>>>>"+city);
System.out.println("state>>>>>>>>>"+state);
/*System.out.println("prob>>>>>>>>>"+prob);*/
System.out.println("email>>>>>>>>>"+email);
System.out.println("cell>>>>>>>>>"+cell);
System.out.println("age>>>>>>>>>"+age);
System.out.println("gname>>>>>>>>>"+gname);
System.out.println("sex>>>>>>>>>"+sex);
/*System.out.println("pl>>>>>>>>>"+pl);*/
				
				
boolean flag1=AdminDAO.Updatedetails(uid,name,city,state,email,cell,age,gname,sex,ucode);	
if(flag1)
{
	
	rd=req.getRequestDispatcher("/jsp/user/ViewUserDetail.jsp");
	rd.forward(req,resp);	
}


else
{
	
	
	rd=req.getRequestDispatcher("/jsp/user/EditUserDetail.jsp?no=1");
	rd.forward(req,resp);	
	
}
				
			}
				
			





		
	}
		
		catch (Exception e)
		{
		
	    }
	}
}
