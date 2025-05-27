package csafinalproject;

import java.awt.*;
import javax.swing.*;

public class User extends Player {
    private boolean canClick;
    
    public User(Game game) {
        super(game);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalGlue());
        add(deck);
    }
    
    // allow the player to click their cards when their turn is called
    public void playTurn() {
        super.playTurn();
        
        canClick = false;
    }
    
    public void cardClicked(Card card) {
        if (!canClick) {
            canClick = true;
            int rank = card.getRank();
            
            Player opponent = game.getOpponent();
            if (opponent.hasRank(rank)) {
                opponent.getDeck().moveRanks(rank, deck);   // take the opponents cards
                mergeCardsToBooks();
                
                attemptTurn();                                 // play turn again
            }
            else {
                goFish();                                   // go fish
                int fishRank = deck.getCard(0).getRank();
                mergeCardsToBooks();
                
                if (fishRank == rank)                       // card pulled has rank you picked
                    attemptTurn();                           // play turn again
                else
                    game.nextTurn();                        // next player turn
            }
        }
    }
}

