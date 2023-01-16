
#LSD
java code


Οδηγίες χρήσης του προγράμματος

Η εφαρμογή που δημιουργήσαμε δίνει την δυνατότητα στον χρήστη να βρει συνταξιδιώτη με κοινό προορισμό και κοινή ημερομηνία ταξιδιού, ώστε να συνομιλήσουν και να οργανώσουν το ταξίδι τους. Η εφαρμογή μας παρέχει τις εξής λειτουργίες:

1. Εγγραφη/σύνδεση χρήστη στο σύστημα με συμπλήρωση των απαραίτητων στοιχείων.
2. Προβολή προφίλ άλλων χρηστών με κοινό προορισμό και ημερομηνία ταξιδιού. 
3. Δυνατότητα "like" σε προφίλ που ενδιαφέρουν τον χρήστη ως συνταξιδιώτες.
4. Δυνατότητα ανταλλαγής μηνυμάτων, εφόσον το "like" είναι αμφίδρομο.
5. Έξοδος από την εφαρμογή με δυνατότητα επανασύνδεσης με τα στοιχεία της εγγραφής. 

Αποθετήριο 
SignUpGUI.java
Εισαγωγή username, password, destination, date, month στις βάσεις δεδομένων και έλεγχος προς αποφυγήν διπλοτιμων. 

LoginGUI.java
Σύνδεση του χρήστη στο σύστημα και ταυτοποίηση στοιχείων από τις βάσεις δεδομένων. 

Match.java
Προβολή λίστας χρηστών με κοινό προορισμό και κοινό μήνα ταξιδιού. Δυνατότητα "like" στους προβαλλόμενους χρήστες. 

Like.java 
Δέχεται τα usernames του χρήστη που έκανε "like" (liker) και του χρήστη στον οποίο έγινε αυτό (liked), τα καταχωρεί στη βάση δεδομένων και ελέγχει αν ο liked έχει κάνει "like" στον liker. Σε περίπτωση που αυτό αληθεύει, καλεί τις κλάσεις (Threads) "CallClient.java" και "CallServer.java". 

CallServer.java 
Καλεί την main μέθοδο της κλάσης "Chat_Server.java".

CallClient.java
Καλεί την main μέθοδο της κλάσης "Chat_Client.java".

Chat_Server.java
Ανοίγει παράθυρο επικοινωνίας του συνδεδεμένου χρήστη (liker) με την δυνατότητα σύνταξης και αποστολής μηνυμάτων προς τον liked (ChatBud). 

Chat_Client.java
Ανοίγει παράθυρο επικοινωνίας του χρήστη liked με την δυνατότητα σύνταξης και αποστολής μηνυμάτων προς τον liker.


![Untitled](https://user-images.githubusercontent.com/117830508/212709964-62214639-3d11-4237-b92e-866c0efefa95.png)

Επισκόπηση δομών δεδομένων

Ως δομή δεδομένων έχουμε χρησιμοποιήσει λίστες. Πιο αναλυτικά, έχουμε συμπεριλάβει μια λίστα (allowlike) που περιέχει τις θέσεις των χρηστών που κάνουν "match" από τον πίνακα των βάσεων δεδομένων. Τα υπόλοιπα δεδομένα αποθηκεύονται στη βάση δεδομένων και τα διαχειριζόμαστε με την γλώσσα SQL.
