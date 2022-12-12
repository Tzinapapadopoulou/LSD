package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLConnector {
	
	public void addUser(String firstName, String lastName, String userName, String password, String email, String birthDay, int sex) throws Exception {
		
		  try{ 
	            String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
	            String user = "LSD";
	            String passWord = "LSD123";
	            Connection conn = DriverManager.getConnection(url, user, passWord);
	            System.out.println("success");
	            String query = "insert into USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORDY, EMAIL, BIRTHDAY, SEX)" + " values ( ?, ?, ?, ?, ?, ?, ?) ";
	            PreparedStatement prepareSt = conn.prepareStatement(query);
	            
	            prepareSt.setString(1, firstName);
	            prepareSt.setString(2, lastName);
	            prepareSt.setString(3, userName);
	            prepareSt.setString(4, password);
	            prepareSt.setString(5, email);
	            prepareSt.setString(6, birthDay);
	            prepareSt.setInt(7, sex);
	            prepareSt.execute();
	           
	            conn.close();
	        } catch (SQLException e) {
	            System.err.println("got an exception e");
	            e.printStackTrace();
	        }

	        
		
	}

}
