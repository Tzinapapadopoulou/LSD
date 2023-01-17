package net.codejava.sql;

import java.sql.*;
import java.util.Scanner;
import java.lang.String;


public class Like {
	public static void whoLikedWho(String liker, String liked) {

		
		boolean flag = false;
		String checkbudz = "SELECT * FROM LIKES WHERE LIKER=? AND LIKED=?;";
		String insertlike = "INSERT INTO LIKES (LIKER, LIKED) VALUES (?, ?);";
		
		String url = "jdbc:sqlserver://" +"TZINA-PC" + ":1433;DatabaseName=" + "TRABUDZ" + ";encrypt=true;trustServerCertificate=true";
        String user = "LSD";
        String passWord = "LSD123";

		try (Connection connection = DriverManager.getConnection(url, user, passWord)) {
			System.out.println("Επιτυχής σύνδεση");

			//ΕΙΣΑΓΩΓΗ ΛΑΙΚ ΣΤΟΝ ΠΙΝΑΚΑ LIKES
			PreparedStatement ins = connection.prepareStatement(insertlike);
			ins.setString(1, liker);
		    ins.setString(2, liked);
			int rowsInserted = ins.executeUpdate();
			//System.out.println(rowsInserted);

			//ΤΣΕΚΑΡΕΙ ΑΝ ΕΧΕΙ ΚΑΝΕΙ ΚΑΙ Ο LIKED ΛΑΙΚ ΠΙΣΩ ΣΤΟΝ LIKER
			PreparedStatement check = connection.prepareStatement(checkbudz);
		    check.setString(1, liked);
		    check.setString(2, liker);
        	ResultSet rs = check.executeQuery();
        	while(rs.next()) {
        		System.out.println(rs.getString("LIKER") + " " + rs.getString("LIKED"));
        		flag = true;
			}
		} catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

        if (flag == false) {
			//call message
			System.out.println("FALSE");
		} else {
			System.out.println("TRUE");
            CallServer s = new CallServer();
            CallClient c = new CallClient();
            s.start();
            c.start();
		}
	}
}