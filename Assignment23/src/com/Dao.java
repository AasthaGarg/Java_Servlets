package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	 public static Connection getConnection(){  
		 
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
	        }catch(Exception e){System.out.println(e);}  
	        
	        return con;  
	    }
	 
	 public static String validate(String name,String password) {
			
			String user=null;
			try {
				Connection con=Dao.getConnection();      
				PreparedStatement ps=con.prepareStatement(  
				"select * from users where username=? and password=?");  
				ps.setString(1,name);  
				ps.setString(2,password);  
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					user=rs.getString("usertype");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return user;
		}
	 
	 public static int saveTraining(Training obj) {
		 
		 int status =0;
		 try {
			    Connection con=Dao.getConnection();      
				PreparedStatement ps=con.prepareStatement(  
				"insert into training(tid,tname,startdate,enddate,tmode,bunit,cpersonid) values (?,?,?,?,?,?,?)");  
				ps.setInt(1, obj.getTid());  
				ps.setString(2, obj.getTname());  
				ps.setString(3, obj.getSdate());
				ps.setString(4, obj.getEdate());
				ps.setString(5, obj.getTmode());
				ps.setString(6, obj.getBunit());
				ps.setString(7, obj.getCpersonid());
				
				status = ps.executeUpdate();
				
				con.close();
			 
		 }
		 catch(Exception e) {
			 
			 System.out.println(e);
		 }
		 return status;
	 }
	 
	 public static List<Training> getAllTraining(){
		 
		 List<Training> list= new ArrayList<Training>();
		 try {
			 Connection con=Dao.getConnection();
			 PreparedStatement ps = con.prepareStatement(
					 "select * from training");
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				 Training t = new Training();
				 t.setTid(rs.getInt(1));
				 t.setTname(rs.getString(2));
				 t.setSdate(rs.getString(3));
				 t.setEdate(rs.getString(4));
				 t.setTmode(rs.getString(5));
				 t.setBunit(rs.getString(6));
				 t.setCpersonid(rs.getString(7));
				 list.add(t);
			 }
			 con.close();
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 return list;
	 }
	 
	 public static int deleteTraining(int id) {
		 
		 int status=0;
		 try {
			 
			 Connection con=Dao.getConnection();
			 PreparedStatement ps = con.prepareStatement("delete from training where tid=?");
			 ps.setInt(1, id);
			 status=ps.executeUpdate();
			 con.close();
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 return status;
	 }
}
