package trainingmanagement.control;

class ExampleShowTrainingMappingC {

    final String[] getCompletedTrainingNames(final String username) {
        return new ExampleSelectTrainingMappingC().getCompletedTrainingNames(username);
    }

    final String[] getAttendedTrainingNames(final String username) {
        return new ExampleSelectTrainingMappingC().getAttendedTrainingNames(username);
    }

}
