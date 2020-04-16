import java.util.*;
 
public class DriverDatang {
    public static void main(String[] args) {
        DisksofDatang obj = new DisksofDatang();
        Scanner input = new Scanner(System.in);
        System.out.println(obj.isPalindrome(input.next()));
        System.out.println(obj.isAlphabetical(input.next()));
        obj.datang(4,'a','b','c');
    }
}
