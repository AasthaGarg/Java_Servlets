package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	 public static Connection getConnection(){  
		 
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
	        }catch(Exception e){System.out.println(e);}  
	        
	        return con;  
	    }
	 
	 public static boolean validate(String name,String password) {
			
			boolean user=false;
			try {
				Connection con=Dao.getConnection();      
				PreparedStatement ps=con.prepareStatement(  
				"select * from users where username=? and password=?");  
				ps.setString(1,name);  
				ps.setString(2,password);  
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					user=true;
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return user;
		}
	 
	 public static int getSalary(String name) {
		 
		 int salary=0;
		 try {
				Connection con=Dao.getConnection();      
				PreparedStatement ps=con.prepareStatement(  
				"select * from salary where username=?");  
				ps.setString(1,name);   
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					salary=rs.getInt("amount");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		 return salary;
		 
	 }

}
