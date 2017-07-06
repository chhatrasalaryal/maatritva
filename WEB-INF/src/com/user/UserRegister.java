package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.AdminDAO;

public class UserRegister  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try
		{
			
			System.out.println("its came inside userregister");
			
			AdminDAO adminDAO=AdminDAO.getInstance();
			RequestDispatcher rd=null;
			boolean result=false;
			boolean flag=false;
String uid=		req.getParameter("uid");
String pass=		req.getParameter("pass");
String name=		req.getParameter("name");
String city=		req.getParameter("city");
String state=		req.getParameter("state");
String message=		req.getParameter("message");
String email=		req.getParameter("email");
String cell=		req.getParameter("cell");
String age=		req.getParameter("age");
String gname=		req.getParameter("gname");
String sex=		req.getParameter("sex");
String pl=		req.getParameter("pl");

System.out.println("uid>>>>>>>>>"+uid);
System.out.println("pass>>>>>>>>>"+pass);
System.out.println("name>>>>>>>>>"+name);
System.out.println("city>>>>>>>>>"+city);
System.out.println("state>>>>>>>>>"+state);
System.out.println("message>>>>>>>>>"+message);
System.out.println("email>>>>>>>>>"+email);
System.out.println("cell>>>>>>>>>"+cell);
System.out.println("age>>>>>>>>>"+age);
System.out.println("gname>>>>>>>>>"+gname);
System.out.println("sex>>>>>>>>>"+sex);
System.out.println("pl>>>>>>>>>"+pl);

if(pl.equals("yes"))
{
	
	System.out.println("its came inside if");
	
	if(uid!=null && pass!=null && name!=null && city!=null && state!=null && message!=null && email!=null && cell!=null && age!=null && gname!=null && sex!=null && pl!=null)
	{
	flag=adminDAO.checkUserExistence(uid);
	
	 if(!flag)
	 {
		 
		 
		 
		 
	
   result=adminDAO.addUserDetails(uid, pass,name,city,state,message,email,cell,age,gname,sex,pl);
	
	if(result)
	{
		
		
	
		rd=req.getRequestDispatcher("/plregistration.jsp?no=1");
		rd.forward(req,resp);
		
		
	}
	
	else
	{
		
		rd=req.getRequestDispatcher("/plregistration.jsp?no=2");
		rd.forward(req,resp);
		
		
		
	}
	 }
	 
	 else
	 {
		 
		 
		 rd=req.getRequestDispatcher("/plregistration.jsp?no=3");
			rd.forward(req,resp); 
		 
		 
	 }
	
}
	else
	{
		
		
		 rd=req.getRequestDispatcher("/plregistration.jsp?no=11");
			rd.forward(req,resp); 
		 	
		
	}
}
else
{
	
	System.out.println("its came inside else");
	if(uid!=null && pass!=null && name!=null && city!=null && state!=null && message!=null && email!=null && cell!=null && age!=null && gname!=null && sex!=null && pl!=null)
	{
	flag=adminDAO.checkUserExistence(uid);
	
	if(!flag)
	 {
	
	
	   result=adminDAO.addUserDetails(uid, pass,name,city,state,message,email,cell,age,gname,sex,pl);
		
		if(result)
		{
			
			
		
			rd=req.getRequestDispatcher("/plregistration.jsp?no=1");
			rd.forward(req,resp);
			
			
		}
		
		else
		{
			
			rd=req.getRequestDispatcher("/plregistration.jsp?no=2");
			rd.forward(req,resp);
			
			
			
		}
		
			
	 }
	 
	 else
	 {
		 
		 
		 rd=req.getRequestDispatcher("/plregistration.jsp?no=3");
			rd.forward(req,resp); 
		 
		 
	 }
	
}



	else
	{
		
		 rd=req.getRequestDispatcher("/plregistration.jsp?no=11");
			rd.forward(req,resp); 
		
		
		
	}
		







		
	}





	}
		
		
		
		catch (Exception e)
		{
		
	    }
	}
}
