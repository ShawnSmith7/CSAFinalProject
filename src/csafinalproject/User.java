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
    public void startTurn() {
        super.startTurn();
        
        canClick = false;
    }
    
    public void cardClicked(Card card) {
        if (!canClick) {
            canClick = true;
            playRank(card.getRank());
        }
    }
}

