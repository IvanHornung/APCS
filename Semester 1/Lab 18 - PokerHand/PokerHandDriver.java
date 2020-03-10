public class PokerHandDriver {
    public static void main(String[] args) {
        //play();
        testPlay();
    }

    public static void play() {
        Deck deck = new Deck();
        deck.shuffle();
        PokerHand hand = new PokerHand();
        for (int i = 0; i < 5; i++) {
            hand.receive(deck.deal());
        }
        hand.printOut();
    }

    public static void testPlay() {
        Deck deck = new Deck();
        PokerHand hand = new PokerHand();
        
        Card one = new Card(13, "Hearts");
        hand.receive(one);
        
        Card two = new Card(13, "Spades");
        hand.receive(two);
        
        Card three = new Card(8, "Clubs");
        hand.receive(three);
        
        Card four = new Card(8, "Diamonds");
        hand.receive(four);
        
        Card five = new Card(13, "Clubs");
        hand.receive(five);
        
        hand.printOut();
    }
}
