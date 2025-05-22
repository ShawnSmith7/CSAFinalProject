package csafinalproject.core;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameSprite extends JLabel {
    private ImageIcon icon;
    
    public GameSprite(String fileName) {
        setLayout(new BorderLayout());
        setHorizontalAlignment(CENTER);
        
        SetImage(fileName);
    }
    
    // image setter
    public void SetImage(String fileName) {
        icon = new ImageIcon(FileUtil.loadImage(fileName));
        setIcon(icon);
    }
    
    // image getter
    public Image getImage() { 
        return icon.getImage(); 
    }
}
