package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.ExampleMapTrainingC;

public class MapTrainingAUI extends GenericAUI<ExampleMapTrainingC> {

    public MapTrainingAUI() {
        super(ExampleMapTrainingC.class);
    }

    public void open() {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        final SelectTrainingAUI selectTrainingAUI = new SelectTrainingAUI();

        final String clerk = selectClerkAUI.selectClerk();
        final String training = selectTrainingAUI.selectTraining();
        final int choice = Input.getInteger("Enter 1 to attend training or 2 to complete training");
        final boolean isCompleted = choice == 2;
        if (isCompleted) {
            this.executeAndHandleError(() -> this.control.completeTraining(clerk, training));
        } else {
            this.executeAndHandleError(() -> this.control.attendTraining(clerk, training));
        }

    }

}
