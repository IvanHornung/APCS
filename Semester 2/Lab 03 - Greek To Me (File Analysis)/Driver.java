public class Driver
{
    //Pre: compile button pressed and method is selected to run
    //Post: outputs the entire assignment by accessing the go() method in the Analyzer class
    public static void main (String[] args) {
        Analyzer a = new Analyzer();
        a.go();
    }
}
