//Hornung
//Lab 13 - Fractions
//To deepen our knowledge/familiarity with object-oriented programming whilst //exercising our Java skills.
public class Fraction {
    private int numer;
    private int denom;

    /**constructor when both values are given */
    public Fraction(int n, int d ) {
        setFraction(n, d);
    }

    /**precondition: constructor when both values are given */
    public Fraction () {
        numer = 0;
        denom = 1;
    }
    
    //returns this numerator
    public int getNum() {
        return numer;
    }

    //returns this denominator
    public int getDenom() {
        return denom;
    }

    //updates this numerator when called
    public void setNumerator(int nNumerator ) {
        numer = nNumerator;
        reduce();
    }

    //updates this denominator when called
    public void setDenominator(int nDenominator) {
        denom = nDenominator;
        reduce();
    }
    
    //precondition: method is called with appropriate integers
    //postcondition: this numerator and denominator are updated in reduced form
    public void setFraction(int nNumerator, int nDenominator ) {
        numer = nNumerator;
        denom = nDenominator;
        reduce();
    }

    
    public String toString () {
        return numer + "/" + denom;
    }

    /** precondition: other is valid Fraction object */
    //postcondition: the sum of objects/fractions a & b are returned as a new fraction
    public Fraction add(Fraction other) {
        int newNum, newDenom;

        if ( denom == other.getDenom() ) {
            newNum = numer + other.getNum();
            newDenom = denom;
        } else {
            newDenom = findLCM(denom, other.getDenom() );
            int numer1 = newDenom / denom;
            int numer2 = newDenom / other.getDenom();
            newNum = (numer * numer1) + (other.getNum() * numer2);
        }

        return new Fraction (newNum, newDenom );
    }

    /** precondition: other is valid Fraction object */
    //postcondition: object/fraction b is subtracted from object/fraction a, as a new fraction
    public Fraction subtract(Fraction other){
        int newNum, newDenom;

        if ( denom == other.getDenom() ) {
            newNum = numer - other.getNum();
            newDenom = denom;
        } else {
            newDenom = findLCM(denom, other.getDenom() );
            int numer1 = newDenom / denom;
            int numer2 = newDenom / other.getDenom();
            newNum = (numer * numer1) - (other.getNum() * numer2);
        }

        return new Fraction(newNum, newDenom);
    }

    //precondition: method is called
    //postcondition: this fraction is updated with most simplified form
    public void reduce(){
        int g = findGCF(numer, denom);
        numer /= g;
        denom /= g;
    }

    //Precondition: num1 and num2 are positive integers
    //Postcondition: greatest common factor of num1 and num2 is returned
    public int findGCF(int num1, int num2) {
        int factor = num1;
        while ( num1 % factor != 0 || num2 % factor != 0 ) 
            factor --;
        return factor;
    }

    // pre: one and two > 0
    // post: returns the least common multiple of one and two
    public int findLCM(int one, int two)
    {
        int mltp = 1;
        while ( (mltp%one) != 0 || (mltp%two) != 0) 
            mltp++;
        return mltp;
    }

    /** precondition: other is valid Fraction object */
    //post: return a new Fraction representing the product of this and other
    public Fraction multiply(Fraction other) {
        int newNum = numer * other.getNum();
        int newDen = denom * other.getDenom();
        return new Fraction ( newNum, newDen );
    }

    /**precondition: other is a valid Fraction object */
    //postcondition: return a new Fraction representing the division of this and other
    public Fraction divide(Fraction other) {
        int newNum = numer * other.getDenom();
        int newDen = denom * other.getNum();
        return new Fraction ( newNum, newDen );
    }

    //precondition: method is called
    //postcondition: fraction is inverse -- numerator and denominator swap places
    public void makeReciprocal() {
        if ( numer == 0 )
            return;

        int recDenom, recNumer;
        recNumer = denom;
        recDenom = numer;
        numer = recNumer;
        denom = recDenom;
    }

    //precondition: method is called
    //postcondition: a random fraction with a numerator [-10, 10] and a denominator [1, 100] is created
    public static Fraction createRandomFraction () {
        int numer = (int)(Math.random() * 21 ) - 10;
        int denom = (int)(Math.random() * 100) + 1;
        return new Fraction(numer, denom);
    }

    //precondition: user inputted a positive integer
    //postcondition: fraction is raised to inputted integer's power
    public void power(int pow) {
        if (pow == 0) {
            setFraction(1,1);
        }
        int num = 1, den = 1;
        for ( int i = 1; i <= pow; i++) {
            num *= numer;
            den *= denom;
        }

        setFraction(num,den);
    }
}
