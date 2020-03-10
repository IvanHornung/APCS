//Hornung
//Lab 9 - FunLoops
//To exercise using loops in Java

import java.util.*;

public class FunLoops
{
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();
        fun.go();
    }

    public void go()
    {
        Scanner keys = new Scanner(System.in);
        System.out.println("Enter two numbers and I will find the least common multiple");
        int first = keys.nextInt();
        int second = keys.nextInt();
        int lcm = findLCM(first, second);
        System.out.println("The LCM of " + first + " and " + second + " is " + lcm);

        System.out.println("Enter an integer to be reversed");
        int forward = keys.nextInt();
        int backward = reverse(forward);
        System.out.println("" + forward + " reversed is " + backward);

        System.out.println("How many magic squares do you want to find?");
        int number = keys.nextInt();
        magicSquares(number);
    }

    // pre: one and two > 0
    // post: returns the least common multiple of one and two
    public int findLCM(int one, int two)
    {
        int mltp = 1;
        while ( (mltp%one) != 0 || (mltp%two) != 0) 
            mltp++;
        return mltp;
    }

    //optional: find GCF

    public int reverse( int number )
    {
        int backwards = 0, digit;
        while (number != 0){
            digit = number % 10;
            backwards = 10*backwards + digit;
            number /= 10;
        }
        return backwards;
    }

    public void magicSquares( int howMany )
    {
        int printed = 0;
        for (int num = 1 ; printed < howMany ; num++ ) {
            int sqr = num*num;
            int sum = 0;
            for (int inc = 1; sum <= sqr ;inc++) {
                sum += inc;
                if (sum == sqr) {
                    System.out.println(sqr + " is  Magic Square!");
                    printed++;
                }
            }
        }
    }
}
