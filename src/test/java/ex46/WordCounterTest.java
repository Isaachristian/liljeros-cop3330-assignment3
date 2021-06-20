/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex46;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void testCountWords() {
        String expected =
                "badger:   *******\n" +
                "mushroom: **\n" +
                "snake:    *\n";

        assertEquals(expected, WordCounter.countWords());
    }
}