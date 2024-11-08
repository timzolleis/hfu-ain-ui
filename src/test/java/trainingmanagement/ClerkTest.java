package trainingmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trainingmanagement.entity.Clerk;
import trainingmanagement.exception.ClerkNotDeletableException;
import trainingmanagement.exception.ClerkNotFoundException;
import trainingmanagement.exception.InvalidPasswordException;
import trainingmanagement.exception.InvalidUsernameException;

import static org.junit.jupiter.api.Assertions.*;

class ClerkTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testAddClerk() {
        Clerk validClerk = new Clerk("john_doe", "Password1%", true);
        Clerk.addClerk(validClerk);
        assertEquals(validClerk, Clerk.getClerk("john_doe"));

        Clerk invalidPassword = new Clerk("john_doe", "password123", true);
        assertThrows(IllegalArgumentException.class, () -> Clerk.addClerk(invalidPassword));

        Clerk existingClerk = new Clerk("john_doe", "Password1%", true);
        assertThrows(IllegalArgumentException.class, () -> Clerk.addClerk(existingClerk));
    }

    @Test
    void testDeleteClerk() {
        final Clerk firstAdmin = new Clerk("john_doe", "Password1%", true);
        Clerk.addClerk(firstAdmin);
        assertThrows(ClerkNotDeletableException.class, firstAdmin::delete);
        final Clerk secondAdmin = new Clerk("jane_doe", "Password1%", true);
        Clerk.addClerk(secondAdmin);
        firstAdmin.delete();
        assertThrows(ClerkNotFoundException.class, () -> Clerk.getClerk("john_doe"));
    }

    @Test
    void testSetUsername() {
        final Clerk clerk = new Clerk("john_doe", "Password1%", true);
        Clerk.addClerk(clerk);
        clerk.setUsername("jane_doe");
        assertEquals(clerk, Clerk.getClerk("jane_doe"));
        assertThrows(InvalidUsernameException.class, () -> clerk.setUsername("jane_doe"));
    }

    @Test
    void testSetPassword() {
        final Clerk clerk = new Clerk("john_doe", "Password1%", true);
        Clerk.addClerk(clerk);
        clerk.setPassword("Password2%");
        assertEquals(clerk, Clerk.getClerk("john_doe"));
        assertThrows(InvalidPasswordException.class, () -> clerk.setPassword("password123"));
    }

    @Test
    void testSetRole() {
        final Clerk clerk = new Clerk("john_doe", "Password1%", true);
        Clerk.addClerk(clerk);
        assertThrows(IllegalArgumentException.class, () -> clerk.setRole(false));
        final Clerk secondAdmin = new Clerk("jane_doe", "Password1%", true);
        Clerk.addClerk(secondAdmin);
        clerk.setRole(false);
        assertFalse(clerk.isAdmin());
    }


}