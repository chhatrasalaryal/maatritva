package com.user;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDAO;

import com.util.Utility;

@SuppressWarnings("serial")
public class PrivatequestionExpert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd1=null;	
	String action=	req.getParameter("action");
	if(action.equals("get"))
	{
		
	   rd1=req.getRequestDispatcher("/jsp/user/ExperttoCreateQuestions.jsp");
		rd1.forward(req, resp);
		
		
		
		
	}
	
	if(action.equals("POST"))
	{
	
		
	String gynoname=	req.getParameter("gname");
	System.out.println("gynoname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+gynoname);
	HttpSession session = req.getSession(true);
	
	session.setAttribute("gynoname", gynoname);
	String uid=	(String) session.getAttribute("uid");
	System.out.println( " uid is >>>>>>>>>>>>>>>>>>>>>>"+uid);
	String question_type="gyano";
	if(Utility.parse1(req.getParameter("add")).equals("YES"))
	{
		
	      String	question = req.getParameter("question");
			System.out.println("question>>>>>>>>>>>>>>>>>>>>>>>>>>"+question);
			
		 /*	boolean flag11=AdminDAO.addquestion(uid,question,question_type);
    		System.out.println("flg11 value is >>>>>>>>>>>>>>>>>"+flag11);*/
    		String data3=question.toLowerCase();
			System.out.println("**Lower case Covert File :***\n"+data3);
		
		
			String data2=Program.filterwords(data3);
			
			
			
			System.out.println("**data2 is >>>>>>>>>>>>>>>>>:***\n"+data2);
			
			String dat = TextSearch.text_Search(data2);
			
			 System.out.println("List Of words :"+dat);
			   
			   // Filter Process
			   ArrayList key_data = TextSearch.text_filter(dat);
			   
			   System.out.println("filtered keywords are  :"+key_data);
			   
			   
			   StringBuffer sb = new StringBuffer();
			   for(int i=0;i<key_data.size();i++)
			   {
				  
				   sb.append(key_data.get(i)+"-");
				  
			   }
			   
		int qno=TextSearch.text_count11(key_data,uid,question,question_type,gynoname);
			   
			System.out.println("qno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+qno);   
			   TextSearch.text_count(qno,key_data,uid);
			   
			   
			   int tot = AdminDAO.gettotal(qno);
			   
			   boolean status = AdminDAO.updatetotal(uid,question,tot,qno);
			   
			   //Find Ranking 
			  TextSearch.Calculate_Rank(uid,qno);
			  
			  //ranking similarity checking---starts--------------------------
			  //ranking similarity checking--- ends--------------------------
			    rd1=req.getRequestDispatcher("/jsp/user/ExperttoCreateQuestions.jsp?no=1");
				rd1.forward(req, resp);
			
			
					 
			}
			else
			{
				rd1=req.getRequestDispatcher("/jsp/user/ExperttoCreateQuestions.jsp?no=3");
				rd1.forward(req, resp);
			}
	   }
	if(action.equals("VIEW SIMILAR POSTS"))
	{
		
		AdminDAO.truntabletemp();
		AdminDAO.truntablefinaltemp();
		String question_type="gyano";
		String gynoname=req.getParameter("gname");
		System.out.println("gynoname>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+gynoname);
		
		StringBuffer sb=new StringBuffer();
		String matcheddata="";
		if(Utility.parse1(req.getParameter("add")).equals("YES"))
		{	
			
			HttpSession session = req.getSession(true);
			String uid=	(String) session.getAttribute("uid");
			System.out.println( " uid is >>>>>>>>>>>>>>>>>>>>>>"+uid);
			
			  String	question = req.getParameter("question");
				System.out.println("question>>>>>>>>>>>>>>>>>>>>>>>>>>"+question);
				String data3=question.toLowerCase();
				System.out.println("**Lower case Covert File :***\n"+data3);
			
			
				String data2=Program.filterwords(data3);
				
				System.out.println("**data2 is >>>>>>>>>>>>>>>>>:***\n"+data2);
				
				String dat = TextSearch.text_Search(data2);
				
				 System.out.println("List Of words :"+dat);
				   
				   // Filter Process
				   ArrayList key_data = TextSearch.text_filter(dat);
				   
				   System.out.println("filtered keywords are  :"+key_data);
				String questions=   AdminDAO.getparticularExpertname(gynoname,question_type);
				
				System.out.println("questions is >>>>>>>>>>>>>>>>>>>>>>>>>>"+questions);
				
				String que[]=questions.split("~");
				
				for(int j=0;j<que.length;j++)
				{
			
				   for(int i=0;i<key_data.size();i++)
				   {
					  
					 
					   
		          matcheddata=	 AdminDAO.checkkeyword1(key_data.get(i).toString(),que[j]);
					   
			       System.out.println("matcheddata is>>>>>>>>>>>>>>>>>>>>>>>>>>"+matcheddata);		   
					   
				        sb.append(matcheddata);	   
			   
					 
				   }
				   
				}
				
				 if(sb.toString().equals("")||sb.toString().isEmpty() || sb.toString()==null)
				   {
					   
					   
					   
						
					    rd1=req.getRequestDispatcher("/jsp/user/ExperttoCreateQuestions.jsp?no=9");
						rd1.forward(req, resp);
					   
					   
				   }
				 
				 else
				
					 
				 {
				
					System.out.println("final sb.tostring is>>>>>>>>>>>>>>>>>>>>>>>>>>"+sb.toString());		   
			         String splitteddaata="";
		           String queno="";
		             String userid="";
		           String keyrank="";
	                String data[]=sb.toString().split("~~");
			
	                for(int i=0;i<data.length;i++)
					   {
	                	
	                	splitteddaata=data[i];
	                	System.out.println("splitteddaata>>>>>>>>>>>>>>>>>>>>>>>>>>"+splitteddaata);		
	                	
	              String uniquedata[]=  	splitteddaata.split("~");
	                	
	             queno=   uniquedata[0];
	             System.out.println("queno>>>>>>>>>>>>>>>>>>>>>>>>>>"+queno);	
	            userid=    uniquedata[1];
	            System.out.println("userid>>>>>>>>>>>>>>>>>>>>>>>>>>"+userid);	
	             keyrank=  uniquedata[2];
	             System.out.println("keyrank>>>>>>>>>>>>>>>>>>>>>>>>>>"+keyrank);	
	             
	             AdminDAO.storetempvalues(Integer.parseInt(queno),userid,keyrank);
	                	
					   }
			
	      String distictquestionum=          AdminDAO.distinctquestionum();
	      System.out.println("distictquestionum>>>>>>>>>>>>>>>>>>>>>>>>>>"+distictquestionum);		      
	 String[] uniqueno=     distictquestionum.split("~");
			
	      for(int i=0;i<uniqueno.length;i++)
		   {
	    	  
	    	  AdminDAO.getrankingoffile(uniqueno[i],userid,keyrank);
	    	 
	    	  
		   
		   }
	      
	      for(int i=0;i<uniqueno.length;i++)
		   {
	    	  
	    	  AdminDAO.insertintofinaltemp(uniqueno[i],gynoname,question_type);
	    	  
	    	  
		   }
			
			
	        ResultSet rs= AdminDAO.finalgyanoresults(gynoname,question_type);	
			req.setAttribute("rs",rs);
			rd1=req.getRequestDispatcher("/jsp/user/viewExpertsimilarposts.jsp");
			rd1.forward(req, resp);
		
		
		
		
		
		
		
		
		}
		
		
		}
		
		
		
		else
		{
			
			
			
			rd1=req.getRequestDispatcher("/jsp/user/ExperttoCreateQuestions.jsp?no=3");
			rd1.forward(req, resp);
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	}
	
		}
		



