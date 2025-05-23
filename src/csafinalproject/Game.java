package csafinalproject;

import java.util.Random;
import javax.swing.*;
import java.awt.*;

import csafinalproject.Card.Color;
import csafinalproject.core.GameSprite;
import csafinalproject.core.TransparentPanel;

public class Game extends JPanel {
    private Deck drawPile;
    private Deck discardPile;
    
    private Player[] players;
    private int turnID;
    
    public Game()
    {
        setLayout(new BorderLayout());
        setBackground(java.awt.Color.BLACK);
        
        initGame();
        dealCards();
        
        updateUI();
        
        players[0].decideMove();
    }
    
    private void initGame() {
        // init discard pile
        discardPile = new Deck();
        discardPile.setLayout(new FlowLayout(FlowLayout.CENTER, -48, 0));
        
        // init draw pile
        drawPile = new Deck();
        for (int c = 0; c < 4; c++) {
            for (int n = 0; n < 20; n++) 
                drawPile.addCard(new Card(n, Color.values()[c]));
        }
        
        // init players
        players = new Player[2];
        for (int i = 0; i < players.length; i++)
            players[i] = new Player(this);
        
        // background banner
        GameSprite banner = new GameSprite("background.png");
        banner.setLayout(new BorderLayout());
        
        // draw pile panel
        TransparentPanel drawPanel = new TransparentPanel();
        drawPanel.setPreferredSize(new Dimension(225,0));
        drawPanel.setLayout(new BorderLayout());
        drawPanel.add(new GameSprite("card-hidden.png"), BorderLayout.CENTER);
        
        // player container
        Container playerContainer = new Container();
        playerContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        for (Player p : players) playerContainer.add(p);
        
        // player panel
        TransparentPanel playerPanel = new TransparentPanel();
        playerPanel.add(Box.createVerticalGlue());
        playerPanel.add(playerContainer);
        
        // discard pile panel
        TransparentPanel discardPanel = new TransparentPanel();
        discardPanel.setPreferredSize(new Dimension(225,0));
        discardPanel.add(Box.createVerticalGlue());
        discardPanel.add(discardPile);
        
        // add components :)
        add(players[0].getDeck(), BorderLayout.SOUTH);
        add(banner, BorderLayout.CENTER);
        
        banner.add(drawPanel, BorderLayout.EAST);
        banner.add(playerPanel, BorderLayout.CENTER);
        banner.add(discardPanel, BorderLayout.WEST);
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
    
    public Player getNextPlayer() { return players[(turnID + 1) % players.length]; }
    public Player getPreviousPlayer() { return players[(turnID - 1) % players.length]; }
    public Player getUserPlayer() { return players[0]; }
    
    public Deck getDrawPile() { return drawPile; }
    public Deck getDiscardPile() { return discardPile; }
    public Card getCurrentCard() { return null; }
}
