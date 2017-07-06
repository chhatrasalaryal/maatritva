package com.user;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;


public class ViewRateGyano extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd1=null;	
		boolean flag = false;
		boolean flag1 = false;
		ResultSet rs=null;
	String action=	req.getParameter("action");
	
	System.out.println("action is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+action);
	if(action.equals("get"))
	{
	    ResultSet rs1=AdminDAO.getGyano();
	    req.setAttribute("rs", rs1);
	    rd1=req.getRequestDispatcher("/jsp/user/gyanolist.jsp");
		rd1.forward(req, resp);
		
		
	}
	
	if(action.equals("RATE"))
	{
		String []chk=req.getParameterValues("chk");
		
		 if(chk==null)
		{
			rs=AdminDAO.getGyano();
			req.setAttribute("rs", rs);
			rd1=req.getRequestDispatcher("/jsp/user/gyanolist.jsp?no=2");
			rd1.forward(req,resp);
		}
	 if(chk.length!=1)
		{
			rs=AdminDAO.getGyano();
			req.setAttribute("rs", rs);
			rd1=req.getRequestDispatcher("/jsp/user/gyanolist.jsp?no=4");
			rd1.forward(req,resp);
		}
	  if(chk.length==1)
		{
			rs=AdminDAO.getGyano(chk[0]);
			req.setAttribute("rs", rs);
			rd1=req.getRequestDispatcher("/jsp/user/viewgynocolist.jsp");
			rd1.forward(req,resp);
		}
	}

	if(action.equals("Upadte"))
		
	{
		HttpSession session = req.getSession(true);
	   String username=	(String) session.getAttribute("uid");
		String id=	req.getParameter("id");	
		System.out.println("id is >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id);
		String name=	req.getParameter("name");	
		System.out.println("name is >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name);
		
		
		
		
		String	 stars=req.getParameter("stars");
	    System.out.println(" before stars>>>>>>>>>>>>>>>>>>>>>>>>>>>"+stars);	
		int rr=	 Integer.parseInt(stars)+1;
		    System.out.println("stars>>>>>>>>>>>>>>>>>>>>>>>>>>>"+rr);	
		
		
		    flag1 =AdminDAO.addgynocologistratinglist(id,rr,username);
		    
		    if(flag1)
		    {
		    	
		    	rs=AdminDAO.getGyano();
				req.setAttribute("rs", rs);
				rd1=req.getRequestDispatcher("/jsp/user/gyanolist.jsp?no=5");
				rd1.forward(req,resp);
		    	
		    }
		    
		    else
		    {
		    	
		    	
		    	rs=AdminDAO.getGyano();
				req.setAttribute("rs", rs);
				rd1=req.getRequestDispatcher("/jsp/user/gyanolist.jsp?no=6");
				rd1.forward(req,resp);	
		    	
		    	
		    	
		    }
		
		
		
	}
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

