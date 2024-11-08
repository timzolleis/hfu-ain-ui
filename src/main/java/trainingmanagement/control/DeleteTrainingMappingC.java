package trainingmanagement.control;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

import java.util.Arrays;
import java.util.Map;

public class DeleteTrainingMappingC {
    void removeAttendedTraining(final Clerk clerk, final String trainingName) {
        final Training training = clerk.getAttendedTrainings().get(trainingName);
        if (training == null) {
            throw new IllegalArgumentException("Clerk has not attended training " + trainingName);
        }
        clerk.removeAttendedTraining(training);
    }

    void removeCompletedTrainings(final Clerk clerk, final String trainingName) {
        final Training training = clerk.getCompletedTrainings().get(trainingName);
        if (training == null) {
            throw new IllegalArgumentException("Clerk has not completed training " + trainingName);
        }
        // Check that the training is not a requirement by other trainings
        final Boolean requiredByAttendedTraining = isRequiredByOtherTrainings(training, clerk.getAttendedTrainings());
        final Boolean requiredByCompletedTraining = isRequiredByOtherTrainings(training, clerk.getCompletedTrainings());
        if (requiredByAttendedTraining || requiredByCompletedTraining) {
            throw new IllegalArgumentException("Training " + trainingName + " is required by other trainings");
        }
        clerk.removeCompletedTraining(training);
    }

    void addAttendedTraining(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        //Check that the training is not attended or completed yet
        final boolean hasAttended = clerk.getAttendedTrainings().containsKey(trainingName);
        final boolean hasCompleted = clerk.getCompletedTrainings().containsKey(trainingName);
        if (hasAttended || hasCompleted) {
            throw new IllegalArgumentException("Clerk has already attended or completed training " + trainingName);
        }
        //Check that the training has all requirements
        final boolean hasAllRequirements = hasAllRequirements(training, clerk.getCompletedTrainings());
        if (!hasAllRequirements) {
            throw new IllegalArgumentException("Clerk has not completed all requirements for training " + trainingName);
        }
        clerk.addAttendedTraining(training);
    }

    void addCompletedTraining(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        final boolean hasAttended = clerk.getAttendedTrainings().containsKey(trainingName);
        if (!hasAttended) {
            throw new IllegalArgumentException("Clerk has not attended training " + trainingName);
        }
        clerk.addCompletedTraining(training);
    }

    private boolean hasAllRequirements(final Training trainingToAdd, final Map<String, Training> completedTrainings) {
        return Arrays.stream(trainingToAdd.getRequirements().toArray(Training[]::new)).allMatch(requirement -> completedTrainings.containsKey(requirement.getName()));

    }

    private boolean isRequiredByOtherTrainings(final Training training, final Map<String, Training> trainings) {
        return trainings.values().stream().anyMatch(existingTraining -> existingTraining.getRequirements().contains(training));
    }

}
