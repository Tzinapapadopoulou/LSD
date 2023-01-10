import java.sql.*;
import java.util.Scanner;
import java.lang.String;


public class ConnectSql {
	public static void main(String[] args) {

		String liker = "MARIA";
		String liked = "ANNA";
		boolean flag = false;
		String checkbudz = "SELECT * FROM LIKES WHERE LIKER=? AND LIKED=?;";
		
		String connectionUrl = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;"
			+ "database=DB39;"
			+ "user=G539;"
			+ "password=wf3044;";

		try (Connection connection = DriverManager.getConnection(connectionUrl)) {
			System.out.println("Επιτυχής σύνδεση");
			//ΕΙΣΑΓΩΓΗ ΛΑΙΚ ΣΤΟΝ ΠΙΝΑΚΑ LIKES
			//ΤΣΕΚΑΡΕΙ ΑΝ ΕΧΕΙ ΚΑΝΕΙ ΚΑΙ Ο LIKED ΛΑΙΚ ΠΙΣΩ ΣΤΟΝ LIKER
			PreparedStatement pstmt = connection.prepareStatement(checkbudz);
		    pstmt.setString(1, liked);
		    pstmt.setString(2, liker);
        	ResultSet rs = pstmt.executeQuery();
        	while(rs.next()) {
        		System.out.println(rs.getString("LIKER") + " " + rs.getString("LIKED"));
        		if (rs.getString("LIKER") == liked) {
        		 flag = true;
			 	}
			}
		} catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }

        if (flag == true) {
			//call message
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
}





