public class Match extends Executable {
    //κληρονομείται δημόσια μεταβλητή τύπου int (position) η οποία δηλώνεται στην κλάση Executable η οποίαδείχνει την θέση που κατέχει ο συγκεκριμένος χρήστης στον πίνακα με τα δεδομένα(tableOfAllUsers)//
    //κληρονομείται ακόμα ο πίνακας με τα δεδομένα όλων των χρηστών τον θεωρούμε προσωρινά 7(χαρακτηριστικά)*5(χρήστες)(tableOfAllUsers)(από την Registration) και ο παράλληλος πίνακας 5 γραμμων με τουσ μήνες(tableMonth) και ο παράλληλος πίνακας 5 γραμμών με τους προορισμούς(tableDest)(από την Executable)//
    public String matchingUsersProfile() {
        //το i είναι ο αριθμός των χρηστών//
        boolean thereIsAtLeastABuddy = false;
        for(int i = 0 ; i < 5 ; i++) {
            if(super.tableDest[super.position] == super.tableDest[i] && super.tableMonth[super.position] == super.tableMonth[i] && i != super.position) {
                //υποθέτω οτι στον πίνακα με τα στοιχεία των χρηστών το username βρίσκεται στην στήλη 3 με την σειρά που τα έχετε βάλει στην κλάση Registration//
                if (thereIsAtLeastABuddy == false) {
                    System.out.println("Your possible travel Buddies are :");
                    thereIsAtLeastABuddy = true;
                }
                System.out.printf("%s", super.tableOfAllUsers[i][3]);
            }
        }
        if(thereIsAtLeastABuddy == false) {
            System.out.println("We're sorry but there isn't any travel buddy for you. Please try another destination or month for your trip");
            Destination rearrangeTheTrip = new Destination();
            rearrangeTheTrip.fillArray();
        }
    }
}
