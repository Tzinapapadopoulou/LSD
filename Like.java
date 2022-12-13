import java.util.Stack;

public class Like {
    /*η κλαση Match απο την μεθοδο matchingUsersProfile θα στέλνει μία λίστα με ονομα allowlike με τα Primary key (στήλη POSITION του πίνακα sql) 
των χρηστών με τουσ οποίουσ ο χρήστησ που είναι συνδεδεμένοσ τωρα (στην θέση super.position(βλέπε κλάση Excecutable) 
κάνει ματσ. Ο πίνακας wholikewho θα είναι τετραγωνικόσ με αριθμό στηλών(και γραμμών) το columnsize του πίνακα τοθ 
sql ππου περιέχει τα στοιχεία των χρηστών. πχ αν η λίστα : <12,14> τότε θα υπάρχει δυνατότητα like
 στισ θέσεις πίνακα [super.position,12] και  [super.position, 14]*/

    public static int[][] createWholikedwho() {
        int[][] wholikedwho = new int[allowlike.length][allowlike.length];
        for (int i = 0; i < wholikedwho.length; i++) {
            for (int j = 0; j < wholikedwho[0].length; j++) { 
                wholikedwho[i][j] = 0; 
            }
        }
        return wholikedwho;
    }
    //intializing wholikedwho array

  //  public static int[] createLikesarray() {
   //     int[] likesarray = new int[];
   //     for (int i = 0; i < likesarray.length; i++) {
    //        likesarray[i] = 0;
    //    }
     //   return likesarray;
   // }
    //initializing likesarray
    

   // public static int[] addLike(int likesarray[], int userliked) {
   //     likesarray[userliked]++;
   //     return likesarray;
   // }
    //adding likes

    public static int[][] isTrue(int wholikedwho[][], int userliker, int userliked) {
        wholikedwho[userliker][userliked] = 1;
        return wholikedwho;
    }
    //2 users like eachother >> value 1 on wholikedwho

    public static Stack<Integer> createChatbudz() {
        Stack<Integer> chatbudz = new Stack<Integer>(); 
        return chatbudz;
    }
    //create couples to chat after liking eachother

    public static Stack<Integer> mutualLike(int userliker, int userliked, int wholikedwho[][], Stack<Integer> chatbudz) {
        if ( (wholikedwho[userliker][userliked] == wholikedwho[userliked][userliker] ) && ( wholikedwho[userliker][userliked] != 2) ) {
            chatbudz.push(userliker);
            chatbudz.push(userliked);
        }
        return chatbudz;
    }
    //pushing in stack mutualLike the liker first then the liked
    
    public static int[][] setToTwo(int wholikedwho[][], int userliked, int userliker) {
        wholikedwho[userliker][userliked] = 2;
        wholikedwho[userliked][userliker] = 2;
        return wholikedwho;
    }
    //stating in wholikedwho array that the couple was made and now they can chat

    public static void main(String[] args) {
        Match objMatch = new Match();
        int[] allowlike = objMatch.matchingUsersProfile();

        int[][] wholikedwho = createWholikedwho();
        //int[] likesarray = createLikesarray();
        Stack<Integer> chatbudz = createChatbudz();
        //addLike(likesarray, 0);
        isTrue(wholikedwho, 0, 0);
        mutualLike(0, 0, wholikedwho, chatbudz);
        setToTwo(wholikedwho, 0, 0);
        


    }
}
