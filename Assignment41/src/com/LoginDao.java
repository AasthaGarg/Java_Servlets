package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
public static boolean validate(String name,String password) {
		
		boolean result=false;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement(  
			"select * from users where username=? and password=?");  
			ps.setString(1,name);  
			ps.setString(2,password);  
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				result=true;
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}
