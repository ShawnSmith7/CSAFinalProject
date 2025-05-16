package csafinalproject;

import javax.swing.JPanel;

public class Game extends JPanel {
    private Deck drawPile;
    private Deck discardPile;
    
    private Player[] players;
    private int turnID;
    
    public Player getNextPlayer() {
        return players[(turnID + 1) % players.length];
    }
    
    public Player getPreviousPlayer() {
        return players[(turnID - 1) % players.length];
    }
    
    public Deck getDrawPile() {
        return drawPile;
    }
    
    public Deck getDiscardPile() {
        return discardPile;
    }
    
    public Card getCurrentCard() {
        return null;
    }
    
    private void dealCards() {
        // Deal 7 cards to each player's deck
    }
}
