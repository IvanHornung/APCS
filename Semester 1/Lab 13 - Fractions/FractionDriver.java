// Holm 10/16/19
// Lab 13 Starter
// Driver program for a simple fraction calculator

import java.util.*;

public class FractionDriver {
    public static void main( String[] args ) {
        // declare and initialize three Fraction objects, a, b, c
        // first argument represents the numerator; second argument represents denominator
        Fraction a = new Fraction(4,5);
        Fraction b = new Fraction(3,7);
        // creating a fraction with no arguments should result in a fraction of 0/1
        Fraction c = new Fraction();
        boolean done = false;
        Scanner scan = new Scanner( System.in );
        //The toString method should return the fraction as a String (e.g., "3 / 4")
        System.out.println("a = " + a + " and b = " + b);
        while (!done)
        {
            System.out.println("\nWelcome to the fraction calculator"); 
            System.out.println("1:  Set fraction a");
            System.out.println("2:  Set fraction b");
            System.out.println("3:  Multiply a * b");
            System.out.println("4:  Divide a / b");
            System.out.println("5:  Add a + b");
            System.out.println("6:  Subtract a - b");
            System.out.println("7:  Set a to its reciprocal");
            System.out.println("8:  Set a random fraction c");
            System.out.println("9:  Raise a to a positive integer power");
            System.out.println("0:  Quit");
            int input = scan.nextInt();
            if (input == 1)
            {
                System.out.print("Enter the numerator for a");
                int num = scan.nextInt();
                System.out.print("Enter the denominator for a");
                int denom = scan.nextInt();
                a.setNumerator(num);
                a.setDenominator(denom); 
                System.out.println("a now equals " + a );
                //printing an object's reference automatically calls that object's toString method
            }
            else if (input == 2)
            {
                System.out.println("Enter the numerator and denominator for b");
                int num = scan.nextInt();
                int denom = scan.nextInt();
                b.setFraction(num, denom);
                System.out.println("b now equals " + b );
            }
            else if (input == 3)
            {
                c = a.multiply(b);
                System.out.println("a * b = " + c );
            }
            else if (input == 4)
            {
                c = a.divide(b);
                System.out.println("a / b = " + c);
            }
            else if (input == 5)
            {
                c = a.add(b);
                System.out.println("a + b = " + c);
            }
            else if (input == 6)
            {
                c = a.subtract(b);
                System.out.println("a - b = " + c);
            }
            else if (input == 7)
            {
                a.makeReciprocal();
                System.out.println("a has been set to its reciprocal. It is now " + a);
            }
            else if (input == 8)
            {
               c = Fraction.createRandomFraction();        // sets c to have a random numerator -10 to 10,
               System.out.println("c = " + c);             // and a random denominator, 1-100
            }
            else if (input == 9)
            {
                System.out.println("Enter the positive integer that will raise a to that power");
                int pow = scan.nextInt();
                a.power(pow);
                System.out.println("a = " + a);
            }
            else if (input == 0)
            {
                done = true;
                System.out.println("Goodbye");
            }           
        }
    }   
}
