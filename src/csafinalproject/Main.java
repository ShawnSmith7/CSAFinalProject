package csafinalproject;

import csafinalproject.core.FileUtil;
import java.awt.Color;
import javax.swing.JFrame;

public class Main extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 496;
    
    public static void main(String[] args) {
        JFrame window = new JFrame("CardGame");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setIconImage(FileUtil.loadImage("icon.png"));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        
        // Start game here
        // testing
    }
}
