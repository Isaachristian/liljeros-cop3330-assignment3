/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex45;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        InputFilter.writeResultsToFile(new Scanner(System.in).nextLine(), InputFilter.filterFileContents());
    }
}
