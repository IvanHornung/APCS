//Hornung | Holm | LabSO6 - RECURSION INTRO RECURSION
import java.util.*;
public class Driver {
    public static void main(String[] args){
        Recursion rcs = new Recursion();
        Scanner input = new Scanner(System.in);
 
        System.out.println("Enter number for method 1.");
        int sm = input.nextInt();
        System.out.println(rcs.sumOfFirstNNumbers(sm));
 
        System.out.println("Enter number to factorialize.");
        int fctr = input.nextInt();
        System.out.println(rcs.factorialize(fctr));
 
        System.out.println("Enter index for Fibonacci.");
        int fb = input.nextInt();
        System.out.println(rcs.fibValue(fb));
 
        System.out.println("Enter number to \"collatz\".");
        int cltz = input.nextInt();
        System.out.println(rcs.collatz(cltz));
        
        input.close();
    }
}
