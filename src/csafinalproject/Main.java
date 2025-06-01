package csafinalproject;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // create window and game
            JFrame window = new JFrame("Card Game");
            window.setSize(800, 512);
            window.setIconImage(Toolkit.getDefaultToolkit().createImage("assets/icon.png"));
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.BLACK);
            window.setLocationRelativeTo(null);
            window.setResizable(false);
            window.setVisible(true);
            
            Game game = new Game();
            window.add(game);
        });
    }
}
