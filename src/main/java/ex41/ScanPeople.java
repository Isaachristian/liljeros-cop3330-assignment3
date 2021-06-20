/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class ScanPeople {

    // Create new file
    private static void createFile() {
        // Try to make file
        try {
            File newFile = new File("exercise41_output.txt");
            if (!newFile.createNewFile()) {
                // if the file already exists, remove it and try again
                System.out.println("File already exists!");
                if (newFile.delete()) createFile();
            };
        // Catch error
        } catch (IOException e) {
            System.out.println(e.getMessage());
            exit(1);
        }
    }

    public static String getSortedFileContents() {
        // create list
        List<String> sortedNames = new LinkedList<>();

        // take in file contents as a stream and sort them into the list
        try {
            sortedNames = Files.lines(Paths.get("./src/main/java/ex41/exercise41_input.txt"))
                    .sorted(String::compareToIgnoreCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Cannot open file!");
            exit(1);
        }

        // assemble string
        StringBuilder result = new StringBuilder();
        sortedNames.forEach(line -> result.append(String.format("%s\n", line)));

        // return the sorted list
        return result.toString();
    }


    public static void writeToFile(String results) {
        // Place everything inside try block
        try {
            createFile();

            // Open the file for writing
            FileWriter fw = new FileWriter("exercise41_output.txt");

            // Append the header
            fw.append("Total of 7 names\n-----------------\n");

            // Append the results
            fw.append(results);

            // Close
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            exit(1);
        }
    }
}
