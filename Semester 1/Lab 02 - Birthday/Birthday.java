//Hornung
//Lab 2 - Birthday
//Practice using operators and formatting output

public class Birthday
{
        public static void main( String[] args )
        {
            int month = 6;
            int date = 24;
            int year = 2003;
            
            int firstTwo = year/100;
            int lastTwo = year%100;
            int monthVariaton = 13 * (month+1) / 5;
            
            
            int leapYear = lastTwo / 4;
            int leapCentury = firstTwo / 4 - 2 * firstTwo;
            int day = date + lastTwo + monthVariaton + leapYear + leapCentury;
            day = day + 70;
            
            day %= 7;
            
            System.out.println("0 is Saturday");
            System.out.println("1 is Sunday");
            System.out.println("2 is Monday");
            System.out.println("3 is Tuesday");
            System.out.println("4 is Wednesday");
            System.out.println("5 is Thursday");
            System.out.println("6 is Friday");
            
            
            System.out.println( month + "-" + date + "-" + year + " falls on " + day );
        }
}
