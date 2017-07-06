package com.experts;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;


public class AnswerPrivateQuestions extends HttpServlet {
	
	
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
		
		String usertype="gyano";
		
		HttpSession hs=req.getSession();
	String expert=	(String) hs.getAttribute("expert");
	System.out.println("expert>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+expert);
		
	    ResultSet rs1=AdminDAO.getprivatepostings(usertype,expert);
	    req.setAttribute("rs", rs1);
	    rd1=req.getRequestDispatcher("/jsp/expert/Answertoprivatequestions.jsp");
		rd1.forward(req, resp);
		
		
	}
	
	if(action.equals("Answer"))
	{
		
		HttpSession hs=req.getSession();
		String expert=	(String) hs.getAttribute("expert");
		System.out.println("expert>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+expert);
		 String qno=	req.getParameter("qno");
		 String usertype="gyano";
		 HttpSession session=req.getSession(true);
		 session.setAttribute("qno", qno);
		 ResultSet rs1=AdminDAO.getprivatepostingss(qno,usertype,expert);
		 System.out.println("question number is >>>>>>>>>>>>>>>>>>>>>>>>"+qno);
	     req.setAttribute("rs", rs1);
	  
		 rd1=req.getRequestDispatcher("/jsp/expert/AnswertoprivatequestionsExpert.jsp");
		 rd1.forward(req, resp);
		
	}

	if(action.equals("POST_ANSWER"))
	{
		String qno=	req.getParameter("qno");
		 String usertype="gyano";
		String answer=	req.getParameter("answer");
		System.out.println("answer is >>>>>>>>>>>>>>>>"+answer);
		String question=	req.getParameter("question");
		System.out.println("question is >>>>>>>>>>>>>>>>"+question);
		String name=	req.getParameter("name");
		
		System.out.println("Expert Name  is >>>>>>>>>>>>>>>>"+name);
		 boolean  flagg=AdminDAO.upadteprivateanswer(qno,usertype,answer,question,name);
		 
		 if(flagg)
		 {
		
		    rd1=req.getRequestDispatcher("/jsp/expert/experthome.jsp?no=1");
			rd1.forward(req, resp);
		 }
		 
		 else
		 {
			 
			    rd1=req.getRequestDispatcher("/jsp/expert/experthome.jsp?no=2");
				rd1.forward(req, resp); 
			 
			 
			 
		 }
		
		
		
		
		
	}

	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

