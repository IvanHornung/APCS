//Hornung
//Lab 6 - Loops with methods
//To practice using methods in java
import java.util.*;

public class LoopsWithMethods
{
    public static void main (String[] args)
    {
        LoopsWithMethodsHornung obj = new LoopsWithMethodsHornung();
        obj.doStuff();
    }// ends method main

    public void doStuff()
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number and I will tell you if it is prime or not" );
        int number = input.nextInt();

        boolean isPrime = checkPrime( number );         // method #1
        if ( isPrime )
            System.out.println( "Your number, " + number + ", is prime!" );
        else
            System.out.println( "Your number, " + number + ", is composite!" );

        calculateAverage();                             // method #2

        System.out.println( "Enter an annual contribution towards saving $1,000,000" );
        int contribution = input.nextInt();
        System.out.println( "Enter an annual interest rate" );
        double rate = input.nextDouble();
        printInvestmentTable( contribution, rate );     // method #3
    }// ends method doStuff
    //Precondition: number is a user-entered integer
    //Postcondition: true is returned if number is prime; false otherwise
    public boolean checkPrime( int number ) {
        int denom = 2;
        while (denom < number)
        {
            if(number % denom == 0 )
                return false;

            denom++;
        }
        if (number == 0 || number == 1)
            return false;
        
        return true;
    }

    //Precondition: method calling to calculate average
    //Postcondition: average of user-ented scores with lowest score dropped is printed
    public void calculateAverage()
    {
        Scanner averageInput = new Scanner( System.in );
        System.out.println("Enter test score between 0 and 100, -1 to quit");
        int count = 1 , totalScore = 1,testScore = 0 , lowestScore = 101;

        while ( testScore != -1 )
        {
            testScore = averageInput.nextInt();

            totalScore += testScore;
            count++;

            if ( testScore != -1 && lowestScore > testScore )
                lowestScore=testScore;
        }
        double average = (totalScore-lowestScore)/(double)(count-3);
        System.out.println ("Your average is "+ average);
    }

    //Precondition: contribution and rate are user-entered values
    //Postcondition: printed table of earned interest and balance until $1,000,000 is reached
    public void printInvestmentTable( int contribution, double rate )
    {
        double total = 0, tTotal = 0, intEarned = 0;
        int yr = 0; //year
        System.out.println("Year\t\tContribution\t\tTotal\t\tInterest Earned\t\tNew Total");
        rate /= 100;
        while(tTotal <= 1000000 ) {
            yr++;
            total = tTotal + contribution;
            intEarned = rate * total;
            tTotal = intEarned + total;
            
            //output
            System.out.println(yr + "\t\t" + contribution + "\t\t\t" + (int)(total) + "\t\t" + (int)(intEarned) + "\t\t\t" + (int)(tTotal));
        }
    }// ends methods printInvestmentTable

}// end class LoopsWithMethods
