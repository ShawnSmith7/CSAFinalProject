package csafinalproject;

import csafinalproject.core.GameSprite;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.MouseListener;
import static javax.swing.SwingConstants.CENTER;

public class Card extends GameSprite implements MouseListener {
    public enum Color { RED, GREEN, BLUE, YELLOW };
    
    private int number;
    private Color color;
    
    public Card(int number, Color color) {
        super("card-" + color.name() + ".png");
        
        this.number = number % 10;
        this.color = color;
    }
    
    public boolean compare(Card card) {
        return number == card.getNumber() || color == card.getColor();
    }
    
    public int getNumber() { return number; }
    public Color getColor() { return color; }

    public void repaint() {
        super.repaint();
        
        removeAll();
        
        JLabel symbolLabel = new JLabel(Integer.toString(this.number));
        symbolLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        symbolLabel.setForeground(java.awt.Color.BLACK);
        symbolLabel.setHorizontalAlignment(CENTER);
        add(symbolLabel, BorderLayout.CENTER);
    }
    
    public String toString() {
        return Integer.toString(number) + color.toString();
    }
    
    public void mouseClicked(MouseEvent e) {
        
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
       
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }

    public void mouseExited(MouseEvent e) {
        
    }
}
