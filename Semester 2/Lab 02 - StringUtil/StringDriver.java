
import java.util.*;

public class StringDriver
{
    public static void main(String [] args ) {
        driver();
    }
    
    public static void driver()
    {
        Scanner in = new Scanner(System.in);
        String input;
        
        System.out.println("\nEnter a string to be reversed.");
        input = in.nextLine();
        System.out.println("===>\t" + 
            StringUtil.reverse(input));

        System.out.println("\nEnter a string to be cleaned.");
        input = in.nextLine();
        System.out.println("===>\t" +  
            StringUtil.clean(input));

        System.out.println("\nEnter a string to be checked for palindromes.");
        input = in.nextLine();
        if (StringUtil.isPalindrome(input))
            System.out.println("\"" + input + "\" is a palindrome");
        else	
            System.out.println("\"" + input + "\" is not a palindrome");

        System.out.println("\nEnter a string to find the position of the first vowel.");
        input = in.nextLine();
        System.out.println("===>\t" + 
            StringUtil.findFirstVowel(input));

        System.out.println("\nEnter a word to piggify");
        input = in.nextLine();
        System.out.println("===>\t" +  
            StringUtil.piggify(input));

        System.out.println("\n*{Extra Credit}\nEnter a sentence to piggify");
        input = in.nextLine();
        System.out.println("===>\t" +  
            StringUtil.piggifySentence(input));
    }
}

