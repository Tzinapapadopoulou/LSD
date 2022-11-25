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
    //intializing wholikedwho array

    public static int[] createLikesarray() {
        int[] likesarray = new int[10];
        for (int i = 0; i < likesarray.length; i++) {
            likesarray[i] = 0;
        }
        return likesarray;
    }
    //initializing likesarray
    

    public static int[] addLike(int likesarray[], int userliked) {
        likesarray[userliked]++;
        return likesarray;
    }
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
        int[][] wholikedwho = createWholikedwho();
        int[] likesarray = createLikesarray();
        Stack<Integer> chatbudz = createChatbudz();
        addLike(likesarray, 0);
        isTrue(wholikedwho, 0, 0);
        mutualLike(0, 0, wholikedwho, chatbudz);
        setToTwo(wholikedwho, 0, 0);
    }
}

    //int chatbudz[][] = new chatbudz[45][2];   // (n*(n-1))/2 , όπου n πλήθος των χρηστών με τον ίδιο προορισμό
