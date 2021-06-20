/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex44;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // create objects
        Scanner scanner = new Scanner(System.in);
        ProductSearch productSearch = new ProductSearch();

        // loop while valid entry not in catalog
        while (true) {
            // prompt
            System.out.print("What is the product name? ");

            // get response
            String query = scanner.nextLine();

            // query with response
            String result = productSearch.queryStock(query);

            System.out.println(result);

            // break if not default response
            if (!result.equals("Sorry, that product was not found in our inventory."))
                break;
        }
    }
}
