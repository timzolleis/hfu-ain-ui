package trainingmanagement.control;

import java.util.Collection;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

public class ExampleDeleteTrainingMappingC {


    private String checkCanDeleteTrainingMapping(final Clerk Clerk, final Training trainingToDelete) {
        final Collection<Training> completedTrainings = Clerk.getCompletedTrainings().values();
        final Training requiredBy = completedTrainings.stream()
                .filter(trainingToDelete::isRequiredBy)
                .findFirst()
                .orElse(null);
        if (requiredBy != null) {
            return "The training " + trainingToDelete.getName() + " is required by the completed training " + requiredBy.getName() + ". \nIt cannot be deleted for the clerk " + Clerk.getUsername();
        }
        return null;
    }

    public final String deleteTrainingMapping(final String clerkName, final String trainingName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        final Training training = Training.getTraining(trainingName);
        if (clerk.hasAttendedTraining(training)) {
            clerk.removeAttendedTraining(training);
            return null;
        }
        final String error = this.checkCanDeleteTrainingMapping(clerk, training);
        if (error == null) {
            clerk.removeCompletedTraining(training);
            return null;
        }
        return error;


    }

    public final String[] getAttendedTrainings(final String selectedUsername) {
        return new ExampleShowTrainingMappingC().getAttendedTrainingNames(selectedUsername);
    }

    public final String[] getCompletedTrainings(final String selectedUsername) {
        return new ExampleShowTrainingMappingC().getCompletedTrainingNames(selectedUsername);
    }

}
