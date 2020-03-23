public class KnightsTour {
    static int[][] vector = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1},
        };

    static int[][] board;

    //Pre-condition: method is called
    //Post-condition: lab output is returned
    public static void go() {
        if(solve(0,0,0))
            printBoard();
        else
            System.out.println("--Error--");
    }

    //Constructor: initializes array and sets all values equal to -1
    public KnightsTour() {
        board = new int[8][8];
        for(int r = 0; r < board.length; r++ ) {
            for(int c = 0; c < board[r].length; c++ ) {
                board[r][c] = -1;
            }
        }
    }

    //Pre-condition: method is called with y,x coordinate parameters
    //Post-condition: true/false is returned depending on whether the position is valid or not
    //                     valid=on board AND not already occupied.
    public static boolean isSafe(final int r, final int c) {
        if ((r < board.length && r >= 0 && c < board[r].length && c >= 0) && board[r][c] == -1)
            return true;
        return false;
    }

    // Pre-condition: method is called with three integer parameters of 0
    // Post-condition: recursive method modifies all values on board to correspond
    // with lab prompt
    public static boolean solve(final int count, final int row, final int col) {
        board[row][col] = count;
        if (count == 63)
            return true;

        for (int v = 0; v < vector.length; v++) {
            final int newRow = row + vector[v][0];
            final int newCol = col + vector[v][1];
            if(isSafe(newRow,newCol))  {
                // if (count < 50)
                //     System.out.println("c = " + count + ", v = " + v);
                if(solve(count+1, newRow, newCol))
                    return true;
            }
        }
        board[row][col] = -1;
        //printBoard();
        return false;
    }

    //Pre-condition: method is called
    //Post-condition: visualization of the board is outputted.
    public static void printBoard() {
        System.out.print('\u000C');
        System.out.println("\t0  1  2  3  4  5  6  7");
        for(int r = 0; r < board.length; r++ ) {
            System.out.print(r+"\t");
            for(int c = 0; c < board[r].length; c++ ) {
                if(board[r][c] == -1 ) System.out.print("# ");
                else if(board[r][c] < 10) System.out.print(" "+board[r][c] + " ");
                else System.out.print(board[r][c] + " ");
            } System.out.println();
        }
    }
}
