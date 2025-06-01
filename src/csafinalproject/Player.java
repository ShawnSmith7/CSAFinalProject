package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.util.Random;

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
    
    // called when it is the player's turn
    public void startTurn() {
        game.updateUI();
    }
    
    // ask the opponent for a rank and decide the next turn
    public void playRank(int rank) {
        Player opponent = game.getOpponent();
        
        // check the opponents deck for a card that has this rank
        boolean foundMatch = opponent.getDeck().hasRank(rank);
        
        // if a matching card is found take all cards from the opponents deck with this rank
        // else go fish and check if the card matches
        if (foundMatch)
            opponent.getDeck().moveRanks(rank, deck);
        else {
            game.getPond().moveCard(new Random().nextInt(0, game.getPond().deckSize()), deck);
            foundMatch = deck.getCard(0).getRank() == rank;
        }
        
        collectBooks();
        
        if (foundMatch) attemptTurn();
        else game.nextTurn(); 
    }
    
    public void attemptTurn() {
        // if this player's deck is empty
        if (deck.deckSize() == 0) {
            // take all cards from the pond or skip turn if the pond already has no cards
            if (game.getPond().deckSize() > 0) {
                for (Integer i : game.getPond().getOptionsList())
                    game.getPond().moveRanks(i, deck);
            }
            else {
                game.nextTurn();
                return;
            }
        }
        startTurn();
    }
    
    // collect books from this player's deck
    public void collectBooks() {
        // get count of each rank group
        for (Integer o : deck.getOptionsList()) {
            // if count equals 4 remove all cards of that rank and increment book count
            if (deck.getRankGroupCount(o) == 4) {
                deck.removeRanks(o);
                books++;
            }
        }
    }
    
    public Deck getDeck() { return deck; }
    public int getBooks() { return books; }
    
    public String toString() { return "<br>Cards: " + deck.deckSize() + "<br>Books: " + books; }
}
