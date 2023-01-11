package net.codejava.sql;

import java.util.*;
import java.sql.*;

public class Match {
    public static int position;
    
    public void setPosition(int a){
		position = a;
    }
    
    public static boolean thereIsAtLeastABuddy;
    public static ArrayList<Integer> matchingUsersProfile() throws ClassNotFoundException {
    	thereIsAtLeastABuddy = false;
        List<Integer> allowlike = new ArrayList<Integer>();
        
        try{
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
            String user = "LSD";
            String passWord = "LSD123";
            Connection conn = DriverManager.getConnection(url, user, passWord);
            System.out.println("connected successfully to Database");
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt = conn.createStatement();
            ResultSet rs1= null;
            ResultSet rs2 = null;
            ResultSet rs = null;
        
            String sql2 = "SELECT COUNT(*) FROM USERS" ; //αριθμος σειρων βασης
            rs = stmt.executeQuery(sql2);
            rs.next();
            int x = rs.getInt(1);
            
            try {
                String sqlfortheuser = "select DEST, MONTHY from USERS where POSITION=" + String.valueOf(position);
                rs1 = stmt1.executeQuery(sqlfortheuser);
                while(rs1.next()) {
                	for(int i = 1;i<=x; i++) {        
                		try {
                        	String sql = "select DEST, MONTHY, USERNAME from USERS where POSITION=" + String.valueOf(i);
                        	rs2 = stmt2.executeQuery(sql);
                        	while (rs2.next()) {
                                if (rs1.getInt("DEST") == rs2.getInt("DEST") && i != position && rs1.getString("MONTHY").equals(rs2.getString("MONTHY"))) { 
                                		if (thereIsAtLeastABuddy == false) {
                                			System.out.println("Your possible travel Buddies are :");
                                			thereIsAtLeastABuddy = true;
                                		}
                                		System.out.println(rs2.getString("USERNAME"));
                                		allowlike.add(i);
                                }
                        	}
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                       
                    }
                    
                }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
            conn.close();
        }catch (SQLException e){
            System.out.println("SQLException :");
        }
        if (thereIsAtLeastABuddy == false) {
            System.out.println("We're sorry but there isn't any travel buddy for you. Please try again with new destination info");
            return (ArrayList<Integer>) allowlike;
        }else {
            return (ArrayList<Integer>) allowlike;
        }
        
    }
    
    public boolean getBoolean() {
    	return thereIsAtLeastABuddy;
    }
    
  
}
