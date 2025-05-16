package csafinalproject;

public class Player {
    private Deck hand;
    
    public Player(Deck _hand) {
        hand = _hand;
    }
    
    public Deck getHand() {
        return hand;
    }
    
    public void setHand(Deck _hand) {
        hand = _hand;
    }
    
    public void addCard() {
        //deck methods dont exist yet
        //hand.addCard();
    }
    
    public void discard(int index) {
        //hand.discard(index);
    }
    
    protected void draw(int numberOfCards, Deck deck) {
        
    }
}
