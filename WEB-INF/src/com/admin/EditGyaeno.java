package com.admin;



import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DAO.AdminDAO;





public class EditGyaeno extends HttpServlet
{

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		LinkedHashMap<String, String> data = new LinkedHashMap<>();	
		int trans_id=0;
		
		
		
		
		
		System.out.println("its acme inside if block>>>>>>>>>>>>>>>>>>>>");
		
		String no="";
		
		String name="";
		
		
		String shortname="";
		
		
		
		
         String adress="";
		
	

		
		String sex="";
		
		
		
		
		String dob="";
		
		
		String bld="";
		
		
		
		
		
		
		
		String cell="";
	
		String mail="";
		
		
		String stime="";
		
		
		String etime="";
		
		
		String status="";
		
		
		String remark="";
		
		String id="";
		
		
		ResultSet rs = null;
		String submit=null;
		
		RequestDispatcher rd = null;
	
		String filenametostore="";
	
			
		
		boolean flagff=false;
	
		
		
		String fileName =null;
		
		int i=0;
		String root = null;
		File uploadedFile = null;
		ArrayList<String> list = new ArrayList<String>();
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		String state="";
		
		
			try{
				
				
				FileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
				List fileItems = servletFileUpload.parseRequest(request);
				
				
				
				
				Iterator iterator = fileItems.iterator();
				int s=fileItems.size();
				for(int j=0;j<s;j++)
				{
					FileItem one =(FileItem)fileItems.get(j);
					one.getFieldName();
					String str=one.getContentType();
					
				
					
					if(str=="application/octet-stream")
					{
						
						
					}
				
					
						 
						  data.put(one.getFieldName().toString(), one.getString().toString());
						
						
					
					 
				}
				
				
				
				
		String	name1=(String) data.get("name");
        		System.out.println("name>>>>>>>>>>>>>>>>>>>>>>>>>>>"+name1);
        		
				
			
		String	age=(String) data.get("age");
				 System.out.println("age>>>>>>>>>>>>>>>>>>>>>>>>>>>"+age);
				
				 String	 city=(String) data.get("city");
				
			 System.out.println("city>>>>>>>>>>>>>>>>>>>>>>>>>>>"+city);
				
				
			 String state1=(String) data.get("state");
				
		       System.out.println("state>>>>>>>>>>>>>>>>>>>>>>>>>>>"+state1);

				
		       String   email=(String) data.get("email");
				
				
			 System.out.println("email>>>>>>>>>>>>>>>>>>>>>>>>>>>"+email);
				
			 String	 phone=(String) data.get("phone");
				
				 System.out.println("phone>>>>>>>>>>>>>>>>>>>>>>>>>>>"+phone);
				 
				
				
				
				
				 String	 sex1=(String) data.get("sex");
				 System.out.println("sex>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sex1);
					
				 String	 stars=(String) data.get("stars");
				 
			int rr=	 Integer.parseInt(stars)+1;
			    System.out.println("stars>>>>>>>>>>>>>>>>>>>>>>>>>>>"+stars);
				
			    String   spec=(String) data.get("spec");
				 System.out.println("spec>>>>>>>>>>>>>>>>>>>>>>>>>>>"+spec);
				
				 String	 id1=(String) data.get("id");
				 System.out.println("id>>>>>>>>>>>>>>>>>>>>>>>>>>>"+id1);
				
				
				
				
				
				
				
				 while (iterator.hasNext())
					{
						FileItem item = (FileItem) iterator.next();
						long size=item.getSize();
				
						if (item.isFormField())
						{
							
						} 
						else if(size!=0)
						{
							String format = "none";
							fileName = item.getName();
						
				              //root = request.getContextPath()+("/UploadedFiles");
				
				                 root = request.getRealPath("/Gyno_image");
						

	                         File ff=new File(root);
	                         if (!ff.exists()) 
	                              {
	                                ff.mkdirs();
	                              }
							
							
							int index = fileName.lastIndexOf(".");
							if(index > 0)
							{
							               format = fileName.substring(index+1);
							               format = format.toLowerCase();
							}
							
							filenametostore=fileName;
							
							uploadedFile = new File(root +"/"+filenametostore);
							
						
							item.write(uploadedFile);
							
							
					
			}
						
						
		} 
				

	        		
	        		
	        		boolean flag11=AdminDAO.Updategyanodetails(name1,age,city,state1,email,phone,sex1,String.valueOf(rr),spec,id1);
	        		System.out.println("flg11 value is >>>>>>>>>>>>>>>>>"+flag11);
	        		
	        		if(flag11)
	        		{
	        			rs=AdminDAO.getGyano();
						request.setAttribute("rs", rs);
	        			RequestDispatcher rd1=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=1");
	        			rd1.forward(request, response);
	        			
	        		}else
	        		{
	        			rs=AdminDAO.getGyano(id1);
						request.setAttribute("rs", rs);
	        			
	        			RequestDispatcher rd1=request.getRequestDispatcher("/jsp/admin/gyanolist.jsp?no=-1");
	        			rd1.forward(request, response);
	        			
	        			
	        		}	

			}catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		
		
		
			
		}
}

