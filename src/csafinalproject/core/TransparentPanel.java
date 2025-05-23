package csafinalproject.core;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TransparentPanel extends JPanel {
    public TransparentPanel() {
        super();
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBackground(new java.awt.Color(0,0,0,0));
    }
}
