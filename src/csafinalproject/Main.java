package csafinalproject;

import csafinalproject.core.GameWindow;
import javax.swing.SwingUtilities;

public class Main extends GameWindow {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { 
            new GameWindow(); 
        });
    }
}
