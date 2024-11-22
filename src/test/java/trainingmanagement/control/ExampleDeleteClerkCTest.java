package trainingmanagement.control;

import org.junit.jupiter.api.Test;
import trainingmanagement.entity.Clerk;

import static org.junit.jupiter.api.Assertions.*;

class ExampleDeleteClerkCTest {

    private final ExampleDeleteClerkC exampleDeleteClerkC = new ExampleDeleteClerkC();

    @Test
    void deleteValidClerk() {
        final Clerk clerkToDelete = new Clerk("username", "password123$", false);
        Clerk.addClerk(clerkToDelete);
        final String result = this.exampleDeleteClerkC.deleteClerk("username");
        assertNull(result);
    }


    @Test
    void deleteNonExistentClerk() {
        final String result = this.exampleDeleteClerkC.deleteClerk("username");
        assertNotNull(result);
        assertEquals("Clerk does not exist", result);
    }

    @Test
    void deleteLastAdmin() {
        final Clerk clerkToDelete = new Clerk("username", "password123$", true);
        Clerk.addClerk(clerkToDelete);
        final String result = this.exampleDeleteClerkC.deleteClerk("username");
        assertNotNull(result);
        assertEquals("Clerk cannot be deleted", result);
    }
}