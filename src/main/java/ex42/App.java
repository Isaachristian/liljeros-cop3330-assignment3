/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex42;

public class App {

    public static void main(String[] args) {
        //                  10--------10--------6-----
        // Print header
        System.out.println("Last      First     Salary");
        System.out.println("--------------------------");

        // Print results
        System.out.println(ReadData.getFormattedData());
    }
}
