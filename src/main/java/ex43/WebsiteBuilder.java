/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex43;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WebsiteBuilder {
//    {static} +void createWebsite(String siteName, String author, boolean CSS, boolean JS)
    public static void createWebsite(String siteName, String author, boolean css, boolean js) {
        // Try all code with catch
        try {
            // Create path variable for reuse
            String websitePath = "./website/" + siteName;

            // Create working directory ./website/[siteName]
            Files.createDirectory(Paths.get("./website"));
            Files.createDirectory(Paths.get(websitePath));
            System.out.println("Created ./website/" + siteName);

            // Create index.html
            Files.createFile(Paths.get(websitePath + "/index.html"));
            System.out.println("Created ./website/" + siteName + "/index.html");

            // Create js folder ?
            if (js) {
                Files.createDirectory(Paths.get(websitePath + "/js"));
                System.out.println("Created ./website/" + siteName + "/js/");
            }


            // Create css folder ?
            if (css) {
                Files.createDirectory(Paths.get(websitePath + "/css"));
                System.out.println("Created ./website/" + siteName + "/css/");
            }

            // Call createWebsiteContents and add to
            addWebsiteContents(siteName, author);
        } catch (IOException e) {
            System.out.println("Failed with following exception: ");
            System.out.println(e);
        }
    }

//    {static} -void addWebsiteContents(String siteName, String author)
    private static void addWebsiteContents(String siteName, String author) throws IOException {
        // open index.html
        FileWriter fw = new FileWriter("./website/" + siteName + "/index.html");

        // write content to file
        fw.write("<head>\n\t<meta name=\"author\" content=\"" + author + "\">\n\t<title>" + siteName + "</title>\n</head>");

        // close
        fw.close();

    }

}
