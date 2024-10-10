package task02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void input() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        final String inputHint = "Enter something:";
        final String expected = "Hello, World!";

        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        final String result = Input.input(inputHint);
        assertEquals(expected, result);
        assertEquals(inputHint + System.lineSeparator(), outContent.toString());
    }
}