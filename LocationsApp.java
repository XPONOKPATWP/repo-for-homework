package gr.aueb.cf.ch9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LocationsApp {

    public static void main(String[] args) {
        String inputFile = "C:/Users/gfkst/IdeaProjects/Idea1023/locations.txt";
        String outputFile = "C:/Users/gfkst/IdeaProjects/Idea1023/locationsCopy.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // To maintain the format
                count++;
            }

            System.out.printf("Το αρχείο με %d γραμμές αντιγράφηκε", count);

        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την ανάγνωση/εγγραφή του αρχείου: " + e.getMessage());
        }
    }
}
