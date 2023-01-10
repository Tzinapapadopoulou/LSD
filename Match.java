package match;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Match {
    public int position;
    public void setPosition(int a){
		position = a;
    }
    public ArrayList<Integer> matchingUsersProfile() {
        // το i είναι ο αριθμός των χρηστών//
        ConnectDB connection = new ConnectDB();
        Connection con = null;
        PreparedStatement p1 = null;
        PreparedStatement p2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        list<Integer> allowlike = new ArrayList<Integer>();
        try{
            con = connection.connectionDB();
            Statement stmt = con.createStatement();
            ResultSetMetaData rsmd = rs.getMetaData();
            int i = 0;

            boolean thereIsAtLeastABuddy = false;

            try {
                String sqlfortheuser = "select DEST, MONTH from USERS where POSITION=" + Integer.toString(position);
                p1 = con.prepareStatement(sqlfortheuser);
                rs1 = p1.executeQuery();
            } catch (SQLException e) {
                System.out.println(e);
            }
            while (rsmd.next()) {
                try {
                    String sql = "select DEST, MONTH from USERS where POSITION=" + Integer.toString(i);
                    p2 = con.prepareStatement(sql);
                    rs2 = p2.executeQuery();
                    if (rs1.getInt("DEST") == rs2.getInt("DEST") && rs1.getInt("MONTH") == rs2.getInt("MONTH")
                            && i != position) {
                        if (thereIsAtLeastABuddy == false) {
                            System.out.println("Your possible travel Buddies are :");
                            thereIsAtLeastABuddy = true;
                        }
                        System.out.printf(rs2.getString("USERNAME"));
                        allowlike.add(i);
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
                i++;
            }
            rs1.close();
            rs2.close();
            p1.close();
            p2.close();
        }catch (SQLException e){
            System.out.println("SQLException :");
        }
        if (thereIsAtLeastABuddy == false) {
            System.out.println(
                    "We're sorry but there isn't any travel buddy for you. Please try another destination or month for your trip");
            Destination rearrangeTheTrip = new Destination();
            rearrangeTheTrip.fillArray();
        }else {
            return allowlike;
        }
    }
}
