/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex42;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class ReadData {

    public static String getFormattedData() {
        // Create string builder to create result
        StringBuilder sb = new StringBuilder();

        // open the file as a stream
        try {
            Files.lines(Paths.get("./src/main/java/ex42/exercise42_input.txt")).forEach(line -> {
                        // filter each line removing commas to create tokens
                        String[] tokens = line.split(",");
                        // format tokens as specified
                        sb.append(String.format("%-10s%-10s%-6s\n", tokens[0], tokens[1], tokens[2]));
                    });
        } catch (IOException e) {
            System.out.println("Error reading file!");
            System.out.println(e.getMessage());
            exit(1);
        }

        // return formatted string
        return sb.toString();
    }
}
