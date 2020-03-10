import java.util.*;
public class Grades {
        public static void main( String[] args) {
            double totalPoints = 0, numClasses = 0;
            boolean hasF = false;
            int count = 0; //Quality of life feature that helps the user know how many classes have been inputted
            int numberofF = 0; //Extension that counts for F’s
          boolean valid = true;

            //Format
            System.out.println("\n\n\n\n===================================================================\n\n"); 
           
            Scanner input = new Scanner( System.in );
            //Inputs
            while( valid ) {
                boolean el4H = true; //Eligible for Honors, used to not give honors credit if the student has an F in the honors class
                boolean el4P = true; //Eligible for Points, used to not 土0.3 points if the grade has a + or - sign. Used for F’s and A’s.
                
                count++; 
                System.out.println("-----------------------------" + count + "---------------------------");
                System.out.println( "Please enter a grade (enter any non-letter grade value when done): ");
                char grade = input.next().charAt(0);
                if (grade == 'A' || grade == 'a') {
                    totalPoints += 4.0;
                    numClasses++;
                    el4P = false;
                }
                else if (grade == 'B' || grade == 'b') {
                    totalPoints += 3.0;
                    numClasses++;
                }
                else if (grade == 'C' || grade == 'c') {
                    totalPoints += 2.0;
                    numClasses++;
                }
                else if (grade == 'D' || grade == 'd') {
                    totalPoints += 1.0;
                    numClasses++;
                }
                else if (grade == 'F' || grade == 'f') {
                    hasF = true;
                    numClasses++;
                    numberofF++;
                    el4H = false;
                    el4P = false;
                }
                else 
                    valid = false;
                
                System.out.println( "Please enter grade sign ('+', '-', '.' if grade is solid): ");
                char sign = input.next().charAt(0);
                System.out.println( "Please enter class level ('P' for Advanced Placement, 'H' for Honors, 'S' for Standard ): ");
                char level = input.next().charAt(0);
                
                    
                if (el4P) {
                    if(sign == '+') 
                        totalPoints += 0.3;
                    else if(sign == '-')
                        totalPoints -= 0.3;
                }
                
                if (el4H && ( level == 'P' || level == 'p' || level == 'H' || level == 'h') ) 
                    totalPoints++;
            }
            
            boolean gpaBelow = false;
            double gpa = totalPoints/numClasses;

           if (gpa < 2.0)
                gpaBelow = true; 
            
            //Outputs
            if(numClasses < 4)
                System.out.println("GPA = " + gpa + ", Ineligible - student is taking fewer than four classes.");
            else if(gpaBelow) 
                System.out.println("GPA = " + gpa + ", Ineligible - GPA is below 2.0.");
            else if(hasF && !gpaBelow) 
                System.out.println("GPA = " + gpa + ", Ineligible - GPA is at or above 2.0 but student has " + numberofF + " failing grade(s).");
            else if(hasF && gpaBelow) 
                System.out.println("GPA = " + gpa + ", Ineligible - GPA is below 2.0 and student has " + numberofF + " failing grade(s).");
            else 
                System.out.println("GPA = " + gpa + ", Eligible.");
        }
}
