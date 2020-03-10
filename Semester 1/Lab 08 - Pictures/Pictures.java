//Hornung
//Lab 8 - Pictures
//Construct thoughtful for loops within methods.

import gpdraw.*;
import java.util.*;
import java.awt.Color;
import java.util.Random; //used for random color generator

public class Pictures {
    //use this information similar to that in Lab 4
    private DrawingTool myPencil;
    private SketchPad myPaper;

    public Lab8_Pictures() {
        myPaper = new SketchPad( 750, 750 );
        myPencil = new DrawingTool( myPaper );
        Random rand = new Random();
        int totalLines = 360;
        for ( int t = 1; t<=totalLines; t++) {
            myPencil.setColor( new Color( rand.nextInt(255), rand.nextInt(255),rand.nextInt(255) ) );
            myPencil.home();
            myPencil.turnRight(t);
            myPencil.down();
            myPencil.forward(250);
            myPencil.up();
        }
    }

     public void printTable(int rows, int columns) {
        for (int c = 1; c <= columns; c++) {
            System.out.print( "\t" + c );
        }
        System.out.println("\n");
        for ( int r = 1; r<= rows; r++) {
            System.out.print(r + "\t");
            for (int c = 1; c <= columns; c++) {
                int multiple = r * c;
                System.out.print(multiple + "\t");
            }
            System.out.println();
        }
    }

    public void makePyramid(int pyramidSize) {
        for ( int p = 1; p <= pyramidSize; p++) {
            for ( int i = 1; i <= (pyramidSize-p); i++)
                System.out.print(" ");
            int amountofA = (p-1) * 2 + 1;
            for ( int a = 1; a <= amountofA; a++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main( String[] args ) {
        Lab8_Pictures obj = new Lab8_Pictures();
        obj.doStuff();
    }

    public void doStuff() {
        //use this method to call the other three methods
        System.out.println("\n\n--------------------------------------------------------------------\n\n");
        Scanner tableRow = new Scanner( System.in );
        System.out.println("Enter the amount of columns for the multiplication table: ");
        int rows = tableRow.nextInt();
        Scanner tableColumn = new Scanner( System.in );
        System.out.println("Enter the amount of rows for the multiplication table: \n\n");
        int columns = tableColumn.nextInt();

        printTable(columns, rows);

        System.out.println("\n\n--------------------------------------------------------------------\n\n");
        Scanner pSize = new Scanner( System.in );
        System.out.println("Enter the size of the pyramid: ");
        int pyramidSize = tableRow.nextInt();

        makePyramid(pyramidSize);
    }
}
