package task04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ClerkTest {

    @BeforeEach
    void setUp() {
        Clerk.allClerks = new HashMap<>();
    }

    @Test
    void testAddAndGetClerk() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        clerk.add(clerk);

        assertEquals(clerk, Clerk.getClerk("john_doe"));
    }

    @Test
    void testDeleteClerk() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        clerk.add(clerk);
        clerk.delete("john_doe");

        assertThrows(NoSuchElementException.class, () -> Clerk.getClerk("john_doe"));
    }

    @Test
    void testUsernameExists() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        clerk.add(clerk);

        assertTrue(Clerk.usernameExists("john_doe"));
        assertFalse(Clerk.usernameExists("jane_doe"));
    }

    @Test
    void testPasswordMatches() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        clerk.add(clerk);

        assertTrue(Clerk.passwordMatches("john_doe", "password123"));
        assertFalse(Clerk.passwordMatches("john_doe", "wrongpassword"));
    }

    @Test
    void testHasClerk() {
        assertFalse(Clerk.hasClerk());

        Clerk clerk = new Clerk("john_doe", "password123", true);
        clerk.add(clerk);

        assertTrue(Clerk.hasClerk());
    }

    @Test
    void testCanDelete() {
        Clerk admin1 = new Clerk("admin1", "password123", true);
        Clerk admin2 = new Clerk("admin2", "password123", true);
        Clerk user = new Clerk("user", "password123", false);

        admin1.add(admin1);
        admin1.add(admin2);
        admin1.add(user);

        assertTrue(Clerk.canDelete("user"));
        assertTrue(Clerk.canDelete("admin1"));

        admin1.delete("admin2");
        assertFalse(Clerk.canDelete("admin1"));
    }

    @Test
    void testHasAdmin() {
        assertFalse(Clerk.hasAdmin());

        Clerk admin = new Clerk("admin", "password123", true);
        admin.add(admin);

        assertTrue(Clerk.hasAdmin());
    }

    @Test
    void testAddAttendedTraining() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        Training training = new Training(null, "Java Basics");

        clerk.addAttendedTraining(training);

        assertTrue(clerk.getAttendedTrainings().containsKey("Java Basics"));
    }

    @Test
    void testAddCompletedTraining() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        Training training = new Training(null, "Java Basics");

        clerk.addAttendedTraining(training);
        clerk.addCompletedTraining(training);

        assertTrue(clerk.getCompletedTrainings().containsKey("Java Basics"));
    }

    @Test
    void testAddCompletedTrainingWithoutAttending() {
        Clerk clerk = new Clerk("john_doe", "password123", true);
        Training training = new Training(null, "Java Basics");

        assertThrows(IllegalArgumentException.class, () -> clerk.addCompletedTraining(training));
    }
}