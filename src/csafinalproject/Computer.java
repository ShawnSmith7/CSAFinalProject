package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {
    
    private JLabel choiceLabel;
    
    public Computer(Game game) {
        super(game);
        
        choiceLabel = new JLabel();
        choiceLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
        choiceLabel.setForeground(Color.YELLOW);
        choiceLabel.setHorizontalAlignment(0);
        add(choiceLabel, BorderLayout.NORTH);
        
        add(new GameSprite("cardbot.gif"), BorderLayout.SOUTH);
    }
    
    public void startTurn() {
        super.startTurn();
        
        // Pick a random option from the deck to ask the user for
        ArrayList<Integer> options = deck.getRankList();
        int rank = options.get(new Random().nextInt(0, options.size()));
        
        // Show the choice the computer made
        choiceLabel.setText(Integer.toString(rank) + "?");
        
        // Play a short timer { it looks like the computer is thinking :) }
        Timer thinkTimer = new Timer(3000, (ActionListener) -> {
            choiceLabel.setText("");
            playRank(rank);
        });
        thinkTimer.setRepeats(false);
        thinkTimer.start();
    }
}
