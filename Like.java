public class Like {
    // την μέθοδο like την καλούμε για κάθε χρήστη που κάνει λαικ
    int likesarray[] = new likesarray [10];
    int wholikedwho[][] = new wholikedwho[10][10];
    for (int i = 0; i < wholikedwho.length; i++) {
        for (int j = 0; j < wholikedwho[0].length; j++) {
            wholikedwho[i][j] = 0;
        }
    }
    //int chatbudz[][] = new chatbudz[45][2];   // (n*(n-1))/2 , όπου n πλήθος των χρηστών με τον ίδιο προορισμό

    Stack<Integer[][]> chatbudz = new Stack <Integer[][]>();

    public static int addLike(int likesarray[10], int userliked) {
        likesarray[userliked]++;
        return likesarray;
    }

    public static int isTrue(int wholikedwho[10][10], int userliker, int userliked) {
        wholikedwho[userliker][userliked] = 1;
        return wholikedwho;
    }

    public static int mutualLike(int userliker, int userliked, int wholikedwho[10][10]) {
        if ( (wholikedwho[userliker][userliked] == wholikedwho[userliked][userliker] ) && ( wholikedwho[userliker][userliked] =! 2) ) {
            chatbudz.push([userliker] [userliked]);
            return chatbudz;
        }
    }
    
    public static int setToTwo(int wholikedwho[10][10], int userliked, int userliker) {
        wholikedwho[userliker][userliked] = 2;
        wholikedwho[userliked][userliker] = 2;
        return wholikedwho;
    }
}

