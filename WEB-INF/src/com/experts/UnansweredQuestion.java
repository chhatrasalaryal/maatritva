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


public class UnansweredQuestion extends HttpServlet {
	
	
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
	    ResultSet rs1=AdminDAO.getunansweredQuestions();
	    req.setAttribute("rs", rs1);
	    rd1=req.getRequestDispatcher("/jsp/expert/unansweredquestion.jsp");
		rd1.forward(req, resp);
		
		
	}
	
	if(action.equals("Answer"))
	{
		 String qno=req.getParameter("qno");
		 System.out.println("qno>>>>>>>>>>>>>>>>>>>>>>>>"+qno);
		 HttpSession session=req.getSession(true);
		 session.setAttribute("qno", qno);
		 ResultSet rs1=AdminDAO.getpaticularunanswerd(qno);
	
	     req.setAttribute("rs", rs1);
	  
		 rd1=req.getRequestDispatcher("/jsp/expert/Expertunansweredquestion.jsp");
		 rd1.forward(req, resp);
		
	}

	if(action.equals("POST_ANSWER"))
	{
		String qno=	req.getParameter("qno");
		String users="";
		String answer=	req.getParameter("answer");
		System.out.println("answer is >>>>>>>>>>>>>>>>"+answer);
		String question=	req.getParameter("question");
		System.out.println("question is >>>>>>>>>>>>>>>>"+question);
		String name=	req.getParameter("name");
		
		System.out.println("Expert Name  is >>>>>>>>>>>>>>>>"+name);
		 boolean  flagg=AdminDAO.unansweredquestionanswer(qno,users,answer,question,name);
		 
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

