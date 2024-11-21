package trainingmanagement.presentation;

import trainingmanagement.control.ExampleDeleteTrainingMappingC;

public class DeleteTrainingMappingP extends GenericPresentation<ExampleDeleteTrainingMappingC> {

    public DeleteTrainingMappingP() {
        super(ExampleDeleteTrainingMappingC.class);
    }

    public void open() {
        final SelectClerkP selectClerkP = new SelectClerkP();
        final SelectTrainingP selectTrainingP = new SelectTrainingP();
        final String clerk = selectClerkP.selectClerk();
        final String training = selectTrainingP.selectTraining();
        this.executeAndHandleError(() -> this.control.deleteTrainingMapping(clerk, training));
    }

}
