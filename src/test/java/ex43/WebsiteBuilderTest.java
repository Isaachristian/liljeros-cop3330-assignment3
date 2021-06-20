/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Isaac Liljeros
 */

package ex43;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class WebsiteBuilderTest {

    void deleteWebsiteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteWebsiteDir(f);
            }
        }
        file.delete();
    }

    @BeforeAll
    static void confirmNoWebsiteFolder() {
        if (Files.exists(Paths.get("./website"))) {
            WebsiteBuilderTest wbt = new WebsiteBuilderTest();
            wbt.deleteWebsiteDir(new File("./website"));
        }
    }

    @Test
    void createWebsite() {
        String expectedIndexHtmlContents = "<head>\t<meta name=\"author\" content=\"Isaac\">\t<title>title</title></head>";
        WebsiteBuilder.createWebsite("title", "Isaac", true, true);

        assertTrue(Files.exists(Paths.get("./website")));
        assertTrue(Files.exists(Paths.get("./website/title")));
        assertTrue(Files.exists(Paths.get("./website/title/js")));
        assertTrue(Files.exists(Paths.get("./website/title/css")));
        assertTrue(Files.exists(Paths.get("./website/title/index.html")));

        assertDoesNotThrow(() -> {
            StringBuilder contents = new StringBuilder();
            Files.lines(Paths.get("./website/title/index.html")).forEach(contents::append);
            assertEquals(expectedIndexHtmlContents, contents.toString());
        });
    }

    @AfterAll
    static void cleanUp() {
        confirmNoWebsiteFolder();
    }
}