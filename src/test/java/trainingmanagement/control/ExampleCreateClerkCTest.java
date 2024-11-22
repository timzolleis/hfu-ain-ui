package trainingmanagement.control;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleCreateClerkCTest {

    private final ExampleCreateClerkC exampleCreateClerkC = new ExampleCreateClerkC();

    @Test
    void addValidClerk() {
        final String result = this.exampleCreateClerkC.addClerk("username", "password123$", false);
        assertNull(result);
    }

    @Test
    void addInvalidClerk() {
        final String result = this.exampleCreateClerkC.addClerk("username", "password", false);
        assertNotNull(result);
        assertEquals("Password does not match criteria", result);
    }
}