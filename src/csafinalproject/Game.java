package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.Random;

public class Game extends JPanel {
    private User user;
    private Computer bot;
    
    private Deck pond;
    private GameSprite pondSprite;
    
    private JPanel infoPanel;
    private JLabel userInfo, botInfo;
    
    private boolean currentTurn;
    
    public Game() {
        setLayout(new BorderLayout());
        
        user = new User(this);
        bot = new Computer(this);
        pond = new Deck();
        
        infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(Color.BLACK);
        add(infoPanel, BorderLayout.CENTER);
        
        pondSprite = new GameSprite("DrawPile.png");
        infoPanel.add(pondSprite);
        
        userInfo = new JLabel();
        userInfo.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        infoPanel.add(userInfo, BorderLayout.WEST);
        
        botInfo = new JLabel();
        botInfo.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
        infoPanel.add(botInfo, BorderLayout.EAST);
        
        add(user, BorderLayout.SOUTH);
        add(bot, BorderLayout.NORTH);
        
        // add cards to pond
        for (int r = 0; r < 13; r++) {
            for (int s = 0; s < 4; s++)
                pond.addCard(new Card(r));
        }
        
        // deal 5 cards to the user and bot
        for (int i = 0; i < 5; i++) {
            pond.moveCard(new Random().nextInt(0, pond.deckSize()), user.deck);
            pond.moveCard(new Random().nextInt(0, pond.deckSize()), bot.deck);
        }
        
        // start game
        SwingUtilities.invokeLater(() -> nextTurn());
    }
    
    public void nextTurn() {
        // end the game when both user and bot deck's are empty
        if (user.getDeck().deckSize() == 0 && bot.getDeck().deckSize() == 0) {
            updateUI();
            
            // decide who has the most books
            String winner = "TIE";
            if (user.getBooks() != bot.getBooks())
                winner = (user.getBooks() > bot.getBooks()) ? "YOU WIN" : "BOT WIN";
            infoPanel.remove(pondSprite);
            
            JLabel winLabel = new JLabel(winner);
            winLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 64));
            winLabel.setForeground(Color.YELLOW);
            winLabel.setHorizontalAlignment(0);
            infoPanel.add(winLabel, BorderLayout.CENTER);
        }
        else {
            // try to start the current player's turn
            currentTurn = !currentTurn;
            (currentTurn ? user : bot).attemptTurn();
        }
    }
    
    public void updateUI() {
        super.updateUI();
        
        if (isShowing()) {
            // set backgrounds to a random color 
            Color backColor = Color.getHSBColor(new Random().nextInt(0, 256) / 256f, .9f, .5f);
            user.setBackground(backColor);
            bot.setBackground(backColor);
            
            // update user and bot info
            userInfo.setForeground(currentTurn ? Color.YELLOW : Color.GRAY);
            botInfo.setForeground(currentTurn ? Color.GRAY : Color.YELLOW);
            
            userInfo.setText("<html>Player" + user.toString());
            botInfo.setText("<html>Bot" + bot.toString());
        }
    }
    
    // opponent getter
    public Player getOpponent() {
        return !currentTurn ? user : bot;
    }
    
    // pond deck getter
    public Deck getPond() {
        return pond;
    }
}