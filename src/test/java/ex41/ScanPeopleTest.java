/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex41;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static ex41.ScanPeople.*;

import static org.junit.jupiter.api.Assertions.*;

class ScanPeopleTest {
    public static final String expected =
            "Johnson, Jim\n" +
            "Jones, Aaron\n" +
            "Jones, Chris\n" +
            "Ling, Mai\n" +
            "Swift, Geoffrey\n" +
            "Xiong, Fong\n" +
            "Zarnecki, Sabrina\n";

    @Test
    void testGetSortedFileContents() {
        assertEquals(expected, getSortedFileContents());
    }

    @Test
    void testWriteToFile() {
        StringBuilder fileContent = new StringBuilder();
        writeToFile(getSortedFileContents());

        assertDoesNotThrow(() -> {
            Files.lines(Paths.get("./exercise41_output.txt"))
                    .forEach(line -> {
                        fileContent.append(String.format("%s\n", line));
                    });

        });

        assertEquals("Total of 7 names\n-----------------\n" + expected, fileContent.toString());
    }
}