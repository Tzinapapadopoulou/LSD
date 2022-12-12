import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Match extends Executable {
    //κληρονομείται δημόσια μεταβλητή τύπου int (position) η οποία δηλώνεται στην κλάση Executable η οποίαδείχνει την θέση που κατέχει ο συγκεκριμένος χρήστης στον πίνακα με τα δεδομένα(tableOfAllUsers)//
    //κληρονομείται ακόμα ο πίνακας με τα δεδομένα όλων των χρηστών τον θεωρούμε προσωρινά 7(χαρακτηριστικά)*5(χρήστες)(tableOfAllUsers)(από την Registration) και ο παράλληλος πίνακας 5 γραμμων με τουσ μήνες(tableMonth) και ο παράλληλος πίνακας 5 γραμμών με τους προορισμούς(tableDest)(από την Executable)//
    public String matchingUsersProfile() {
        //το i είναι ο αριθμός των χρηστών//
        ConnectDB connection = new ConnectDB();
        Connection con = null;
        PreparedStatement p1 = null;
        PreparedStatement p2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;

        con = connection.connectionDB();
        Statement stmt = con.createStatement();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsize = rsmd.getPrecision(1);

        boolean thereIsAtLeastABuddy = false;
        list <Integer> allowlike = new ArrayList<Integer>();

        try {
            String sqlfortheuser = "select DEST, MONTH from USERS where POSITION=" + Integer.toString(super.position);
            p1 = con.prepareStatement(sqlfortheuser);
            rs1 = p1.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }

        for(int i = 0 ; i < super.columnsize; i++) {
                try {
                    String sql = "select DEST, MONTH from USERS where POSITION=" + Integer.toString(i);
                    p2 = con.prepareStatement(sql);
                    rs2 = p2.executeQuery();
                    if(rs1.getInt("DEST") == rs2.getInt("DEST") && rs1.getInt("MONTH") == rs2.getInt("MONTH") && i != super.position) {
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
            
        }
        if(thereIsAtLeastABuddy == false) {
            System.out.println("We're sorry but there isn't any travel buddy for you. Please try another destination or month for your trip");
            Destination rearrangeTheTrip = new Destination();
            rearrangeTheTrip.fillArray();
        }
    }
}
