public class EightQueens {
    static boolean[][] board;

    static int[] rd = 
        {1,-1,0,0,1,1,-1,-1};
    static int[] cd = 
        {0,0,-1,1,1,-1,1,-1};

    //Constructor: just initializes board instance variable & fills it with no queens
    public EightQueens() {
        board = new boolean[8][8];
        for(int r = 0; r < board.length; r++ ) {
            for(int c = 0; c < board[r].length; c++ ) {
                board[r][c] = false;
            }
        }
    }

    //Pre-Condition: method is called.
    //Post-Condition: lab output is printed.
    public static void go() {
        //System.out.println("Possibilites "+ howManyPossibilities()+"\n\n");
        if(hasEightQueens(0)) printBoard();
        else System.out.println("An error occurred.");
    }

    //Pre-Condition: method is called with y,x parameters of the newly formed queen's coordinates
    //Post-Condition: T/F is return depending on whether the coordinates are not in another queen's range
    public static boolean isSafe(int r, int c) {
        for(int i = 0; i < rd.length; i++ ) {
            int m = 1; //multiplier
            while((r+rd[i]*m < board.length && r+rd[i]*m >=0) && (c+cd[i]*m < board[r+rd[i]*m].length && c+cd[i]*m >= 0)){
                if(board[r+(rd[i]*m)][c+(cd[i]*m)]) return false;
                m++;
            } 
        }
        return true;
    }
  
    //Pre-Condition: method is called with parameter 0
    //Post-Condition: recursive method adjusts the board to place queens in a manner where eight queens can fit
    public static boolean hasEightQueens(int row) {
        if(row == board.length) return true;
        for( int c = 0; c < board[row].length; c++ ) {
            if(isSafe(row,c)) {
                board[row][c] = true;
                if(hasEightQueens(row+1)) return true;
                board[row][c] = false;
            }
        }
        return false;
    }

    //Pre-condition: method is called & board is full
    //Post-condition: the board is printed
    public static void printBoard() {
        System.out.println("\t01234567");
        for(int r = 0; r < board.length; r++ ) {
            System.out.print(r+"\t");
            for(int c = 0; c < board[r].length; c++ ) {
                if(!board[r][c]) System.out.print("-");
                else System.out.print("Q");
            }System.out.println();
        }
    }
}
