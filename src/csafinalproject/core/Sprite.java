package csafinalproject.core;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite extends JLabel {
    private ImageIcon icon;
    
    public Sprite(String fileName) {
        SetImage(fileName);
    }
    
    // image setter
    public void SetImage(String fileName) {
        setLayout(new BorderLayout());
        
        icon = new ImageIcon(FileUtil.loadImage(fileName));
        setIcon(icon);
    }
    
    // image getter
    public Image getImage() { 
        return icon.getImage(); 
    }
}
