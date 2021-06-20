/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadDataTest {

    @Test
    void testGetFormattedData() {
        String expected =
                "Ling      Mai       55900 \n" +
                "Johnson   Jim       56500 \n" +
                "Jones     Aaron     46000 \n" +
                "Jones     Chris     34500 \n" +
                "Swift     Geoffrey  14200 \n" +
                "Xiong     Fong      65000 \n" +
                "Zarnecki  Sabrina   51500 \n";

        assertEquals(expected, ReadData.getFormattedData());
    }
}