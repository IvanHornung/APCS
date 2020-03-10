//Hornung
import java.util.Scanner;
public class Coins
{
        public static void main( String[] args )
        {
            Scanner input = new Scanner( System.in );
            System.out.println( "Please enter the total purchase price of your item(s) : ");
            double purchasePrice = input.nextDouble();
            System.out.println( "Please enter the amount of cash tendered for the purchase(s) : ");
            double cashTendered = input.nextDouble();
            
            double change = ((cashTendered) % (purchasePrice)) * 100;
            int dollars = (int)(change/100);
            int cents = (int)(change%100); //w
            
            int quarters = cents / 25;
            
            int štaJošOstaje = cents - (quarters * 25); //w
            
            System.out.println(štaJošOstaje);
            int dimes = štaJošOstaje / 10;
     
            int štaJošOstaje_brojDva = štaJošOstaje - ( dimes * 10);
            int nickels = štaJošOstaje_brojDva / 10;
            
            int ŽivotJeŽivot = štaJošOstaje_brojDva - ( nickels * 5);
            int pennies = ŽivotJeŽivot / 1;
            
            
            System.out.println( "Your change is " + dollars + " dollars and " + cents + " cents.");
            System.out.println( cents + " cents is returned as: ");
            System.out.println( (quarters) + " quarters" );
            System.out.println( (dimes) + " dimes" );
            System.out.println( (nickels) + " nickels" );
            System.out.println( (pennies) + " pennies" );

         }
}
