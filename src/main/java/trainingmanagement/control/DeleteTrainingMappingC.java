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



    private boolean hasAllRequirements(final Training trainingToAdd, final Map<String, Training> completedTrainings) {
        return Arrays.stream(trainingToAdd.getRequirements().toArray(Training[]::new)).allMatch(requirement -> completedTrainings.containsKey(requirement.getName()));

    }

    private boolean isRequiredByOtherTrainings(final Training training, final Map<String, Training> trainings) {
        return trainings.values().stream().anyMatch(existingTraining -> existingTraining.getRequirements().contains(training));
    }

}
