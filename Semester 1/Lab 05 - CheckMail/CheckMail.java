//Hornung
//Lab 5 - CheckMail
//To determine whether or not a package is eligible for shipping
import java.util.*;
public class CheckMail
{
    public static void main(String[] args)
    {
        System.out.println("-----------------------------------------------------------");
        System.out.println(" ");
        System.out.println("//===================INPUTS=====================\\");
        double weight, length, dim1, dim2, dim3;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Please enter the weight (pounds) of the package :");
        weight = input.nextDouble();
        String nice, nice2, nice3, nice4;
        if(weight == 42) {
            Scanner theAnswer = new Scanner(System.in);
            System.out.println("Where did you find the answer to Life, the Universe, and Everything?");
            String fortyTwo = theAnswer.next();
        }
        System.out.println("2. Please input the first dimension (inches):");
        dim1 = input.nextDouble();
        if(dim1 == 42) {
            Scanner theAnswer = new Scanner(System.in);
            System.out.println("Where did you find the answer to Life, the Universe, and Everything?");
            String fortyTwo = theAnswer.next();
        }
        System.out.println("3. Please input the second dimension (inches): ");
        dim2 = input.nextDouble();
        if(dim2 == 42) {
            Scanner theAnswer = new Scanner(System.in);
            System.out.println("Where did you find the answer to Life, the Universe, and Everything?");
            String fortyTwo = theAnswer.next();
        }
        System.out.println("4. Please input the third dimension(inches): ");
        dim3 = input.nextDouble();
        if(dim3 == 42) {
            Scanner theAnswer = new Scanner(System.in);
            System.out.println("Where did you find the answer to Life, the Universe, and Everything?");
            String fortyTwo = theAnswer.next();
        }
        if(dim3 == 69) {
            Scanner niceness = new Scanner(System.in);
            System.out.println("Nice.");
            nice = niceness.next();
        }
        
        
        double longest = 0;
        double height = 0;
        double width = 0;
        boolean weightTooHeavy = false;
        
        //Determine the longest side of the package
        if( dim1 >= dim2 && dim1 >=dim3 )
        {
            longest = dim1;
        }
        else if( dim2 >= dim1 && dim2 >= dim3 )
        {
            longest = dim2;
        }
        else
        {
            longest = dim3;
        }
        //Determine the height/width (it doesn't matter)
        while(true) {
            if( dim1 != longest)
            {
             height = dim1;
               break;
          }
           else if( dim2 != longest )
           {
              height = dim2;
              break;
         }
          else if(dim3 != longest)
            {
             height = dim3;
              break;
        }
    }
        //Determine the height/width (it doesn't matter)
        while(true) {
         if( dim1 != longest && dim1 != height )
            {
                width = dim1;
                break;
          }
        else if( dim2 != longest && dim2 != height )
           {
               width = dim2;
               break;
         }
         else if( dim3 != longest && dim3 != height )
         {
              width = dim3;
              break;
        }
    }
        //Too heavy?
        if( weight > 70 )
        {
            weightTooHeavy = true;
            //System.out.println("too heavy");
        }
        
        //System.out.println(longest + ", "+ width + ", " + height);
       
        
        double GIRTH = ((width*2)+(height*2));
        double largeStatus = GIRTH + longest;
        //System.out.println(largeStatus);
        boolean tooLarge = false;
        
        //Too large?
        if(largeStatus > 100)
        {
            tooLarge = true;
           // System.out.println("too large"); //opt
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("//===================OUTPUTS=====================\\");

        //===================OUTPUTS========================\\
        
        while(true) {
         if( weightTooHeavy & tooLarge == true) {
             System.out.println("Package is too large and too heavy.");
               break;
          }
           else if( tooLarge == true) {
               System.out.println("Package is too large.");
              break;
         }
          else if( weightTooHeavy == true) {
                System.out.println("Package is too heavy.");
            break;
        }
        else {
             System.out.println("Package may be shipped first class.");
             break;
           }
    }
    //  :)
    }
    
}
