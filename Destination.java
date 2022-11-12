import java.util.Scanner;
import java.util.InputMismatchException;

public class Destination extends Executable {
    //κληρονομεί τον πίνακα από την κλάση Executable με τα στοιχεία των χρηστών ο οποίος είναι δηλωμένος ως public έξω από τισ μεθόδους τησ κλάσης//
    //υποθέτουμε ότι ο πίνακας που κληρονομείται είναι 5(χρήστες)*5(στοιχεία)//
    //κληρονομείται και δημόσια μεταβλητή τύπου int και όνομα position με την θέση του εκάστοτε χρήστη στον πίνακα με τα στοιχεία// 
    Scanner input = new Scanner(System.in);
    public void fillArray() {
        //μέθοδο που συμπληρώνει τα στοχεία του ταξιδιού του χρήστη που βρίσκεται στην θέση position//
        TableOfDestinations a = new TableOfDestinations();
        boolean continueLoop = true;
        int month = 0;
        do {
            try {
                //κάνουμε έλεγχο για το αν εισάγεται int //
                System.out.println("Enter month of your next trip :");
                month = input.nextInt();
                continueLoop = false;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an integer");
            }   
        } while (continueLoop);
        checkMonth(month);
        super.tripMonth[super.position]  = month;
        a.appearsTableOfDestinations();
        System.out.println("Choose the destination of your next trip from the list above (Enter number)");
        continueLoop = true;
        int numOfDest = 0;
        do {
            try {
                //κάνουμε έλεγχο για το αν εισάγεται int //
                System.out.println("Enter number of your next destination :");
                numOfDest = input.nextInt();
                continueLoop = false;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an integer");
            }   
        } while (continueLoop);
        checkDestination(numOfDest);
        super.tripDest[super.position] = numOfDest;
    }
    public int checkMonth(int a) {
        //γίνεται έλεγχος εγκυρότητας του μήνα//
        if(a < 1 && a > 12) {
            do{
                System.out.println("invalid number of month, please try again");
                 a = input.nextInt();
            }while (a < 1 && a > 12); 
        }
        return a;
    }
    public int checkDestination(int b) {
        //γίνεται έλεγχος εγκυρότητας του προορισμού//
        if(b < 1 && b > 20) {
            do {
              System.out.println("invalid number of destination, please try again");
              b = input.nextInt();
            }while (b < 1 && b > 20);
        }
        return b;
    }
}
