public class PokerHand {
    private Card[] cards;
    private int i;
    private int[] values;
    private int[] suits;

    public PokerHand() {
        cards = new Card[5];
        i = 0;
        values = new int[13];
        suits = new int[4];
    }

    public void receive(Card c) {
        cards[i] = c;
        i++;
        values[c.getValue()-2]++;
        
        if(c.getSuit() == "Spades") suits[0]++;
        else if(c.getSuit() == "Hearts") suits[1]++;
        else if(c.getSuit() == "Clubs") suits[2]++;
        else suits[3]++;
    }

    public String evaluate() {
        if(isStraight() && isFlush()) return "Straight Flush!";
        if(isFourOfAKind()) return "Four of a Kind!";
        if(isFullHouse())  return "Full House!";
        if(isFlush()) return "Flush!";
        if(isStraight()) return "Straight!";
        if(isThreeOfAKind()) return "Three of a Kind!";
        if(isTwoPair()) return "Two Pair!";
        if(isOnePair()) return "One Pair!";
        return "High Card!";
    }

    public boolean isFourOfAKind() {
        for(int i = 0; i < values.length; i++) { 
            if(values[i] >= 4 ) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        int threeCount = 0, twoCount = 0;
        for(int i = 0; i < values.length; i++) { 
            if(values[i] == 3 ) {
                threeCount++;
            } else if(values[i] == 2) {
                twoCount++;
            }
        } if (threeCount == 1 && twoCount == 1) return true;
        return false;
    }

    public boolean isThreeOfAKind() {
        for(int i = 0; i < values.length; i++) { 
            if(values[i] == 3 ) {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPair() {
        int twoCount = 0;
        for(int i = 0; i < values.length; i++) { 
            if(values[i] == 2) {
                twoCount++;
            }
        }

        return twoCount == 2;
    }

    public boolean isOnePair() {
        for(int i = 0; i < values.length; i++) { 
            if(values[i] == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight() {
        int prevIndex = Integer.MAX_VALUE, count = 0;
        for(int i = 0; i < values.length; i++) {
            if(values[i] == 1){
                if(i == prevIndex + 1) count++;
                prevIndex = i;
            }
        }
        return count >= 4;
    }

    public boolean isFlush() {
        String temp;
        for(int i = 0; i < suits.length; i++) {
            if(suits[i] == 5) {
                return true;
            }
        }
        return false;
    }

    public void printOut() {
        System.out.println(evaluate());
        for(int i = 0; i < cards.length; i++ ) {
            System.out.println(cards[i].toString());
        } System.out.println("\n--------------------------------------------------------\n");
    }
}
