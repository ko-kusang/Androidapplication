import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileFormatScanner {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();
    
            try {
                File file = new File(filePath);
                scanner = new Scanner(file);
    
                System.out.println("File Content:");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + filePath);
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

