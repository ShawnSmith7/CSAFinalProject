package csafinalproject;

import javax.swing.*;
import java.awt.*;

public abstract class Player extends JPanel {
    protected Game game;
    protected Deck deck;
    
    private int books;
    
    public Player(Game game) {
        deck = new Deck();
        books = 0;
        
        this.game = game;
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 170));
        setBackground(Color.BLUE);
    }
    
    public void startTurn() {
        game.updateUI();
    }
    
    public void playRank(int rank) {
        Player opponent = game.getOpponent();
        if (opponent.getDeck().hasRank(rank)) {
            opponent.getDeck().moveRanks(rank, deck);       // take the opponents cards
            mergeCardsToBooks();

            attemptTurn();                                  // play turn again
        }
        else {
            goFish();                                       // go fish
            int fishRank = deck.getCard(0).getRank();
            mergeCardsToBooks();
            if (fishRank == rank)                           // card pulled has rank you picked
                attemptTurn();                              // play turn again
            else
                game.nextTurn();                            // next player turn
        }
    }
    
    public void attemptTurn() {
        if (deck.cardCount() == 0) {
            if (game.getPond().cardCount() > 0) {
                for (Integer i : game.getPond().getRankList())
                    game.getPond().moveRanks(i, deck);
            }
            else {
                game.nextTurn();
                return;
            }
        }
        startTurn();
    }
    
    public void mergeCardsToBooks() {
        for (Integer o : deck.getRankList()) {
            if (deck.getRankGroupCount(o) == 4) {
                deck.removeRanks(o);
                books++;
            }
        }
    }
    
    public void goFish() { 
        game.getPond().moveCard(game.getPond().getRandomIndex(), deck);
    }
    
    public Deck getDeck() { return deck; }
    public int getBooks() { return books; }
    
    public String toString() {
        return "<br>Cards: " + deck.cardCount() + "<br>Books: " + books;
    }
}
