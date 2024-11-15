package trainingmanagement.control;


import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

class ExampleMapTrainingC {

    void attendTraining(final String clerkName, final String trainingName) {
        final Training training = Training.getTraining(trainingName);
        final Clerk clerk = Clerk.getClerk(clerkName);
        clerk.addAttendedTraining(training);
    }

    void completeTraining(final String clerkName, final String trainingName) {
        final Training training = Training.getTraining(trainingName);
        final Clerk clerk = Clerk.getClerk(clerkName);
        clerk.addCompletedTraining(training);
    }


}
