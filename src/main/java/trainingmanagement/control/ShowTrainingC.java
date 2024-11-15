package trainingmanagement.control;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

public class ShowTrainingC {

    String[] showAttendedTrainings(final String clerkName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        return clerk.getAttendedTrainings().values().stream()
                .map(Training::getName)
                .toArray(String[]::new);
    }

    String[] showCompletedTrainings(final String clerkName) {
        final Clerk clerk = Clerk.getClerk(clerkName);
        return clerk.getCompletedTrainings().values().stream()
                .map(Training::getName)
                .toArray(String[]::new);
    }

}
