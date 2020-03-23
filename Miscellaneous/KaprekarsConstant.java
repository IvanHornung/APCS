//Hornung
//Practice Problems for test, in methods, in one class.

import java.util.*;

public class KaprekarsConstant
{
    public static void main( String[] args ) {        
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n========================================================================\n\n\n");

        System.out.println("I will find the highest digit in number: ");
        int findBig = input.nextInt();
        findBiggestDigit run = new findBiggestDigit();

        if ( !run.allDigitsAreSame(findBig) )
            System.out.println("Constant = " + run.kaprekarsConstant(findBig));
        else
            System.out.println("Wow...");
        
        
    }

    public int sortDigits(int nonVandalized) {
        int i = 0, times = 0;
        
        while(nonVandalized != 0 || times < 4){
            int biggest = 0, num = 0, pos = 1, posB = 0;
            int findBig = nonVandalized;
            while(findBig > 0) {
                num = findBig % 10;
                if (num > biggest ) {
                    biggest = num;
                    posB = pos;
                }
                findBig /= 10;
                pos *= 10;
            }
            nonVandalized -= posB * biggest;
            i = ( 10 * i ) + biggest;
            times++;
        }
        return i;
    }
    
    public int flipDigits(int digitToFlip ) {
        int num = 0, sum = 0;
        
        while(digitToFlip > 0) {
            num = digitToFlip % 10;
            sum = ( 10 * sum ) + num;
            digitToFlip /= 10;
        }
        
        return sum;
    }
    
    public int kaprekarsConstant(int num ) {
       int i = 0, x = sortDigits(num), y = flipDigits(x);
       
       
       while ( x - y != 6174) {
           int subT = x - y;
           x = sortDigits(subT);
           y = flipDigits(x);
           i++;
        }
        
       return i;
    }
    
    public boolean allDigitsAreSame(int num ) {
        int numX = 0, uhOhs = 0, inc = 0;
         //1111
        while ( num != 0 ) {
            numX = num % 10;
            num /= 10;
            inc++;
            if (numX == (num % 10 ))
                uhOhs++;
        }
        
        if (uhOhs == (inc-1) )
            return true;
        else
            return false;
    }
}
