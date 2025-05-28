package csafinalproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Card extends GameSprite implements MouseListener {
    private int rank;
    
    public Card(int rank) {
        super("Card.png");
        
        JLabel[] nums = new JLabel[2];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new JLabel(Integer.toString(rank));
            nums[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
            nums[i].setForeground(rank % 2 == 0 ? Color.BLACK : Color.RED);
            
            nums[i].setVerticalAlignment(i == 0 ? TOP : BOTTOM);
            add(nums[i], i == 0 ? BorderLayout.EAST : BorderLayout.WEST);
        }
        
        addMouseListener(this);
        
        this.rank = rank;
    }
    
    public int getRank() {
        return rank;
    }
    
    public String toString() {
        return Integer.toString(rank);
    }
    
    public void mouseClicked(MouseEvent e) {
        Container parent = getParent().getParent();
        if (parent instanceof User)
            ((User)parent).cardClicked(this);
    }

    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}
