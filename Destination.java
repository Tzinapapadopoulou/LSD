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
        int a;
        //γίνεται έλεγχος εγκυρότητας του μήνα//
        do {
            a = input.nextLine();
        }while (a >= 1 && a <= 12); 
        super.tripMonth[super.position]  = a;
        System.out.println("Enter the destination of your next trip :");
        super.tripDest[super.position] = input.nextLine();
    }
}
