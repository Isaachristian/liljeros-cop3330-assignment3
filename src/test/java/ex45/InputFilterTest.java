/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex45;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class InputFilterTest {
    private final String expected =
            "One should never use the word \"use\" in writing. Use \"use\" instead. \n" +
            "For example, \"She uses an IDE to write her Java programs\" instead of \"She \n" +
            "uses an IDE to write her Java programs\". \n";

    @Test
    void filterFileContentes() {
        assertEquals(expected, InputFilter.filterFileContents());
    }

    @Test
    void writeResultsToFile() {
        InputFilter.writeResultsToFile("testFile", InputFilter.filterFileContents());

        assertTrue(Files.exists(Paths.get("./testFile")));

        StringBuilder actual = new StringBuilder();
        assertDoesNotThrow(() -> {
            Files.lines(Paths.get("./testFile")).forEach(line -> {
                actual.append(String.format("%s\n", line));
            });
        });

        assertEquals(expected, actual.toString());
    }

    @AfterAll
    static void cleanUp() {
        try {
            Files.delete(Paths.get("./testFile"));
        } catch (IOException e) {
            System.out.println("Cleanup failed to remove test files!!");
        }
    }
}