import java.util.Scanner;

public class Blitz {
    private int oneScore;
    private int twoScore;
    private Card[] oneHand;
    private Card[] twoHand;
    private int cardsLeft;
    private int warPoints;

    public Blitz() {
        cardsLeft = 26;
        oneHand = new Card[cardsLeft];
        twoHand = new Card[cardsLeft];
        oneScore = 0;
        twoScore = 0;
        warPoints = 1;
        fillHands();
    }

    private void fillHands() {
        Deck deck = new Deck();
        deck.shuffle();
        
        for(int i = 0; i < cardsLeft; i++) {
            oneHand[i] = deck.deal();
            twoHand[i] = deck.deal();
        }
        //fill oneHand and twoHand with cards from the deck
    }

    public void play() {
        Scanner scan = new Scanner( System.in );
        
        for(int i = 0; i < cardsLeft; i++) {
            System.out.println("Player one plays a " + oneHand[i].toString() );
            System.out.println("Player two plays a " + twoHand[i].toString() );
            if( oneHand[i].getValue() == twoHand[i].getValue() ) {
                warPoints++;
                System.out.println("It's a war!");
            } else if ( oneHand[i].getValue() > twoHand[i].getValue() ) {
                oneScore += warPoints;
                System.out.println("Player one wins!");
                warPoints = 1;
            } else {
                twoScore += warPoints;
                System.out.println("Player two wins!");
                warPoints = 1;
            }
            System.out.println("Player one: " + oneScore + "\tPlayer two: " + twoScore);
            String pause = scan.nextLine(); //pauses until a button is pressed; last line in loop
        }
        //Enter code to play the game with outputs as shown
    }
}
