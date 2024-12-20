package trainingmanagement.presentation;

import trainingmanagement.control.ExampleDeleteTrainingMappingC;

public class DeleteTrainingMappingAUI extends GenericAUI<ExampleDeleteTrainingMappingC> {

    public DeleteTrainingMappingAUI() {
        super(ExampleDeleteTrainingMappingC.class);
    }

    public void open() {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        final SelectTrainingAUI selectTrainingAUI = new SelectTrainingAUI();
        final String clerk = selectClerkAUI.selectClerk();
        final String training = selectTrainingAUI.selectTraining();
        this.executeAndHandleError(() -> this.control.deleteTrainingMapping(clerk, training));
    }

}
