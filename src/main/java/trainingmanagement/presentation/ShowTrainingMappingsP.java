package trainingmanagement.presentation;

import trainingmanagement.control.ExampleShowTrainingMappingC;

public class ShowTrainingMappingsP extends GenericPresentation<ExampleShowTrainingMappingC> {

    public ShowTrainingMappingsP() {
        super(ExampleShowTrainingMappingC.class);
    }

    public void open() {
        final SelectClerkP selectClerkP = new SelectClerkP();
        final String clerk = selectClerkP.selectClerk();
        try {
            final String[] completedTrainingNames = control.getCompletedTrainingNames(clerk);
            final String[] attendedTrainingNames = control.getAttendedTrainingNames(clerk);
            System.out.println("Completed training:");
            for (final String trainingName : completedTrainingNames) {
                System.out.println(trainingName);
            }
            System.out.println("Attended training:");
            for (final String trainingName : attendedTrainingNames) {
                System.out.println(trainingName);
            }
        } catch (Exception e) {
            System.out.println("Failed to show training mappings: " + e.getMessage());
        }
    }

}
