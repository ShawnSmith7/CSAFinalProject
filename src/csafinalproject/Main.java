package csafinalproject;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 512;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Card Game");
            window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            window.setIconImage(Toolkit.getDefaultToolkit().createImage("assets/icon.png"));
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.BLACK);
            window.setLocationRelativeTo(null);
            //window.setResizable(false);
            window.setVisible(true);
            
            Game game = new Game();
            window.add(game);
        });
    }
}
