package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Card extends GameSprite implements MouseListener {
    private int rank;
    
    public Card(int rank) {
        // set sprite to card image
        super("Card.png");
        
        this.rank = rank;
        
        // add two labels to the bottom left and top right of the card
        JLabel[] nums = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            nums[i] = new JLabel(Integer.toString(rank));
            nums[i].setFont(new Font("Comic Sans MS", Font.BOLD, 28));
            nums[i].setForeground(rank % 2 == 0 ? Color.BLACK : Color.RED);
            
            nums[i].setVerticalAlignment(i == 0 ? TOP : BOTTOM);
            add(nums[i], i == 0 ? BorderLayout.EAST : BorderLayout.WEST);
        }
        
        // listen for mouse events
        addMouseListener(this);
    }
    
    // listens for when this card is clicked
    public void mouseClicked(MouseEvent e) {
        Container parent = getParent().getParent();
        if (parent instanceof User) ((User)parent).cardClicked(this);
    }
    
    // rank getter
    public int getRank() { return rank; }
    
    // unused mouse listener methods
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}
