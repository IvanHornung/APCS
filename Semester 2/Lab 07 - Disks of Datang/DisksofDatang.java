public class DisksofDatang {
    private int turn = 1;
 
    public static void main(String[] args) {
    }
 
    //Pre: A string is provided
    //Post: Returns true if the string provided is a palindrome.
    public boolean isPalindrome( String s ) {
        if ( s.equals(rev(s)) )  return true;
        return false;
    }
    
    //Pre: A string is provided
    //Post: String is reversed.
    public String rev(String s) {
        if ( s.length() == 1 ) return s;
        return rev(s.substring(1)) + s.charAt(0);
    }
 
    //Pre: A string is provided
    //Post: Returns true if alphabetical
    public boolean isAlphabetical(String str) {
        if( str.length()==1 )
            return true;
        return isAlphabetical(str.substring(1)) && str.substring(0,1).compareTo(str.substring(1,2)) <= 0;
    }
    
    //Pre: receives a number of disks, from peg, to peg, and the extra peg. 
    //Post: Prints out the number of moves it takes to solve the puzzle of Datang
    public void datang(int numDisks, char from, char to, char extra) {
        if(numDisks == 1) {
            turn++;
            System.out.println("Turn #" + turn + "\t" + from + "-" + to);
        } else{
            datang(numDisks-1, from, extra, to);
            turn++;
            System.out.println("Turn #" + turn + "\t" + from + "-" + to);
            datang(numDisks-1, extra, to, from);
        }
    }
}
