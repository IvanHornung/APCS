//Hornung
//Lab 11 - FACT BIN FACT
//To practice/exercise loop building and method calling skills
import java.util.*;
class FactBinFact {
    public static void main(String args[]) {
        System.out.println("\n\n\n====================================END================================\n\n");
        Scanner input = new Scanner(System.in);

        System.out.println("===============Method=1===Factorial==================");

        // Method 1: Find factorial
        System.out.println("For how many numbers do you want to find the factorial for?");
        int factorialRun = input.nextInt();
        System.out.println("Which method do you want to use for this? Standard (0) or method inside method (1)?");
        int factorialMethod = input.nextInt();
        for (int x = 1; x <= factorialRun; x++){
            System.out.println("\tReturn the factorial of: ");
            int numF = input.nextInt();
            long factorial;

            if(factorialMethod == 0)
                factorial = factorial(numF);
            else
                factorial = factorial(numF);

            System.out.println("\tThe factorial of " + numF + " is: " + factorial);
        }

        System.out.println("===============Method=2===Base=Conversion============");

        //Method 2: binary conversion
        System.out.println("How many different base conversions will you be doing?");
        int amntBC = input.nextInt();
        for(int i = 1; i <= amntBC; i++){
            System.out.println("\tHow many times do you want to commit a base conversion #" + i + "?");
            int baseConversionRun = input.nextInt();
            System.out.println("\tWhich method do you want to use for this?\n\t Binary (0)\n\t Hexadecimal(1)\n\t Any base from 2 to 9 (2)");
            int bCMethod = input.nextInt();
            for (int x = 1; x <= baseConversionRun; x++){
                System.out.println("\tConvert this number: ");
                int numC = input.nextInt(), factorial;
                if(bCMethod == 0){
                    System.out.println("The number " + numC + " in binary is ");
                    toBinary(numC);
                }else if (bCMethod == 1){
                    System.out.println("The number " + numC + " in hexadecimal form is ");
                    toHexadecimal(numC);
                }else{
                    System.out.println("\tBase [2, 9] : ");
                    int base = input.nextInt();
                    baseConversion(numC, base);
                }
            }
        }

        System.out.println("===============Method=3===Prime=Factors=============");

        // Method 3: Print prime factors
        System.out.println("For how many numbers do you want to find the Prime Factors for?");
        int pfRange = input.nextInt();

        for (int x = 1; x <= pfRange; x++){
            System.out.println("\tEnter number: ");
            int numPF = input.nextInt();
            primeFactors(numPF);
        }

        input.close();
    }
    /*STANDARD*/
    //PreConditions = number inputted; PostConditions = factorial is returned
    public static long factorial(int numF) {
        long sum = 1;
        for (int inc = numF; inc >= 1; inc--) {
            sum *= inc;
        }
        return sum;
    }
    
    //*METHOD INSIDE METHOD*/Recursive version of factorial()
    //PreConditions = number inputted; PostConditions = factorial is returned
    public static int factorial2(int num) {
        if (num == 0)
            return 1;

        return num * factorial2(num - 1);
    }

    //PreConditions = number inputted; PostConditions = binary conversion is returned
    public static void toBinary(int numB) {
        baseConversion(numB, 2);
    }

    //PreConditions = number inputted, along with base to convert that number to; PostConditions = base conversion from a number between 2 and 9 is returned
    public static void baseConversion(int numB, int baseInput) {
        int work = numB, digit;
        String s = "";

        while (work > 0){
            digit = work % baseInput;
            work /= baseInput;
            s = digit + s;
        }

        System.out.println(s);
    }

    //PreConditions = number inputted; PostConditions = hexadecimal conversion is returned
    public static void toHexadecimal(int numB) {
        int work = numB, digit;
        String s = "";
        char c;

        while (work > 0){
            digit = work % 16;
            work /= 16;
            if (digit > 10 ) {
                c = (char) ('A' + (digit - 10));
                s = c + s;
            }
            else s = digit + s;
        }

        System.out.println(numB + " to hexadecimal: " + s);
    }

    /*No need to check prime because this is a faster way to do it*/
    //PreConditions = number inputted; PostConditions = binary conversion is returned
    public static void primeFactors(int prInput) {

        int divisor = 2, iterVar = prInput;
        System.out.print("The prime factors of " + prInput + " are ");
        while (iterVar != 1) {
            while (iterVar % divisor == 0) {
                if (iterVar != prInput)
                    System.out.print(", ");

                System.out.print(divisor);
                iterVar /= divisor;
            }
            divisor++;
        }
    }
}
