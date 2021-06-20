/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex44;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

import static java.lang.System.exit;

public class ProductSearch {
    // -ProductList productList
    private ProductList productList = new ProductList();

    // -void populateProductListFromJson()
    private void populateProductListFromJson() {
        Gson gson = new Gson();

        // get file contents as string
        String json = getFileContentsAsString();

        // Parse json and set product list equal to results
        productList = gson.fromJson(json, ProductList.class);
    }

    // -String getFileContentsAsString()
    private String getFileContentsAsString() {
        // Create string builder
        StringBuilder contents = new StringBuilder();

        // Try to open file
        try {
            // add lines to string builder
            Files.lines(Paths.get("./src/main/java/ex44/exercise44_input.json")).map(String::trim).forEach(contents::append);
        } catch (IOException e) {
            System.out.println("Failed to open file!");
            exit(1);
        }

        // return string builder as string
        return contents.toString();
    }


    // +String queryStock(String query)
    public String queryStock(String query) {
        // create default result
        StringBuilder response = new StringBuilder("Sorry, that product was not found in our inventory.");

        // populate product list (if not populated)
        populateProductListFromJson();

        // search for query
        Optional<Product> productMatch = Arrays.stream(productList.products)
                .filter(product -> product.name.toLowerCase(Locale.ROOT).equals(query.toLowerCase(Locale.ROOT))).findFirst();

        // build return string if result is found
        productMatch.ifPresent(result -> {
            // reset string
            response.setLength(0);

            // create new response
            response.append(String.format("Name: %s\nPrice: %.2f\nQuantity: %d",
                    result.name, result.price, result.quantity));
        });

        return response.toString();
    }


}
