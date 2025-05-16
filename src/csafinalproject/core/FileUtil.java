package csafinalproject.core;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileUtil {
    
    // Loads an image from a file name
    public static Image loadImage(String filename) {
        try {
            File file = new File("assets/" + filename);
            Image img = ImageIO.read(file);
            return img;
        }
        catch(IOException exception) { 
            System.out.println("Error loading image: \"assets/" + filename + "\"");
            return null; 
        }
    }
}
