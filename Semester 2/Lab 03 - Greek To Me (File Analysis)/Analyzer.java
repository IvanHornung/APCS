import java.util.Scanner;
import java.io.*;
public class Analyzer {
    static String all = "";

    
    //Pre: Method is called in the driver
    //Post: by concatenating each line into one big string, the main method is called four times
    //which results in four different print outputs
    public static void go() {
        int wc = 0;

        try {
            //creates a Scanner object that can read from a specific text file
            Scanner input = new Scanner( new File( "Phaedo.txt") );
            while( input.hasNext() ) { //checks to see if there is more text in the file
                String line = input.nextLine(); //capture the next line of the text file
                //wc += countWords(line);
                all += line;
                all += " ";
            }
        } catch( FileNotFoundException ex ) {}

        mainMethod(all, 1);
        mainMethod(all, 2);
        mainMethod(all, 3);
        mainMethod(all, 4);
    }

    //Pre: the text being analyzed is a parameter, as a super-string. an integer must also be providing 
    //indicating what mode the method will output in (1 = word count, 2= longest word, 3= table of lengths, 4=greek names)
    //Post: output depending on the integer inserted as a second parameter. a print statement is executed, either
    //defining the amount of words in the text file, stating the largest word (and its length), a table of values
    //where the left hand side indicates the length of the word and the right hand side indicates the amount of words
    //in the text file that fall under that specific length, or a list of all different Greek names present in the text
    //file following the prompt's simple rules. Does this work? Yes. Is is efficient? Maybe. Is it organized? I would go with "no".
    //so I'm just gonna comment on everything so you don't get as lost as I would expect and person reading to be :))
    public static void mainMethod( String s, int r ) {
        System.out.println("\n========================================================="); //organization
        int count = 0, prevIndex = 0; //count = overall word count; prevIndex = used for storing the index of the previous word in order to determine the index of the current word
        int[] wordLength = new int[100]; //sorts the amount of words with x length as an array -- used for the table execution

        String lWord = ""; //stores the longest word as a String
        int lWL = 0; //stores longest word's length

        String greekNames = ""; //String-list of all greeknames separated by a new line

        String word = ""; //basic word String
        
        //goes through the super-String
        for(int i = 1; i < s.length(); i++ ) {
            if( ((s.charAt(i) >= 32 && s.charAt(i) <= 64 ) || (s.charAt(i) >= 91 && s.charAt(i) <= 96) || (s.charAt(i) >= 123 && s.charAt(i) <= 126 )) ) {
                if((i != 0) && (s.charAt(i-1) >= 65 && s.charAt(i-1) <= 90) || ( s.charAt(i-1) >= 97 && s.charAt(i-1) <= 122 ) ) {
                    //this statement can only be entered if the character i is currently on is a form of punctuation, the previous character is a letter
                    //(to make sure substrings such as ", " don't interfere with the word count), and i is not equal to 0 (prevents errors)
                    count++; //increase word count if all of this is true
                    word = s.substring(prevIndex+1, i); //distinguish word
                    wordLength[word.length()]++; //add whatever this word's word length to the array for the table 
                    if(word.length() > lWL) { //checks to see if the current word is longer than any previously encountered word
                        lWL = word.length(); //if true, then reassign long-word related values
                        lWord = word;
                    }
                    //below checks if the current word is a Greek Name.
                    if( (word.length() >= 4 ) && (word.charAt(0) >= 65 && word.charAt(0) <= 90 ) && ( (word.indexOf("ates") == word.length()-4 ) || (word.indexOf("us") == word.length()-2 ) || (word.indexOf("to") == word.length()-2 ) ))  {
                        if(greekNames.indexOf(word) == -1) //if this word is not already in the list,
                            greekNames += word + "\n"; //add it to the list with a new line to separate it from the next Greek Name
                    }
                }
                if(i != s.length()-1) { //if we aren't on the last character (prevents outofbounds errors)
                    if((s.charAt(i+1) >= 65 && s.charAt(i+1) <= 90) || ( s.charAt(i+1) >= 97 && s.charAt(i+1) <= 122 ) ) //and if the next character is indeed a letter
                        prevIndex = i; //set this variable equal to the current index in order to create the following word
                }
            }
        }
        
        //If the "mode" entered is #, then execute that task accordingly
        if(r == 1)  System.out.println("Word Count:\t" + count);
        else if(r == 2) {
            System.out.println("Longest Word:\t" + lWord + "\tLength:\t" + lWL);
        }
        else if(r == 3) {
            System.out.println("Length\tNumber of Words");
            for( int i = 0; i < wordLength.length; i++ ) {
                if(wordLength[i] != 0 ) {
                    System.out.println(i + "\t" + wordLength[i]);
                }
            }
        }
        else if(r == 4) {
            System.out.println("Greek Names:\n" + greekNames);
        }
    }
}

