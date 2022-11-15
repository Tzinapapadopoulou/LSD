import java.util.Stack;

public class Like {

    public static int[][] createWholikedwho() {
        int[][] wholikedwho = new int[10][10];
        for (int i = 0; i < wholikedwho.length; i++) {
            for (int j = 0; j < wholikedwho[0].length; j++) { 
                wholikedwho[i][j] = 0; 
            }
        }
        return wholikedwho;
    }
    
    public static int[] createLikesarray() {
        int[] likesarray = new int[10];
        return likesarray;
    }
    
    
    //int chatbudz[][] = new chatbudz[45][2];   // (n*(n-1))/2 , όπου n πλήθος των χρηστών με τον ίδιο προορισμό

    public static int[] addLike(int likesarray[], int userliked) {
        likesarray[userliked]++;
        return likesarray;
    }

    public static int[][] isTrue(int wholikedwho[][], int userliker, int userliked) {
        wholikedwho[userliker][userliked] = 1;
        return wholikedwho;
    }

    public static Stack<Integer> createChatbudz() {
        Stack<Integer> chatbudz = new Stack<Integer>(); 
        return chatbudz;
    }
    
    public static Stack<Integer> mutualLike(int userliker, int userliked, int wholikedwho[][], Stack<Integer> chatbudz) {
        if ( (wholikedwho[userliker][userliked] == wholikedwho[userliked][userliker] ) && ( wholikedwho[userliker][userliked] != 2) ) {
            chatbudz.push(userliker);
            chatbudz.push(userliked);
        }
        return chatbudz;
    }
    
    public static int[][] setToTwo(int wholikedwho[][], int userliked, int userliker) {
        wholikedwho[userliker][userliked] = 2;
        wholikedwho[userliked][userliker] = 2;
        return wholikedwho;
    }

    public static void main(String[] args) {
        createWholikedwho();
        createLikesarray();
        createChatbudz();
        addLike(null, 0);
        isTrue(null, 0, 0);
        mutualLike(0, 0, null, null);
        setToTwo(null, 0, 0);
    }
}