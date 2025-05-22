package csafinalproject;

public class Player {
    protected Deck hand;
    protected String name;
    
    public Player(String _name, Deck _hand) {
        name = _name;
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
