package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player {
    
    private JLabel messageLabel;
    
    public Computer(Game game) {
        super(game);
        
        // create message box and 
        JPanel messageBox = new JPanel();
        messageBox.setBackground(Color.BLACK);
        add(messageBox, BorderLayout.NORTH);
        
        messageLabel = new JLabel();
        messageLabel.setFont(new Font("OCR A Extended", Font.BOLD, 32));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setHorizontalAlignment(0);
        messageBox.add(messageLabel, BorderLayout.NORTH);
        
        add(new GameSprite("cardbot.gif"), BorderLayout.SOUTH);
    }
    
    // overrides abstract player method startTurn
    public void startTurn() {
        super.startTurn();
        
        // Pick a random option from the deck to ask the user for
        ArrayList<Integer> options = deck.getOptionsList();
        int rank = options.get(new Random().nextInt(0, options.size()));
        
        // Show the choice the computer made
        messageLabel.setText(Integer.toString(rank) + "?");
        
        // Play a short timer to make it look like the computer is thinking
        Timer thinkTimer = new Timer(3000, (ActionListener) -> {
            messageLabel.setText("");
            playRank(rank);
        });
        thinkTimer.setRepeats(false);
        thinkTimer.start();
    }
}
