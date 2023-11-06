import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImageColorChange {
    public static void main(String[] args) {
        // Input the file name which is in your own file
        File file = new File("horizon.png");
        BufferedImage img = null;

        try {
            // Try to read the image file
            img = ImageIO.read(file);
        } catch (IOException e) {e.printStackTrace(System.out);}
            // Handle any IOException (e.g., file not found)
            
        
        
        if (img != null) {
            // If the image was successfully loaded, display it
            display(img);
            img = colorinImage(img);
            display(img);
        }
    }

   
    






    private static BufferedImage toGrayScale(BufferedImage img) {
        System.out.println("converting to GrayScale");
        BufferedImage grayImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = grayImage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return grayImage;
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

    



    private static BufferedImage colorinImage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage colorinImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = img.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = ((rgb >> 8) & 0xFF) + 30 ;
                int blue = rgb & 0xFF;

                int invertred = 255-red;
                int invertgreen = 255-green;
                int invertblue = 255-blue;

        
    
                // Create a new color with only the green channel
                int newRgb = (invertred << 16) | ((invertgreen) << 8) | invertblue;
    
                colorinImage.setRGB(x, y, newRgb);
            }
        }
    
        return colorinImage;
    }
}


