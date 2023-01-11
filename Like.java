import java.sql.*;
import java.util.Scanner;
import java.lang.String;


public class ConnectSql {
	public static void main(String[] args) {

		String liker = "MARIA";
		String liked = "ANNA";
		boolean flag = false;
		String checkbudz = "SELECT * FROM LIKES WHERE LIKER=? AND LIKED=?;";
		
		String connectionUrl = "jdbc:sqlserver://----1433;"
			+ "database=--;"
			+ "user=--;"
			+ "password=--;";

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
		}
	}
}
