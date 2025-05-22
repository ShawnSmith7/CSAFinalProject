package csafinalproject;

import csafinalproject.Game;

public class Player {
    private Game game;
    private Deck deck;
    
    private int id;
    
    public Player(Game game) {
        this.game = game;
        deck = new Deck();
    }
    
    public int getID() { return id; }
    public Deck getDeck() { return deck; }
}
