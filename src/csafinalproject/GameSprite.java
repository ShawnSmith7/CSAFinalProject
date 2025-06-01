package csafinalproject;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameSprite extends JLabel {
    private ImageIcon icon;
    
    // takes in a filename
    public GameSprite(String fileName) {
        setLayout(new BorderLayout());
        setHorizontalAlignment(CENTER);
        
        SetImage(fileName);
    }
    
    // sets this sprite's image
    public void SetImage(String fileName) {
        icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/" + fileName));
        setIcon(icon);
    }
    
    // image getter
    public Image getImage() { 
        return icon.getImage(); 
    }
}
