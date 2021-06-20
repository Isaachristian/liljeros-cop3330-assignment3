/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex46;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class WordCounter {

    public static String countWords() {
        // create string builder
        StringBuilder result = new StringBuilder();

        // try to open file
        try {
            // create set of words
            Set<String> words = Files.lines(Paths.get("src/main/java/ex46/exercise46_input.txt"))
                    .flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.toSet());

            // save list of words
            List<String> allWords = Files.lines(Paths.get("src/main/java/ex46/exercise46_input.txt"))
                    .flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.toList());

            // create map for term count pairs
            Map<Integer, String> counts = new TreeMap<>();
            List<Integer> wordCounts = new LinkedList<>();

            // count occurrences
            words.forEach(word -> {
                int count = 0;
                for (String w : allWords)
                    if (word.equals(w)) count++;

                counts.put(count, word);
                wordCounts.add(count);
            });

            // print in ascending order
            wordCounts.stream().sorted(Collections.reverseOrder()).forEach(number -> {
                result.append(String.format("%-10s%s\n", counts.get(number) + ":", "*".repeat(Math.max(0, number))));
            });

        } catch (IOException e) {
            System.out.println(e);
            exit(1);
        }

        return result.toString();
    }
}
