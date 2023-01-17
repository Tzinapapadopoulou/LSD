import java.sql.*;
import java.util.Scanner;
import java.lang.String;


public class Like {
	public static void likee(String liker, String liked) {

		boolean flag = false;
		String checkbudz = "SELECT * FROM LIKES WHERE LIKER=? AND LIKED=?;";
		String insertlike = "INSERT INTO LIKES (LIKER, LIKED) VALUES (?, ?);";

		String connectionUrl = "jdbc:sqlserver://--:1433;"
			+ "database=--;"
			+ "user=--;"
			+ "password=--;";

		try (Connection connection = DriverManager.getConnection(connectionUrl)) {
			System.out.println("Επιτυχής σύνδεση");

			//ΕΙΣΑΓΩΓΗ ΛΑΙΚ ΣΤΟΝ ΠΙΝΑΚΑ LIKES
			PreparedStatement ins = connection.prepareStatement(insertlike);
			ins.setString(1, liker);
		    ins.setString(2, liked);
			int rowsInserted = ins.executeUpdate();
			System.out.println(rowsInserted);

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
