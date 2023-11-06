import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageDisplay {
    public static void main(String[] args) {
        // Input the file name which is in your own file
        File file = new File("horizon.png");
        BufferedImage img = null;

        try {
            // Try to read the image file
            img = ImageIO.read(file);
        } catch (IOException e) {
            // Handle any IOException (e.g., file not found)
            e.printStackTrace(System.out);
        }
        
        if (img != null) {
            // If the image was successfully loaded, display it
            display(img);
        }
    }

    private static void display(BufferedImage img) {
        System.out.println("Displaying image.");

        // Create a new JFrame for displaying the image
        JFrame frame = new JFrame();
        
        // Create a JLabel to hold the image
        JLabel label = new JLabel();
        
        // Set the frame size to match the image dimensions
        frame.setSize(img.getWidth(), img.getHeight());
        
        // Set the image as an icon for the label
        label.setIcon(new ImageIcon(img));
        
        // Add the label to the center of the frame's content pane
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Pack the frame to ensure proper sizing
        frame.pack();
        
        // Make the frame visible, displaying the image
        frame.setVisible(true);
    }

}