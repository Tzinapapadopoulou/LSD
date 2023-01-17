package net.codejava.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLConnector {
	
	public void addUser(UserEclipse userEclipse) throws Exception {
		
		  try{ 
	            String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
	            String user = "LSD";
	            String passWord = "LSD123";
	            Connection conn = DriverManager.getConnection(url, user, passWord);
	            System.out.println("connected successfully to Database");
	            
	            String query = "insert into USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORDY, EMAIL, BIRTHDAY, SEX)" + " values (?, ?, ?, ?, ?, ?, ?) ";
	            PreparedStatement prepareSt = conn.prepareStatement(query);
	           
	            prepareSt.setString(1, userEclipse.getFirstName());
	            prepareSt.setString(2, userEclipse.getLastName());
	            prepareSt.setString(3, userEclipse.getUserName());
	            prepareSt.setString(4, userEclipse.getPassword());
	            prepareSt.setString(5, userEclipse.getEmail());
	            prepareSt.setString(6, userEclipse.getBirthDay());
	            prepareSt.setInt(7, userEclipse.getSex());
	            //prepareSt.setInt(8,  );
	            //prepareSt.setInt(9,  );
	            prepareSt.execute(); 
	           
	            conn.close();
	        } catch (SQLException e) {
	            System.err.println("got an exception e");
	            e.printStackTrace();
	        }

	        
		
	}

}
