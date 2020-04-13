public class Recursion {
    
    public int sumOfFirstNNumbers(int n) {
        if(n == 1) return 1;
        return n + sumOfFirstNNumbers(n-1);
    }
 
    public int factorialize(int n) {
        if(n == 0) return 1;
        int x = factorialize(n-1);
        System.out.println(n + " , " + x);
        return n * x;
    }
 
    public int fibValue( int n ){
        if(n == 0 || n == 1) return 1;
        return fibValue(n-1) + fibValue(n-2);
    }
    public int collatz( int n) {
        if(n == 1) return 0;
        if(n%2 == 0) return 1 + collatz(n/2);
        return 1 + collatz(n*3+1);
    }
}
