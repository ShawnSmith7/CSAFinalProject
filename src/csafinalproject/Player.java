package csafinalproject;

import javax.swing.*;
import java.awt.*;

public abstract class Player extends JPanel {
    protected Game game;
    protected Deck deck;
    
    private JLabel info;
    
    private int books;
    
    public Player(Game game) {
        deck = new Deck();
        books = 0;
        
        this.game = game;
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 170));
        setBackground(Color.GRAY);
        
        info = new JLabel();
        info.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        add(info, BorderLayout.WEST);
    }
    
    public final void attemptTurn() {
        if (deck.deckSize() == 0) {
            if (game.getPond().deckSize() > 0) {
                for (Integer i : game.getPond().getRankList())
                    game.getPond().moveRanks(i, deck);
            }
            else {
                game.nextTurn();
                return;
            }
        }
        playTurn();
    }
    
    public void playTurn() {
        game.updateUI();
    }
    
    public final void mergeCardsToBooks() {
        for (Integer o : deck.getRankList()) {
            if (deck.getRankGroupCount(o) == 4) {
                deck.removeRanks(o);
                books++;
            }
        }
    }
    
    // check the deck for a card with the same rank
    public final boolean hasRank(int rank) {
        if (deck.deckSize() == 0) return false;
        
        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.getCard(i).getRank() == rank)
                return true;
        }
        return false;
    }
    
    // grabs a random card from the pond
    public final void goFish() { 
        game.getPond().moveCard(game.getPond().getRandomIndex(), deck);
    }
    
    // deck getter
    public final Deck getDeck() { 
        return deck; 
    }
    
    public final String toString() {
        return "<br>Cards: " + deck.deckSize() + "<br>Books: " + books;
    }
}
