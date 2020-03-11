import java.io.*;
import java.util.*;

public class StringUtil {
    
    //Pre: receives a String parameter
    //Post: returns a String that is the exact inverse of the parameter input
    public static String reverse(String s) {
        String rev = "";
        for(int i = s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }

    //Pre: receives a String parameter
    //Post: returns a String consisting of only lowercase letters, all other characters are removed
    public static String clean(String s ) {
        String rev = "";
        for(int i = 0; i <= s.length()-1; i++ ) {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122 ) 
                rev += s.charAt(i);
        }
        return rev;
    }

    //Pre: receives a String parameter
    //Post: returns a String where all uppercase letters have become lowercase ones
    //and the String is filtered of any punctuation (sets grounds for main palindrome function)
    public static String palindromeClean( String s ) {
        String rev = "";
        for(int i = 0; i <= s.length()-1; i++ ) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                char cap = (char)(s.charAt(i) + 32);
                rev += cap;
            }
            if(( s.charAt(i) >= 97 && s.charAt(i) <= 122) ) {
                rev += s.charAt(i);
            }
        }
        return rev;
    }

    //Pre: receives a String parameter
    //Post: returns a boolean value assessing whether the parameter is a palindrome or not
    //      (disregarding any capitalization differences and punctuation)
    public static boolean isPalindrome(String s ) {
        String ms = palindromeClean(s);
        for(int i = 0; i < (int)((ms.length()-1)/2); i++ ) {
            if(ms.charAt(i) != ms.charAt(ms.length()-1-i) ) 
                return false;
        }
        return true;
    }

    //Pre: receives a String parameter
    //Post: returns a String indicating the visual (not actual) index of the first vowel in the 
    //      parameters (not including y). Returns "nothing." if the parameter is vowel-less
    public static String findFirstVowel(String s) {
        s = nocap(s);
        for(int i = 0; i <= s.length()-1; i ++ ) {
            if(s.charAt(i) == 97 || s.charAt(i) == 101 || s.charAt(i) == 105 || s.charAt(i) == 111 || s.charAt(i) == 117 ) {
                return i + 1 + "";
            }
        }
        return "nothing.";
    }

    //Pre: receives a String parameter
    //Post: returns the integer value of the raw, actual index of the first vowel in the String;
    //          used for the Pig Latin methods.
    public static int findFirstVowelNumber(String s) {
        s = nocap(s);
        for(int i = 0; i <= s.length()-1; i ++ ) {
            if(s.charAt(i) == 97 || s.charAt(i) == 101 || s.charAt(i) == 105 || s.charAt(i) == 111 || s.charAt(i) == 117 ) {
                return i;
            }
        }
        return -1;
    }

    //Pre: receives a String parameter
    //Post: returns the String parameter in Pig-Latin form
    public static String piggify(String s ) {
        if(findFirstVowelNumber(s) == -1 ) return s + "ay";
        if(findFirstVowelNumber(s) == 0) return s + "yay";
        return s.substring(findFirstVowelNumber(s)) + s.substring(0, findFirstVowelNumber(s) ) + "ay";
    }

    //Pre: receives a String parameter
    //Post: returns the sentence parameter, where each individual word in the sentence has been
    //converted into Pig-Latin, while maintaining the same sentence structure as well as capitalizing.
    public static String piggifySentence(String s ) {
        String pl = "";
        String plf = "";
        int prev = 0;

        s = nocap(s);

        for(int i = 0; i < s.length() ; i++ ) {
            if( ( s.charAt(i) >= 32 && s.charAt(i) <= 64 ) || ( s.charAt(i) >= 91 && s.charAt(i) <= 96 ) || ( s.charAt(i) >= 123 && s.charAt(i) <= 126 ) ) { 
                if(s.charAt(i-1) >= 97 && s.charAt(i-1) <= 122) {
                    pl += piggify( s.substring(prev, i ) );
                }
                pl += s.charAt(i);
                prev = i + 1;
            }
        }
        
        boolean uppercased = false;
        
        for(int i = 0; i < pl.length(); i++) {
            if(!uppercased) {
                if(pl.charAt(i) >= 97 && pl.charAt(i) <= 122 ) {
                    plf += (char)(pl.charAt(i) - 32 );
                    uppercased = true;
                }
            }
            else plf += pl.charAt(i);
        }
        
        return plf;
    }
    
    //Pre: receives a String parameter
    //Post: returns a String in which all uppercase letters are changed to lowercase
    public static String nocap( String phrase ) {
        for(int i = 0; i < phrase.length(); i++ ) {
            if(phrase.charAt(i) >= 65 && phrase.charAt(i) <= 90 ) {
                phrase = phrase.substring(0, i) + (char)(phrase.charAt(i) + 32) + phrase.substring(i + 1);
            }
        }
        return phrase;
    }
}
