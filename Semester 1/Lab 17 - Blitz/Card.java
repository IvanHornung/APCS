public class Card {
    private int value;              // value 2 - 14
    private String suit;            // "Spades", "Hearts", "Clubs", "Diamonds"
    
    public Card() {
        value = 1;
        suit = "Spades"; 
    }
    
    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public String toString() {
        String answer = "";
        String[] faceCards = {"Jack", "Queen", "King", "Ace"};
        if (value > 10)
            answer += faceCards[value - 11];
        else
            answer += value;
        answer += " of " + suit;
        return answer;
    }
    
    public int compareTo(Card other) {
        return this.value - other.value;
    }
}
