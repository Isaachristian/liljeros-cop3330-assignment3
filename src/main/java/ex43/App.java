/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex43;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // get scanner
        Scanner input = new Scanner(System.in);

        // declare vars to get values
        String siteName, author;
        boolean js, css;

        // get input from user
        System.out.print("Site name: ");
        siteName = input.nextLine();
        System.out.print("Author: ");
        author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript (y/n)? ");
        js = input.nextLine().toLowerCase(Locale.ROOT).equals("y");
        System.out.print("Do you want a folder for CSS (y/n)? ");
        css = input.nextLine().toLowerCase(Locale.ROOT).equals("y");

        // generate website
        WebsiteBuilder.createWebsite(siteName, author, js, css);
    }
}
