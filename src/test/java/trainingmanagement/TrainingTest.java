package trainingmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trainingmanagement.entity.Training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    @BeforeEach
    void setUp() {
        Training.setAllTrainings(new HashMap<>());
    }

    @Test
    void testAddAndGetTraining() {
        Training training = new Training(new HashSet<>(), "Java Basics");
        training.add(training);

        assertEquals(training, Training.getTraining("Java Basics"));
    }

    @Test
    void testDeleteTraining() {
        Training training = new Training(new HashSet<>(), "Java Basics");
        training.add(training);
        training.delete("Java Basics");

        assertThrows(NoSuchElementException.class, () -> Training.getTraining("Java Basics"));
    }

    @Test
    void testGetAllNames() {
        Training training1 = new Training(new HashSet<>(), "Java Basics");
        Training training2 = new Training(new HashSet<>(), "Advanced Java");
        training1.add(training1);
        training1.add(training2);

        String[] expectedNames = {"Java Basics", "Advanced Java"};
        assertArrayEquals(expectedNames, Training.getAllNames());
    }

    @Test
    void testAddTrainingWithRequirements() {
        Training requirement = new Training(new HashSet<>(), "Java Basics");
        requirement.add(requirement);

        Set<Training> requirements = new HashSet<>();
        requirements.add(requirement);

        Training training = new Training(requirements, "Advanced Java");
        training.add(training);

        assertEquals(requirements, training.getRequirements());
    }
}