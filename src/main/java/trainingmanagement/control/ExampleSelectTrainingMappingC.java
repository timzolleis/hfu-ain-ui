package trainingmanagement.control;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class ExampleSelectTrainingMappingC {
    final String[] getCompletedTrainingNames(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        return this.convertToString(clerk.getCompletedTrainings());
    }

    final String[] getAttendedTrainingNames(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        return this.convertToString(clerk.getAttendedTrainings());
    }

    private String[] convertToString(final Map<String, Training> trainings) {
        return trainings.values().stream()
                .map(Training::getName)
                .toArray(String[]::new);
    }


}