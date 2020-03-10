/**
 * To create our first object oriented code
 *
 * @Ivan Hornung
 * @15 October 2019 // Holm
 */
public class PiggyBank
{
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;

    public PiggyBank(int p, int n, int d, int q) {
        pennies = p;
        nickels = n;
        dimes = d;
        quarters = q;
    }

    public PiggyBank() {
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
    }

    public void addPile(int p, int n, int d, int q) {
        pennies += p;
        nickels += n;
        dimes += d;
        quarters += q;
    }

    public int getValue() {
        int total = pennies;
        total += nickels * 5;
        total += dimes * 10;
        total += quarters * 25;
        return total;
    }

    public void addPennies(int p) {
        pennies += p;
    }

    public void addNickels(int n) {
        nickels += n;
    }

    public void addDimes(int d){
        dimes += d;
    }

    public void addQuarters(int q) {
        quarters += q;
    }

    public int getPennies() {
        return pennies;
    }

    public int getNickels() {
        return nickels;
    }

    public int getDimes() {
        return dimes;
    }

    public int getQuarters() {
        return quarters;
    }

    public void spend(double amount) {
        int amountCents = (int)(amount * 100);
        
        if(getValue() < amountCents )
            return;
        
        int qn = amountCents / 25;
        if (qn <= quarters ) {
            quarters -= qn;
            amountCents -= qn * 25;
        }
        else {
            amountCents -= quarters * 25;
            quarters = 0;
        }
        
        int dn = amountCents / 10;
        if(dn <= dimes ) {
            dimes -=dn;
            amountCents -= dn * 10;
        } else {
            amountCents -= dimes * 10;
            dimes = 0;
        }
        
        int nn = amountCents / 5;
        if(nn <= nickels) {
            nickels -= nn;
            amountCents -= nn * 5;
        } else {
            amountCents -= nickels * 5;
            nickels = 0;
        }
        
        pennies -= amountCents;
    }
}
