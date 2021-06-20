/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductSearchTest {
    ProductSearch ps = new ProductSearch();

    @Test
    void queryStockValid() {
        String expected =
                "Name: Thing\n" +
                "Price: 15.00\n" +
                "Quantity: 5";

        String actual = ps.queryStock("thing");
        assertEquals(expected, actual);

        String actual2 = ps.queryStock("ThiNg");
        assertEquals(expected, actual2);

        String actual3 = ps.queryStock("THING");
        assertEquals(expected, actual3);
    }

    @Test
    void queryStockInvalid() {
        assertEquals("Sorry, that product was not found in our inventory.", ps.queryStock("bob"));
        assertEquals("Sorry, that product was not found in our inventory.", ps.queryStock(""));
        assertEquals("Sorry, that product was not found in our inventory.", ps.queryStock("none"));
    }
}