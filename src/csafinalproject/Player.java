package csafinalproject;

import csafinalproject.Game;
import csafinalproject.core.GameSprite;

public class Player extends GameSprite {
    private Game game;
    private Deck deck;
    
    private int id;
    
    public Player(Game game) {
        super("buddy.png");
        
        this.game = game;
        deck = new Deck();
    }
    
    public void decideMove() {
        
    }
    
    public int getID() { return id; }
    public Deck getDeck() { return deck; }
}
