/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex45;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class InputFilter {
    // {static} +String filterFileContents()
    public static String filterFileContents() {
        // Create a string builder to populate
        StringBuilder filteredContents = new StringBuilder();

        // create a file stream and get lines
        try {
            // tokenize lines
            Files.lines(Paths.get("src/main/java/ex45/exercise45_input.txt")).forEach(line -> {
                // search and replace keywords
                for (String word : line.split(" ")) {
                    if (word.equals("\"utilize\""))
                        filteredContents.append("\"use\" ");
                    else if (word.equals("utilize"))
                        filteredContents.append("use ");
                    else if (word.equals("utilizes"))
                        filteredContents.append("uses ");
                    else
                        filteredContents.append(word).append(" ");
                }
                filteredContents.append("\n");
            });
        } catch (IOException e) {
            System.out.println(e);
            exit(1);
        }

        // return as string
        return filteredContents.toString();
    }

    // {static} +void writeResultsToFile(String fileName, String contents)
    public static void writeResultsToFile(String fileName, String contents) {
        // try to create file
        try {
            // create the file
            Files.createFile(Paths.get("./" + fileName));

            // open the file
            FileWriter fw = new FileWriter("./" + fileName);

            // write contents to file
            fw.write(contents);

            // close file
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
            exit(1);
        }
    }
}
