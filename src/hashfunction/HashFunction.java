/*
Noah Baldwin
Project 3 HASH FUNCTION
6/17/18
 */
package hashfunction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class HashFunction {

    private static final MessageDigest digest = null; 
    static private String password;

    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException, IOException {

        File file = null;
        JFileChooser chooser = new JFileChooser(); // File chooser allows user to pick file
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null, "No file selected");
            System.exit(1);
        }

        BufferedReader test = new BufferedReader(new FileReader(file));
        String s = test.readLine(); // Reads file in as string
        
        System.out.println("Calculating SHA-256 Value...");

        password = s;

        MessageDigest md = MessageDigest.getInstance("SHA-256"); // Hash string with SHA-256
        md.update(password.getBytes()); //Convert string to bytes

        byte byteData[] = md.digest(); //create array of bytes

       
        StringBuilder hash = new StringBuilder(); 
        for (int i = 0; i < byteData.length; i++) { 
            hash.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1)); //convert the byte to hex format
        }

        System.out.println("Hex encoded value: " + hash.toString()); // Print Hex format

    }

}
