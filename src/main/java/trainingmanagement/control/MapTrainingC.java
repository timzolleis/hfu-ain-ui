package trainingmanagement.control;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

public class MapTrainingC {

    void attendTraining(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        //Check requirements for training
        if (training.getRequirements().stream().allMatch(requirement -> clerk.getCompletedTrainings().containsKey(requirement.getName()))) {
            throw new IllegalArgumentException("Clerk has not completed required training");
        }
        if (clerk.getAttendedTrainings().containsKey(trainingName)) {
            throw new IllegalArgumentException("Clerk already attended training");
        }
        clerk.addAttendedTraining(training);
    }

    void completeTraining(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        if (!clerk.getAttendedTrainings().containsKey(trainingName)) {
            throw new IllegalArgumentException("Clerk has not attended training");
        }
        if (clerk.getCompletedTrainings().containsKey(trainingName)) {
            throw new IllegalArgumentException("Clerk already completed training");
        }
        clerk.addCompletedTraining(training);
    }
}
