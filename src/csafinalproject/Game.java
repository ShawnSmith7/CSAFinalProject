package csafinalproject;

import csafinalproject.core.GameSprite;
import java.awt.*;
import javax.swing.*;

public class Game extends JPanel {
    private User user;
    private Computer bot;
    
    private Deck pond;
    private JLabel userInfo, botInfo;
    
    private GameSprite pondSprite;
    private JPanel middlePanel;
    
    private boolean currentTurn;
    
    public Game() {
        setLayout(new BorderLayout());
        
        user = new User(this);
        bot = new Computer(this);
        pond = new Deck();
        
        // add cards to pond
        for (int r = 0; r < 13; r++) {
            for (int s = 0; s < 4; s++)
                pond.addCard(new Card(r));
        }
        
        // deal 5 cards to the user and bot
        for (int i = 0; i < 5; i++) {
            user.goFish();
            bot.goFish();
        }
        
        middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.setBackground(Color.BLACK);
        add(middlePanel, BorderLayout.CENTER);
        
        pondSprite = new GameSprite("DrawPile.png");
        middlePanel.add(pondSprite);
        
        userInfo = new JLabel();
        userInfo.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        middlePanel.add(userInfo, BorderLayout.WEST);
        
        botInfo = new JLabel();
        botInfo.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        middlePanel.add(botInfo, BorderLayout.EAST);
        
        add(user, BorderLayout.SOUTH);
        add(bot, BorderLayout.NORTH);
        
        // start game
        SwingUtilities.invokeLater(() -> nextTurn());
    }
    
    public void nextTurn() {
        if (user.getDeck().deckSize() == 0 && bot.getDeck().deckSize() == 0) {
            updateUI();
            
            String winner = "TIE";
            
            if (user.getBooks() != bot.getBooks()) {
                winner = (user.getBooks() > bot.getBooks()) ? "YOU WIN" : "BOT WIN";
            }
            
            middlePanel.remove(pondSprite);
            
            JLabel winLabel = new JLabel(winner);
            winLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 64));
            winLabel.setForeground(Color.YELLOW);
            winLabel.setHorizontalAlignment(0);
            middlePanel.add(winLabel, BorderLayout.CENTER);
        }
        else {
            currentTurn = !currentTurn;
            (currentTurn ? user : bot).attemptTurn();
        }
    }
    
    public void updateUI() {
        super.updateUI();
        
        if (isShowing()) {
            userInfo.setForeground(currentTurn ? Color.YELLOW : Color.GRAY);
            botInfo.setForeground(currentTurn ? Color.GRAY : Color.YELLOW);
            
            userInfo.setText("<html>Player" + user.toString());
            botInfo.setText("<html>Bot" + bot.toString());
        }
    }
    
    public Player getOpponent() {
        return !currentTurn ? user : bot;
    }
    
    public Deck getPond() {
        return pond;
    }
}