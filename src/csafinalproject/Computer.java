package csafinalproject;

import csafinalproject.core.GameSprite;
import java.awt.*;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Computer extends Player {
    
    public Computer(Game game) {
        super(game);
        
        add(new GameSprite("cardbot.gif"), BorderLayout.SOUTH);
    }
    
    public void playTurn() {
        super.playTurn();
        
        ArrayList<Integer> options = deck.getRankList();
        int rank = options.get(new Random().nextInt(0, options.size()));
        
        JLabel rankLabel = new JLabel();
        rankLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
        rankLabel.setText(Integer.toString(rank) + "?");
        rankLabel.setForeground(Color.YELLOW);
        rankLabel.setHorizontalAlignment(0);
        add(rankLabel, BorderLayout.NORTH);
        
        Timer thinkTimer = new Timer(3000, (ActionListener) -> {
            Player opponent = game.getOpponent();
            if (opponent.hasRank(rank)) {
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
            remove(rankLabel);
        });
        thinkTimer.setRepeats(false);
        thinkTimer.start();
    }
}
