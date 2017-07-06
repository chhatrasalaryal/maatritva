
package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO()
	{
		
	}
	public static AdminDAO getInstance()
	{
		if(adminDAO == null)
		{
			adminDAO= new AdminDAO();
		}
		return adminDAO;
	}
	public boolean checkAdmin(String admin,String pass)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where name='"+admin+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	
	public boolean checkuser(String user,String pass)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where user_id='"+user+"' and user_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	public boolean checkExpert(String ex,String pass)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_gyano where g_id ='"+ex+"' and g_pass='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkExpert(String ex,String pass): "+ e);
		}
		return flag;
	}
	
	public static boolean checkGyanoExistance(String gyanoname)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_gyano where g_id='"+gyanoname+"'";
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
/* Get Profile Details (Starts) */
	
	public static ResultSet getexpert()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_expert");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getgynocologist()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_gyano");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static ResultSet getGyano()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_gyano");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getcommonpostings()
	{
		
		String datas="users";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where user_type='"+datas+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static ResultSet getunansweredQuestions()
	{
		
		String datas="";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where expert_answer IS NULL or  expert_answer='"+datas +"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static ResultSet getprivatepostings(String usertype,String expert)
	{
		int qno1=0;
		boolean flag=false;
		String datas="users";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select g_code from m_gyano where g_id='"+expert+"'";
			
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				qno1=rs.getInt(1);
			flag=true;
			}
			
			if(flag)
			{
				
				
			
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where expert_id='"+qno1+"' and user_type='"+usertype+"'");
		}
			
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public static ResultSet getprivatepostingss(String qno,String usertype,String expert)
	{
		int qno1=0;
		boolean flag=false;
		String datas="users";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select g_code from m_gyano where g_id='"+expert+"'";
			
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				qno1=rs.getInt(1);
			flag=true;
			}
			
			if(flag)
			{
				
				
			
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where expert_id='"+qno1+"' and user_type='"+usertype+"' and q_no='"+qno+"'");
		}
			
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getcommonpostings11(String qno,String type)
	{
		
		String datas="users";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where user_type='"+datas+"' and q_no='"+qno+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getpaticularunanswerd(String qno)
	{
		
		String datas="";
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_questions where expert_answer IS NULL and q_no='"+qno+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getGyano(String id)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_gyano where g_code='"+id+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getUsesr()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getUsesr1(String userid)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user where user_id='"+userid+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static String getgyanoname(String userid)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select g_name from m_gyano where g_code='"+Integer.parseInt(userid)+"'");
			
			while(resultSet.next())
			{
				
				name=resultSet.getString(1);
				
				
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return name;
	}
	
	
	
	public static ResultSet getGynocologist(String userid)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user where user_id='"+userid+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getUsesr11(int ucode)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user where u_code='"+ucode+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getexpert(String id )
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_expert  where expert_code='"+id+"' ");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getUsesr(String id )
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("select * from m_user  where u_code='"+id+"' ");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static boolean checkExpertExistance(String uid) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_expert where expert_id='"+uid+"'";
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("company Existance : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteExpertDetails(String eid)
	{
		boolean flag=false;
		
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
		String	sqlRoot = "delete from m_expert where expert_code='"+eid+"'";
		
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
				if(i>0)
				{
					flag=true;
				}
			
			System.out.println("Delete company Status : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean deletegyano(String eid)
	{
		boolean flag=false;
		
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
		String	sqlRoot = "delete from m_gyano where g_code='"+eid+"'";
		
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
				if(i>0)
				{
					flag=true;
				}
			
			System.out.println("Delete company Status : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteUsersDetails(String eid)
	{
		boolean flag=false;
		
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
		String	sqlRoot = "delete from m_user where u_code='"+eid+"'";
		
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
				if(i>0)
				{
					flag=true;
				}
			
			System.out.println("Delete company Status : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	public boolean chnagePass(String adminid,String npass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_admin set password='"+npass+"' where name='"+adminid+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean upadtecommonanswer(String qno,String usertype,String answer,String question,String expertname) 
	{
		
		int qno1=0;
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select g_code from m_gyano where g_id='"+expertname+"'";
			
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				qno1=rs.getInt(1);
			flag=true;
			}
			
			if(flag)
			{
				
				
				
				
				connection=dao.connector();
				statement = connection.createStatement();
				sql = "update m_questions set expert_answer='"+answer+"',expert_id='"+qno1+"' where q_no='"+qno+"' and user_type='"+usertype+"' and user_question='"+question+"'";
				System.out.println("******* Change Password Info *********\n");
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("upadtecommonanswer : "+flag);	
				
				
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public static boolean unansweredquestionanswer(String qno,String usertype,String answer,String question,String expertname) 
	{
		
		int qno1=0;
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select g_code from m_gyano where g_id='"+expertname+"'";
			
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				qno1=rs.getInt(1);
			flag=true;
			}
			
			if(flag)
			{
				
				
				
				
				connection=dao.connector();
				statement = connection.createStatement();
				sql = "update m_questions set expert_answer='"+answer+"',expert_id='"+qno1+"'  where q_no='"+qno+"'  and user_question='"+question.trim()+"'";
				System.out.println("******* Change Password Info *********\n");
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("upadtecommonanswer : "+flag);	
				
				
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean upadteprivateanswer(String qno,String usertype,String answer,String question,String expertname) 
	{
		
		int qno1=0;
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select g_code from m_gyano where g_id='"+expertname+"'";
			
			System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				qno1=rs.getInt(1);
			flag=true;
			}
			
			if(flag)
			{
				
				
				
				
				connection=dao.connector();
				statement = connection.createStatement();
				sql = "update m_questions set expert_answer='"+answer+"',expert_id='"+qno1+"' where q_no='"+qno+"' and user_type='"+usertype+"' and user_question='"+question+"'";
				System.out.println("******* Change Password Info *********\n");
				System.out.println(sql);
				int i=statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("upadtecommonanswer : "+flag);	
				
				
				
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	public boolean Updatedetails(String adminid,String npass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_admin set password='"+npass+"' where name='"+adminid+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}
	public boolean chnageExpert(String exid,String npass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_gyano set g_pass='"+npass+"' where g_id='"+exid+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnageExpert() : ");
			e.printStackTrace();
		}
		return flag;
	}
	public boolean chnageuser(String uid,String npass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update  m_user set user_pass='"+npass+"' where  user_id='"+uid+"'";
			System.out.println("******* Change Password Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-chnageExpert() : ");
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean updateExpertDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_expert set expert_name='"+list.get(1)+"',expert_age='"+list.get(2)+"' ,expert_city='"+list.get(3)+"',expert_state='"+list.get(4)+"',expert_sex='"+list.get(5)+"',expert_spec='"+list.get(6)+"',expert_email='"+list.get(7)+"',expert_phone='"+list.get(8)+"' where expert_code='"+list.get(0)+"'";
		
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean updateUSesrDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			
			System.out.println("its came inisde >>>>>>>>>>>>>>>>>>>>>>>");
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set user_name='"+list.get(1)+"' ,user_age='"+list.get(2)+"',user_city='"+list.get(3)+"',user_state='"+list.get(4)+"',user_gyna='"+list.get(5)+"',user_sex='"+list.get(6)+"',user_pstatus='"+list.get(7)+"',user_problem='"+list.get(8)+"',user_email='"+list.get(9)+"',user_cell='"+list.get(10)+"' where user_id='"+list.get(0)+"'";
		
			System.out.println("shanu is >>>>>>>>>>>>>"+sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet getServerSpecificDetails(int serverId)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_cloud where c_id='"+serverId+"'";
			System.out.println("******* Get Specific Server Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getServerSpecificDetails(int serverId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/* Get Specific Server Details (Ends) */
	
/* Add Server Details (Starts) */
	
	public boolean addServerDetails(String hostName, String username, String password, String status,String remarks) 
	{
		boolean flag=false;
		String sql = "";
		String url="";
		try
		{
			url = "ftp://"+hostName;
			
			if(remarks.equals(""))
			{
				remarks = "";
			}
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "insert into m_cloud (c_url,c_username,c_password,c_status,c_remarks) values('"+url+"','"+username+"','"+password+"','"+status+"','"+remarks+"')";
			System.out.println("******* Add Server Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Add Server Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addServerDetails() :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Server Details (Ends) */
	
/* Check Server Existence (Starts) */
	
	public boolean checkServerHostExistence(String hostName) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{
            url = "ftp://"+hostName;
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_cloud where c_url='"+url+"'";
			System.out.println("******* Check Server Existence *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Check Server Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-checkServerHostExistence : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check Server Existence (Ends) */
	
/* Edit Server Details (Starts) */
	
	public boolean editServerDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{   
			url = "ftp://"+s[1];
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_cloud set c_url='"+url+"',c_username='"+s[2]+"',c_password='"+s[3]+"',c_status='"+s[4]+"',c_remarks='"+s[5]+"' where c_id='"+s[0]+"'";
			System.out.println("******* Edit Server Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Server Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editServerDetails(String [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit Server Details (Starts) */
	

/* Delete Server Details (Starts) */
	
	public boolean deleteServerDetails(int serverId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_cloud where c_id='"+serverId+"'";
			System.out.println("******* Delete Server Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete Server Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in deleteServerDetails(int serverId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete Server Details (Ends) */
	
	public ResultSet getUsers()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUsers(): "+ e);
		}
		return resultSet;
	}
	
	
	
	public String getUser(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select u_name from m_user where u_code='"+id+"'");
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getUser(int id): "+ e);
		}
		return name;
	}
	
/* Check User Existence (Starts) */
	
	public boolean checkUserExistence(String uid) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_user where user_id='"+uid.trim()+"'";
			System.out.println("******* Check User Existence *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Check User Existence Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-checkUserExistence(String username) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Check User Existence (Ends) */
	
/* Add User Details (Starts) */
	
	
/* Add User Details (Ends) */
	
/* Get Department By Id(Starts) */
	
	public String getDepartmentName(int id)
	{
		String name="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select dept_name from m_department where dept_code='"+id+"'";
			System.out.println("****** Get Department Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
			
			System.out.println("Department Name : " + name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDepartmentName(int id): ");
			e.printStackTrace();
		}
		return name;
	}
	
/* Get Department By Id(Ends) */
	
/* Get Designation By Id(Starts) */
	
	public String getDesignationName(int id)
	{
		String name="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select desig_name from m_designation where desig_code='"+id+"'";
			System.out.println("****** Get Designation Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name=resultSet.getString(1);
			}
			
			System.out.println("Designation Name : " + name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDesignationName(int id): ");
			e.printStackTrace();
		}
		return name;
	}
	
/* Get Designation By Id(Ends) */
	
/* Edit User Details (Starts) */

	public boolean editUserDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_user set username='"+s[1]+"',password='"+s[2]+"',u_name='"+s[3]+"',dept_code='"+s[4]+"',dept_code1='"+s[5]+"',design_code='"+s[6]+"',design_code1='"+s[7]+"',u_address='"+s[8]+"',u_city='"+s[9]+"',u_cell='"+s[10]+"',u_phone='"+s[11]+"',u_email='"+s[12]+"' where u_code='"+s[0]+"'";
			System.out.println("******* Edit User Details *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetail(String [] s): ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit User Details (Ends) */
	
	public static ResultSet getSpecificUserDetails(int id)
	{
		String name="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_code='"+id+"'");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getSpecificUserDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Delete User Details (Starts) */
	
	public boolean deleteUserDetails(int userId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_user where u_code='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Admin-deleteUserDetails(int userId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/* Delete User Details (Ends) */
	
	
/* Get Department Details (Starts) */
	
	public static ResultSet getDepartmentDetails()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_department";
			System.out.println("******* Department Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDepartmentDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	
	
/* Get Designation Details (Starts) */
	
	public static ResultSet getDesignationDetails()
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_designation";
			System.out.println("******* Designation Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDesignationDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Designation Details (Ends) */
	
/* Get Department Details (Starts) */
	
	public ResultSet getDepartments()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_department");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDepartments(): "+ e);
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	

/* Get Designation Details (Starts) */
	
	public ResultSet getDesignations()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_designation");
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getDesignations(): "+ e);
		}
		return resultSet;
	}
	
/* Get Department Details (Ends) */
	
	
/* Get Admin Upload Transaction(Starts) */

	public ResultSet getAdminUploadTransaction()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_upload");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Admin Upload Transaction(Ends) */
	
/* Get Admin Download Transaction(Starts) */

	public ResultSet getAdminDownloadTransaction()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_download");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Admin Download Transaction(Ends) */
	
/* Get Last Key Updated(Starts) */
	
	public String getLastKeyUpdatedDate()
	{
		String date="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select key_date from m_config";
			System.out.println("****** Last Key Updation Date *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				date=resultSet.getString(1);
			}
			
			System.out.println("Key Updated On : " + date);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getLastKeyUpdatedDate(): ");
			e.printStackTrace();
		}
		return date;
	}
	
/* Get Last Key Updated(Ends) */
	
/* Getting The Number Of Cloud(Starts)*/

	public int getTotalNumberOfClouds()
	{
		int clouds=0;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "SELECT COUNT(*) FROM m_cloud";
			System.out.println("****** Total Number Of Clouds *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				clouds = resultSet.getInt(1);
			}
			
			System.out.println("Total Number Of Clouds : " + clouds);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getTotalNumberOfClouds():");
			e.printStackTrace();
		}
		return clouds;
	}
	
/* Getting The Number Of Cloud(Ends)*/
	
/* Add Upload Transaction (Starts) */
	
	public boolean addUploadTransaction(String ufileName,String ufileType, String udate,String subject,int cloudId,int ownerId) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="insert into m_file_upload (f_name,f_type,f_upload_date,f_subject,cloud_id,owner_id) values('"+ufileName+"','"+ufileType+"','"+udate+"','"+subject+"','"+cloudId+"','"+ownerId+"')";
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Upload Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addUploadTransaction.....");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Add Upload Transaction (Ends) */	

/* Get Upload File Details(Starts) */

	public ResultSet getUploadFiles()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_file_upload");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUploadedFiles(int ownerId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Upload File Details(Ends) */
	
	public ResultSet getUploadedFiles(int ownerId)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_file_upload where owner_id='"+ownerId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getUploadedFiles(int ownerId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Upload File Details By fileId(Starts) */

	public ResultSet getUploadFiles(int fileId)
	{
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_file_upload where f_code='"+fileId+"'";
			System.out.println("@@@@@@@@@@@ Upload Info @@@@@@@@@@@@@@@");
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUploadFiles() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Upload File Details By fileId(Ends) */
	
/* Delete Uploaded File Details (Starts) */
	
	public boolean deleteUploadedFiles(int uploadId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_file_upload where f_code='"+uploadId+"'";
			System.out.println("******* Delete Uploaded File Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete UploadedFile Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteUploadedFiles(int uploadId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/*  Delete Uploaded File Details (Ends) */
	
/* Add AcessControl Details (Starts) */
	
	public static boolean addgynocologistratinglist(String id,int stars,String username) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "insert into m_gyanoratings(u_id,g_id,ratings) values('"+username+"','"+id+"','"+String.valueOf(stars)+"')";
			
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}

/* Add AcessControl Details (Ends) */
	
/* Get Access Control Details(Starts) */

	public ResultSet getAccessControls()
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_acess_control");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getAccessControls() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Access Control Details(Ends) */
	
/* Delete Access Control Details (Starts) */
	
	public boolean deleteAccessControls(int acId) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "delete from m_acess_control where ac_code='"+acId+"'";
			System.out.println("******* Delete Server Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Access Control Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-deleteAccessControls(int acId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
/*  Delete Access Control Details (Ends) */
	
/* Edit Access Control Details (Starts) */
	
	public boolean editAccessControls(int [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_acess_control set f_code='"+s[1]+"',dept_code='"+s[2]+"',desig_code='"+s[3]+"' where ac_code='"+s[0]+"'";
			System.out.println("******* Edit Access Controls Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Access Controls Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editAccessControls(int [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit Access Control Details(Ends) */
	
/* Get Max User ID(Starts)*/	
	
	public int getMaxUserID()
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select max(u_code) from m_user");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("Max User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getMaxUserID(): ");
			e.printStackTrace();
		}
		return i;
	}
	
/* Get Max User ID(Ends)*/	
	
/* Get Max FileAccessControl ID(Starts)*/	
	
	public int getMaxFileAccessControlID()
	{
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select max(ac_code) from m_acess_control");
			while(resultSet.next())
			{
				i=resultSet.getInt(1);
			}
			System.out.println("Max Upload ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO--> getMaxUploadID(): ");
			e.printStackTrace();
		}
		return i;
	}
	
/* Get Max FileAccessControl ID(Ends)*/	

/* Get Specific FileAccessControl Info(Starts) */

	public ResultSet getFileAccessControlInfo(int accessId)
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_acess_control where ac_code='"+accessId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getFileAccessControlInfo : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Specific FileAccessControl Info(Ends) */
	
/* Get File Name(Starts) */
	
	public String getFileName(int fileId)
	{
		String fileName="";
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select f_name from m_file_upload where f_code='"+fileId+"'";
			System.out.println("****** Get File Name By Id *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				fileName=resultSet.getString(1);
			}
			
			System.out.println("File Id : "+fileId+"\nFile Name : " + fileName);
		}
		catch(Exception e)
		{
			System.out.println("Exception in adminDAO-->getLastKeyUpdatedDate(): ");
			e.printStackTrace();
		}
		return fileName;
	}
	
/* Get File Name(Ends) */
	
/* Download Authentication1(Starts) */

	public boolean downloadAuthentication1(int fileId,int deptId1,int designationId1)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_acess_control where f_code='"+fileId+"' and dept_code='"+deptId1+"' and desig_code='"+designationId1+"'";
			System.out.println("*********** Login Authentication Info **************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			
			System.out.println("Download Authentication1 Status : " + flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-downloadAuthentication1() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Download Authentication1(Ends) */
	
/* Download Authentication2(Starts) */

	public boolean downloadAuthentication2(int fileId,int deptId2,int designationId2)
	{
		boolean flag = false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "select * from m_acess_control where f_code='"+fileId+"' and dept_code='"+deptId2+"' and desig_code='"+designationId2+"'";
			System.out.println("*********** Login Authentication Info **************");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag = true;
			}
			
			System.out.println("Download Authentication2 Status : " + flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-downloadAuthentication2() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Download Authentication2(Ends) */
		
	
	
// #################  All About The Data Owner #################	
	

	public boolean checkDataOwner(String username,String password)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_owner where ownerid='"+username+"' and password='"+password+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Data Owner Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
		}
		return flag;
	}
	
	
/* Get Profile Details (Starts) */
	
	public static ResultSet getOwnerProfile(String username)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from m_owner where ownerid='"+username+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getOwnerProfile(): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
/* Get Profile Details (Ends) */
	
/* Edit Data Owner Profile Details(Starts) */
	public boolean editOwnerProfile(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update m_owner set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
			System.out.println("******* Edit Data Owner Profile Info *********");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Data Owner Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editOwnerProfile() :");
			e.printStackTrace();
		}
		return flag;
	}
	
/* Edit Data Owner Profile Details() */

/* Check Data Owner Existence (Starts) */
	
public boolean checkOwner(String username,String password)
{
	boolean flag=false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_owner where ownerid='"+username+"' and password='"+password+"'");
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("Data Owner Existence Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminrDAO-->checkOwner(String username,String password): ");
		e.printStackTrace();
	}
	return flag;
}

/* Check Data Owner Existence (Ends) */

/* Change Data Owner Password (Starts) */
public boolean chnageOwnerPass(int id,String cpass) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "update m_owner set password='"+cpass+"' where id='"+id+"'";
		System.out.println("******* Change Data Owner Password Info *********\n");
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Change Data Owner Password Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-chnageOwnerPass(int id,String cpass)  : ");
		e.printStackTrace();
	}
	return flag;
}
/* Change Data Owner Password (Ends) */

/* Getting The Data Owner Details (Starts) */
public ResultSet getDataOwners()
{
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_owner");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getDataOwners(): ");
		e.printStackTrace();
	}
	return resultSet;
}

/* Getting The Data Owner Details (Ends) */

/* Add Data Owner Details (Starts) */

public boolean addDataOwnerDetails(String username, String password, String name,String address, String email,String phone) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert into m_owner (name,password,ownerid,address,phone,email) values('"+name+"','"+password+"','"+username+"','"+address+"','"+phone+"','"+email+"')";
		System.out.println("******* Add Data Owner Details *********\n");
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Data Owner Registeration Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addDataOwnerDetails() : ");
		e.printStackTrace();
	}
	return flag;
}

/* Add Data Owner Details (Ends) */

/* Getting Specific Data Owner Details (Starts) */
public static ResultSet getSpecificDataOwnerDetails(int id)
{
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_owner where id='"+id+"'");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getSpecificDataOwnerDetails(int id): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static ResultSet finalrankedresults()
{
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_finaltemp order by key_rank  desc");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->finalrankedresults(): ");
		e.printStackTrace();
	}
	return resultSet;
}
public static ResultSet finalgyanoresults(String gyno,String questiontype)
{
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_finaltemp  order by key_rank  desc");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->finalgyanoresults(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static ResultSet commonresult()
{
	
	String user="users";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from m_questions where user_type='"+user+"'");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->finalrankedresults(): ");
		e.printStackTrace();
	}
	return resultSet;
}
/* Getting Specific Data Owner Details (Ends) */

/* Edit Data Owner Details (Starts) */
public boolean editDataOwnerDetails(String [] s) 
{
	boolean flag=false;
	String sql = "";
	try
	{   
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "update m_owner set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
		System.out.println("******* Update Data Owner Info *********");
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Update Data Owner Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editDataOwnerDetails(String [] s) :");
		e.printStackTrace();
	}
	return flag;
}
/* Edit Data Owner Details (Ends) */

/* Delete Data Owner Details (Starts) */
public boolean deleteDataOwnerDetails(int dataWonerId) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "delete from m_owner where id='"+dataWonerId+"'";
		System.out.println("******* Delete Data Owner Details Info *********");
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Delete Data Owner Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Admin-deleteDataOwnerDetails(int userId) :" );
		e.printStackTrace();
	}
	return flag;
}
/* Delete Data Owner Details (Ends) */

/* Get DataOwnerId By username(Starts)*/	

public int getDataOwnerId(String username)
{
	int id=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select id from m_owner where ownerid='"+username+"'");
		while(resultSet.next())
		{
			id=resultSet.getInt(1);
		}
		System.out.println("Data OwnerId["+username+"] : "+id);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getDataOwnerId(String username): ");
		e.printStackTrace();
	}
	return id;
}

public static String getparticularExpertname(String gyanoname,String quetsiontype)
{
	
	StringBuffer sb=new StringBuffer();
	int id=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select q_no from m_questions where expert_id='"+gyanoname+"' and user_type='"+quetsiontype+"'");
		while(resultSet.next())
		{
			sb.append(resultSet.getInt(1));
			sb.append("~");
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getparticularExpertname ");
		e.printStackTrace();
	}
	return sb.toString();
}
public boolean addUserDetails(String uid, String pass, String name,
		String city, String state, String message, String email, String cell,
		String age, String gname, String sex, String pl)


{
	
	boolean flag=false;
	String sql = "";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert into m_user(user_id,user_pass,user_name,user_age,user_city,user_state,user_gyna,user_sex,user_pstatus,user_problem,user_email,user_cell) values('"+uid+"','"+pass+"','"+name+"','"+age+"','"+city+"','"+state+"','"+gname+"','"+sex+"','"+pl+"','"+message+"','"+email+"','"+cell+"')";
		System.out.println("******* Add User Details *********\n");
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("User Registeration Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addUserDetails : ");
		e.printStackTrace();
	}
	return flag;	
	
	
	
	
}
public static boolean addexpertDetails(String uid, String pass, String name,
		String age, String city, String state, String sex, String spec,
		String email, String cell) {
	
	
	
	
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert into m_expert(expert_id,expert_pass,expert_name,expert_age,expert_city,expert_state,expert_sex,expert_spec,expert_email,expert_phone) values('"+uid+"','"+pass+"','"+name+"','"+age+"','"+city+"','"+state+"','"+sex+"','"+spec+"','"+email+"','"+cell+"')";
		
		System.out.println(sql);
		i = statement.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
public static boolean addGyanoDetails(String name, String age, String city,
		String state, String email, String phone, String sex, String valueOf,
		String spec,String filename,String id,String password) {
	
	
	
	

	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert into m_gyano(g_name,g_age,g_city,g_state,g_sex,g_spec,g_mail,g_cell,g_star,g_image,g_id,g_pass)" +
				" values('"+name+"','"+age+"','"+city+"','"+state+"','"+sex+"','"+spec+"','"+email+"','"+phone+"','"+valueOf+"','"+filename+"','"+id+"','"+password+"')";
		
		System.out.println(sql);
		i = statement.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
	
	
	
}
public static boolean Updategyanodetails(String name1, String age,
		String city, String state1, String email, String phone, 
		String sex1, String stars, String spec, String id1) {
	
	
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "update m_gyano set g_name='"+name1+"',g_age='"+age+"',g_city='"+city+"' ,g_state='"+state1+"',g_mail='"+email+"',g_cell='"+phone+"',g_sex='"+sex1+"',g_star='"+stars+"',g_spec='"+spec+"' where g_code='"+id1+"'";
	
		System.out.println(sql);
		i = statement.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
	
	
	
	
	
}
public static boolean Updatedetails(String uid, String name, String city,
		String state, String email, String cell, String age,
		String gname, String sex, String ucode) {
	
	
	
	boolean flag=false;
	String sql = "";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "update m_user set user_id='"+uid+"',user_name='"+name+"' ,user_age='"+age+"',user_city='"+city+"',user_state='"+state+"',user_gyna='"+gname+"',user_sex='"+sex+"',user_email='"+email+"',user_cell='"+cell+"'  where u_code='"+ucode+"'";
	
		System.out.println(sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-Updatedetails() : ");
		e.printStackTrace();
	}
	return flag;
	
	
}
public static boolean addquestion(String uid, String question,
		String question_type) {
	
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert into m_questionwithanswers(user_id,user_question,question_type)" +
				" values('"+uid+"','"+question+"','"+question_type+"')";
		
		System.out.println(sql);
		i = statement.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
	
	
	
	
	
	
	
	
	
	

}
public static boolean check(String wor)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *from t_word where f_word='"+wor+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		flg = true;
	}
	//System.out.println("Search status:"+flg);
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

public static boolean truntabletemp()
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "truncate table m_temp";
	
	
	int i = statement.executeUpdate(sql);
	
	if(i>1)
	{
		flg = true;
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

public static boolean truntablefinaltemp()
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "truncate table m_finaltemp";
	
	
	int i = statement.executeUpdate(sql);
	
	if(i>1)
	{
		flg = true;
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}
public static boolean count_word(int qno,String wor,int count,String uid)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "insert into t_count(t_no,u_id,key_word,weightage) values('"+qno+"','"+uid+"','"+wor+"','"+count+"')";
	
	//System.out.println(sql);
	statement.executeUpdate(sql);
	flg=true;
	System.out.println("Search status:"+flg);
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}


public static boolean storetempvalues(int qno,String uid, String rank)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "insert into m_temp(q_no,u_id,keyrank) values('"+qno+"','"+uid+"','"+rank+"')";
	
	//System.out.println(sql);
	statement.executeUpdate(sql);
	flg=true;
	System.out.println("Search status:"+flg);
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}
public static int upload11(String uid, String keyword,String question,String questiontype,String gyanoname) 
{int qno=0;
	boolean flag=false;
	ResultSet rs=null;
	try
	{
		
		DAO database=DAO.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		statement.executeUpdate("insert into m_questions (user_id,key_word,user_question,user_type,expert_id) values('"+uid+"','"+keyword+"','"+question+"','"+questiontype+"','"+gyanoname+"')");
		
		flag=true;
		
		System.out.println("File Insertion Status : "+flag);
		
		if(flag)
		{
			
			
			connection=database.connector();
			statement = connection.createStatement();
			rs=	statement.executeQuery("select q_no from m_questions where user_question='"+question+"'");
			
			while(rs.next())
			{
				
				qno=rs.getInt(1);
				
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
	}
	return qno;
}

public static int upload1(String uid, String keyword,String question,String questiontype) 
{int qno=0;
	boolean flag=false;
	ResultSet rs=null;
	try
	{
		
		DAO database=DAO.getInstance();
		connection=database.connector();
		statement = connection.createStatement();
		statement.executeUpdate("insert into m_questions (user_id,key_word,user_question,user_type) values('"+uid+"','"+keyword+"','"+question+"','"+questiontype+"')");
		
		flag=true;
		
		System.out.println("File Insertion Status : "+flag);
		
		if(flag)
		{
			
			
			connection=database.connector();
			statement = connection.createStatement();
			rs=	statement.executeQuery("select q_no from m_questions where user_question='"+question+"'");
			
			while(rs.next())
			{
				
				qno=rs.getInt(1);
				
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
	}
	return qno;
}












public static ArrayList getkey_word(String uid,int qno)
{
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *from t_count where u_id='"+uid+"' and  t_no='"+qno+"'";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		
		list.add(resultSet.getString(3)+"@"+resultSet.getString(4));
		
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return list;
}

public static boolean getrankingoffile(String qno,String uid,String keyrank)
{
	boolean flag=false;
	boolean flagg=false;
int dat=0;
	String sum="";
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select sum(keyrank)  from m_temp where q_no='"+Integer.parseInt(qno)+"' and u_id='"+uid+"'";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		flag=true;
		dat=	resultSet.getInt(1);
		
	}
	if(flag)
	{
		
		/*
		System.out.println("its came inside upadtion part");
		String result = sum.substring(0, sum.indexOf("."));
		
		System.out.println("result is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
	int value=	Integer.parseInt(result);
	System.out.println("value is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+value);*/
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "update m_questions set key_rank='"+dat+"'  where q_no='"+qno+"' and user_id='"+uid+"'";
	
		System.out.println("shanu>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flagg=true;
		}
			
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flagg;
}
public static boolean insertintofinaltemp(String qno,String gyno,String qtype)
{
	boolean flag=false;
	boolean flagg=false;
int dat=0;
	String sum="",uidd="",uquestion="",type="",eid="",eans="",keywod="";
	int qnoo=0;
	int total=0;
	int keyrank=0;
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *  from m_questions where q_no='"+Integer.parseInt(qno)+"' and expert_id='"+gyno+"' and user_type='"+qtype+"'";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		flag=true;
		qnoo=	resultSet.getInt(1);
		uidd=	resultSet.getString(2);
		uquestion=	resultSet.getString(3);
		type=	resultSet.getString(4);
		eid=	resultSet.getString(5);
		eans=	resultSet.getString(6);
		keywod=	resultSet.getString(7);
		total=	resultSet.getInt(8);
		keyrank=	resultSet.getInt(9);
		
	}
	if(flag)
	{
		
		/*
		System.out.println("its came inside upadtion part");
		String result = sum.substring(0, sum.indexOf("."));
		
		System.out.println("result is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
	int value=	Integer.parseInt(result);
	System.out.println("value is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+value);*/
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert  into m_finaltemp(q_no,user_id,user_question,user_type,expert_id,expert_answer,key_word,total,key_rank) values('"+qnoo+"','"+uidd+"','"+uquestion+"','"+type+"' ,'"+eid+"','"+eans+"','"+keywod+"','"+total+"','"+keyrank+"')";
	
		System.out.println("shanu>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flagg=true;
		}
			
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flagg;
}


public static boolean insertintofinaltemp1(String qno,String uid)
{
	boolean flag=false;
	boolean flagg=false;
int dat=0;
	String sum="",uidd="",uquestion="",type="",eid="",eans="",keywod="";
	int qnoo=0;
	int total=0;
	int keyrank=0;
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *  from m_questions where q_no='"+Integer.parseInt(qno)+"' and user_id='"+uid+"'";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		flag=true;
		qnoo=	resultSet.getInt(1);
		uidd=	resultSet.getString(2);
		uquestion=	resultSet.getString(3);
		type=	resultSet.getString(4);
		eid=	resultSet.getString(5);
		eans=	resultSet.getString(6);
		keywod=	resultSet.getString(7);
		total=	resultSet.getInt(8);
		keyrank=	resultSet.getInt(9);
		
	}
	if(flag)
	{
		
		/*
		System.out.println("its came inside upadtion part");
		String result = sum.substring(0, sum.indexOf("."));
		
		System.out.println("result is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
	int value=	Integer.parseInt(result);
	System.out.println("value is >>>>>>>>>>>>>>>>>>>>>>>>>>>"+value);*/
		connection=dao.connector();
		statement = connection.createStatement();
		sql = "insert  into m_finaltemp(q_no,user_id,user_question,user_type,expert_id,expert_answer,key_word,total,key_rank) values('"+qnoo+"','"+uidd+"','"+uquestion+"','"+type+"' ,'"+eid+"','"+eans+"','"+keywod+"','"+total+"','"+keyrank+"')";
	
		System.out.println("shanu>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
		int i=statement.executeUpdate(sql);
		if(i!=0)
		{
			flagg=true;
		}
			
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flagg;
}
public static int getFile_total(String uid,int qno)
{
	int total=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select total from m_questions where user_id='"+uid+"' and q_no='"+qno+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		total=resultSet.getInt(1);
	}
	System.out.println("Total:"+total);
	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return total;
}
public static boolean update_rank(String keyword,String uid,String rank,int qno)
{
	boolean flg =false;
	
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "update t_count set key_rank='"+rank+"' where u_id='"+uid+"' and key_word='"+keyword+"' and t_no='"+qno+"'";
	System.out.println("sql query is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sql);
	
	int i=statement.executeUpdate(sql);
	
	if(i!=0)
	{
		flg=true;
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}
public static int gettotal(int qno)
{
	int total=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select weightage from t_count where t_no='"+qno+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		total=total+resultSet.getInt(1);
	}
	System.out.println("Total:"+total);
	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return total;
}

public static boolean updatetotal(String uid,String ques,int tot,int queno)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "update m_questions set total='"+tot+"' where user_id='"+uid+"' and q_no='"+queno+"'";
	
	//System.out.println(sql);
	 statement.executeUpdate(sql);
	
	 flg=true;
	System.out.println("STatus:"+flg);
	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}
public static int getFileno(String fname)
{
	int total=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select f_no from m_file where f_name='"+fname+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		total=resultSet.getInt(1);
	}
	System.out.println("file NO:"+total);
	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return total;
}
public static String checkkeyword(String key) {

	
StringBuffer sb=new StringBuffer();
	int total=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select t_no,u_id,key_rank from t_count where key_word='"+key+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		sb.append(resultSet.getInt(1));
		sb.append("~");
		sb.append(resultSet.getString(2));
		sb.append("~");
		sb.append(resultSet.getString(3));
		sb.append("~~");
		
	}

	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return sb.toString();
	
	
	
	
	
}

public static String checkkeyword1(String key,String qno) {

	
StringBuffer sb=new StringBuffer();
	int total=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select t_no,u_id,key_rank from t_count where key_word='"+key+"' and t_no='"+Integer.parseInt(qno)+"'";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		sb.append(resultSet.getInt(1));
		sb.append("~");
		sb.append(resultSet.getString(2));
		sb.append("~");
		sb.append(resultSet.getString(3));
		sb.append("~~");
		
	}

	
			
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return sb.toString();
	
	
	
	
	
}

public static String distinctquestionum()
{
	
	StringBuffer sb=new  StringBuffer();
	int qno=0;
	String finaldata="";
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select DISTINCT q_no from m_temp";
	
	//System.out.println(sql);
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		qno=resultSet.getInt(1);
		sb.append(qno);
		sb.append("~");
	}
  
	
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return sb.toString();
}
}
