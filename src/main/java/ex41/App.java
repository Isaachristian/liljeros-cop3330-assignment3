/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex41;

import static ex41.ScanPeople.*;

public class App {

    public static void main(String[] args) {
        // Write sorted list of people to file
        writeToFile(getSortedFileContents());
    }
}
