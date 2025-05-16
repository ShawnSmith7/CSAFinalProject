package csafinalproject;

public class Card {
    public enum Suit { BLUE, GREEN, PURPLE, YELLOW };
    
    private int number;
    private Suit suit;
    
    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }
    
    public int getNumber() {
        return number;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public boolean compare(Card card) {
        return number == card.getNumber() || suit == card.getSuit();
    }
}
