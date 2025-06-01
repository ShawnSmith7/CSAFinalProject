package csafinalproject;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class User extends Player {
    private boolean canClick;
    
    public User(Game game) {
        super(game);
        
        // center the deck in the container
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        add(deck);
    }
    
    public void startTurn() {
        super.startTurn();
        
        // user can click their cards
        canClick = false;
    }
    
    public void cardClicked(Card card) {
        // play the clicked card
        if (!canClick) {
            canClick = true;
            playRank(card.getRank());
        }
    }
}

