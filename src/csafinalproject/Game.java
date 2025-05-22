package csafinalproject;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import csafinalproject.Card.Color;
import csafinalproject.core.GameSprite;

public class Game extends JPanel {
    private Deck drawPile;
    private Deck discardPile;
    
    private Player[] players;
    private int turnID;
    
    public Game()
    {
        setLayout(new BorderLayout());
        setBackground(java.awt.Color.BLACK);
        
        players = new Player[4];
        drawPile = new Deck();
        discardPile = new Deck();
        
        for (int i = 0; i < players.length; i++)
            players[i] = new Player(this);
        
        for (int c = 0; c < 4; c++) 
        {
            for (int n = 0; n < 20; n++) 
                drawPile.addCard(new Card(n, Color.values()[c]));
        }
        
        GameSprite drawPileButton = new GameSprite("card-hidden.png");
        GameSprite banner = new GameSprite("background.png");
        
        banner.setLayout(new BorderLayout());
        
        add(banner, BorderLayout.CENTER);
        add(players[0].getDeck(), BorderLayout.SOUTH);
        
        banner.add(drawPileButton, BorderLayout.EAST);
        banner.add(discardPile, BorderLayout.CENTER);
        
        dealCards();
    }
    
    public Player getNextPlayer() {
        return players[(turnID + 1) % players.length];
    }
    
    public Player getPreviousPlayer() {
        return players[(turnID - 1) % players.length];
    }
    
    public Deck getDrawPile() {
        return drawPile;
    }
    
    public Deck getDiscardPile() {
        return discardPile;
    }
    
    public Card getCurrentCard() {
        return null;
    }
    
    private void dealCards() {
        for (Player p : players) {
            for (int i = 0; i < 7; i++) {
                int index = new Random().nextInt(0, drawPile.getCardCount() - 1);
                drawPile.moveCard(index, p.getDeck());
            }
        }
        drawPile.moveCard(0, discardPile);
    }
}
