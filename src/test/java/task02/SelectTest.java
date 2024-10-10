package task02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void select_validOption() {
        final String[] options = {"Option 1", "Option 2", "Option 3"};
        final String expectedOutput = "1. Option 1\n2. Option 2\n3. Option 3\nPlease select an option by providing a number:\n";
        final String expectedSelection = "Option 1";

        final ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
        String result = Select.select(options);

        assertEquals(expectedOutput, outContent.toString());
        assertEquals(expectedSelection, result);
    }

}