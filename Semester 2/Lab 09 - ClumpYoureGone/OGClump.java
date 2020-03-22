//CODE FOR ORIGINAL GRID EVERY TIME

import java.util.*; import java.io.*;
public class Clump {
 
    //transformations done in the row (for the erase method)
    static int[] rd = 
        {-1, 0, 1, 0 };
 
    //transformations done in the column (for the erase method)
    static int[] cd = 
        { 0, 1, 0, -1};
    //grid declaration
    final static int size = 20;
    static boolean[][] grid = new boolean[size][size];
 
    //main method: reads coords from the text file, prints the original grid, requests
    //user input (which accesses other methods), and reprints the grid accordingly
    public void run() {
        /*try { //scan file
            final Scanner input = new Scanner(new File("pleasework.txt"));
            input.nextInt();
            while(input.hasNext()) {
                final int row = input.nextInt();
                final int column = input.nextInt();
                grid[row-1][column-1] = true;
            }
        } catch (final FileNotFoundException ex) {
        }*/
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                int fillIn = (int)(Math.random()*3);
                if(fillIn == 1) grid[r][c] = true;
            }
        }
        //print initial grid
        System.out.println("=========Input-Coordinates-to-Erase-The-Clump!=========");
        printGrid();
 
        //user input of coordinates to erase the clump
        final Scanner input = new Scanner(System.in);
        while (!isGridEmpty()) {
            System.out.println("Enter row:");
            final int row = input.nextInt();
            System.out.println("Enter column:");
            final int column = input.nextInt();
            bfs(row-1, column-1);
            printGrid();
        } 
        input.close();
    }
 
    /*Lesser efficient method
    erases all cell neighbors assuming the inputted coordinate falls on a cell
    //apparently this is "DFS"
    public static void eraseClump(final int r, final int c) {
        if( (r < grid.length && r >= 0) && (c < grid[r].length && c >= 0 ) ){
            if(grid[r][c]) {
                grid[r][c] = false;
                for(int i = 0; i < rd.length; i++) {
                    eraseClump(r+rd[i], c + cd[i]);
                }
            } 
        }
    }*/
 
    public static void bfs(final int r, final int c) {
        if(!grid[r][c]) return;    
        cleanBfs(r, c);
    }
    public static void cleanBfs(final int r, final int c) {
        grid[r][c] = false;
        for(int i = 0; i < rd.length; i++) {
            final int nr = r + rd[i];
            final int nc = c + cd[i];
            if( (nr < grid.length && nr >= 0) && (nc < grid[r].length && nc >= 0 ) && grid[nr][nc]){
                cleanBfs(nr, nc);
            }
        }
    } 
 
    public static boolean isGridEmpty() {
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c])
                    return false;
            }
        } return true;
    }
 
    public static void printGrid() {
        System.out.println("\n\t1  2 3  4 5 6 7  8 9  0 1  2 3  4  5 6 7 8  9 0"); //finding adequate spacing took SO LONG
        for(int r = 0; r < grid.length; r++) {
            System.out.print((r+1)+"\t");
            for(int c = 0; c < grid[r].length; c++ ) {
                if(grid[r][c]) {
                    System.out.print("⬛");
                }
                else System.out.print("⬜");
            }
            System.out.println();
        } 
    }
}
