package ex45;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class InputFilterTest {
    private final String expected =
            "One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                    "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                    "uses an IDE to write her Java programs\".";

    @Test
    void filterFileContentes() {
        assertEquals(expected, InputFilter.filterFileContentes());
    }

    @Test
    void writeResultsToFile() {
        InputFilter.writeResultsToFile("testFile", InputFilter.filterFileContentes());

        assertTrue(Files.exists(Paths.get("./testFile")));
    }
}