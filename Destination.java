import java.util.Scanner;
import java.util.Arrays;

public class Destination extends Executable {
    //κληρονομεί τον πίνακα από την κλάση Executable με τα στοιχεία των χρηστών ο οποίος είναι δηλωμένος ως public έξω από τισ μεθόδους τησ κλάσης//
    //υποθέτουμε ότι ο πίνακας που κληρονομείται είναι 5(χρήστες)*5(στοιχεία)//
    //κληρονομείται και δημόσια μεταβλητή τύπου int και όνομα position με την θέση του εκάστοτε χρήστη στον πίνακα με τα στοιχεία// 
    public void fillArray() {
        //μέθοδο που συμπληρώνει τα στοχεία του ταξιδιού του χρήστη που βρίσκεται στην θέση position//
        Scanner input = new Scanner(System.in);
        System.out.println("Enter month of your next trip :");
        int month = input.nextInt();
        checkMonth(int month);
        super.tripMonth[super.position]  = month;
        TableOfDestinations.appearsTableOfDestinations();
        System.out.println("Choose the destination of your next trip from the list above (Enter number)");
        int numOfDest = input.nextInt();
        checkDestination(int numOfDest);
        super.tripDest[super.position] = numOfDest;
    }
    public void checkMonth(int a) {
        //γίνεται έλεγχος εγκυρότητας του μήνα//
        if(a < 1 && a > 12) {
            do{
                System.out.println("invalid number of month, please try again");
                 a = input.nextInt();
            }while (a < 1 && a > 12); 
        }
    }
    public void checkDestination(int b) {
        //γίνεται έλεγχος εγκυρότητας του προορισμού//
        if(b < 1 && b > 20) {
        do {
            System.out.println("invalid number of destination, please try again");
            b = input.nextInt();
        }while (b < 1 && b > 20);
    }
}
