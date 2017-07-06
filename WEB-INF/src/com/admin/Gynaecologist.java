package com.admin;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DAO.AdminDAO;





public class Gynaecologist extends HttpServlet 
 {
	
	ArrayList list =  new ArrayList();
	String s = "";
	ResultSet rs=null; 
	boolean flag=false;
	boolean flag11=false;
	int autoincr=0;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		
		
		RequestDispatcher rd=null;
		String submit=request.getParameter("action");
	
		
		
		 System.out.println("its came inside addproductlist");    
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 System.out.println("ismultiaprt is "+isMultipart); 
		 
			ArrayList list =  new ArrayList();
			String s = "";
			String fileName="";
			String filepath = "";
		  if (isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try
				{
				
				List items = upload.parseRequest(request);
	          	Iterator iterator = items.iterator();
	            while (iterator.hasNext()) 
	            {
	            	FileItem item = (FileItem) iterator.next();
	            	if (item.isFormField()) 
	            	{
	            		s = item.getString();
                    	list.add(s);//All Form Field Values
                    	System.out.println("list is >>>>>>>>>>>>>"+list);
                    	
	            	}
	            	else 
	            	{
	            	
	            		
	            	 
	            	 
	            	 
	            		 fileName = item.getName();
	            		 if(fileName!="")
	            		 filepath = request.getRealPath("")+"\\Gyno_image\\"+fileName;
		  	             File f1=new File(filepath);
		  	             item.write(f1);
		  	             flag = true;
		  	            
	            	}
	            }
	            System.out.println("*******  Image Information *******");
	            System.out.println("File Name : " + fileName);
	            System.out.println("list data is  : " + list);
	            System.out.println("size of data is >>>>>>>>>>> : " + list.size());
	            
	            
	        	if(flag)
	    		{
	        		System.out.println("its acme inside if block>>>>>>>>>>>>>>>>>>>>");
	        		
	        		
              String id=(String) list.get(1);
	        		
	        		System.out.println("id>>>>>>>>>>>>>>>>>>>>>"+id);
	        		String password=(String) list.get(2);
	        		System.out.println("password>>>>>>>>>>>>>>>>>>>>>"+password);
	        		String name=(String) list.get(3);
	        		
	        		System.out.println("name>>>>>>>>>>>>>>>>>>>>>"+name);
	        		String age=(String) list.get(4);
	        		System.out.println("age>>>>>>>>>>>>>>>>>>>>>"+age);
	        		String city=(String) list.get(5);
	        		System.out.println("city>>>>>>>>>>>>>>"+city);
	        		
	        		String state=(String) list.get(6);
	        		System.out.println("state>>>>>>>>>>>>>>"+state);
	        		
	        		String email=(String) list.get(7);
	        		System.out.println("email>>>>>>>>>>>>>>"+email);
	        		
	        		
	        		
                     String phone=(String) list.get(8);
	        		
	        		System.out.println("phone>>>>>>>>>>>>>>>>>>>>>"+phone);
	        		
	        		
	        		
	        		String sex=(String) list.get(9);
	        		/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        		Date date = (Date) formatter.parse(dob);*/
	        		System.out.println("sex>>>>>>>>>>>>>>>>>>>>>"+sex);
	        		
	        		
	        		
	        		String rate=(String) list.get(10);
	        		System.out.println("rate>>>>>>>>>>>>>>"+rate);
	        		
	        	int ra=	Integer.parseInt(rate)+1;
	        		
	        		
	        		
	        		
	        		
	        		String spec=(String) list.get(11);
	        		System.out.println("spec is >>>>>>>>>>>>"+spec);
	        		
	        		
	        
	        		
	    			
	        		 flag = AdminDAO.checkGyanoExistance(id);
	        		
	        		 if(!flag)
	        		 {
	        		
	           	boolean flag11=AdminDAO.addGyanoDetails(name,age,city,state,email,phone,sex,String.valueOf(ra),spec,fileName,id,password);
	        		System.out.println("flg11 value is >>>>>>>>>>>>>>>>>"+flag11);
	        		
	        		if(flag11)
	        		{
	        			
	        			RequestDispatcher rd1=request.getRequestDispatcher("/jsp/admin/addgynocolist.jsp?no=1");
	        			rd1.forward(request, response);
	        			
	        		}else
	        		{
	        			
	        			
	        			RequestDispatcher rd1=request.getRequestDispatcher("/jsp/admin/addgynocolist.jsp?no=2");
	        			rd1.forward(request, response);
	        			
	        			
	        		}
	        		 }else
	        		 {
	        			 
	        			 
	        			 

		        			RequestDispatcher rd1=request.getRequestDispatcher("/jsp/admin/addgynocolist.jsp?no=3");
		        			rd1.forward(request, response); 
	        			 
	        			 
	        			 
	        			 
	        			 
	        		 }
				}
				
				}
				
	        	catch (Exception e) {
					
				}
				
				
		}
	}
		
	
		
	
	
	
	}


