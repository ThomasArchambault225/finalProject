import org.example.Song;

import java.util.Scanner;
import java.io.*;

/**
 This program creates a list of songs for a CD
 by reading from a file.
 */
public class CompactDisc {
    public static void main(String[] args) throws IOException {
        // Open the file
        Scanner input = new Scanner(new File("src/Classics.txt"));


        // Declare an array of Song objects
        Song[] cd = new Song[6];

        // Read the file and populate the array
        for (int i = 0; i < cd.length; i++) {
            String title = input.nextLine();
            String artist = input.nextLine();
            cd[i] = new Song(title, artist); // Create a new Song object and store it in the array
        }

        // Display the contents of the CD
        System.out.println("Contents of Classics:");
        for (Song song : cd) {
            System.out.print(song); // Print each song
        }

        // Close the file
        input.close();
    }
}
