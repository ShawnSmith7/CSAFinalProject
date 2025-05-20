package csafinalproject.core;

import java.awt.Color;
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 496;
    
    public GameWindow() {
        setTitle("Card Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setIconImage(FileUtil.loadImage("icon.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
