package csafinalproject;

import csafinalproject.core.GameSprite;
import java.awt.*;
import javax.swing.*;

public class Card extends GameSprite {
    public enum Color { RED, GREEN, BLUE, YELLOW };
    
    private int number;
    private Color color;
    
    public Card(int number, Color color) {
        super("card-" + color.name() + ".png");
        
        this.number = number % 10;
        this.color = color;
        
        JLabel symbolLabel = new JLabel(Integer.toString(this.number));
        symbolLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        symbolLabel.setForeground(java.awt.Color.BLACK);
        symbolLabel.setHorizontalAlignment(CENTER);
        add(symbolLabel, BorderLayout.CENTER);
    }
    
    public int getNumber() { return number; }
    public Color getColor() { return color; }
    
    public boolean compare(Card card) {
        return number == card.getNumber() || color == card.getColor();
    }
    
    public String toString() {
        return Integer.toString(number) + color.toString();
    }
}
