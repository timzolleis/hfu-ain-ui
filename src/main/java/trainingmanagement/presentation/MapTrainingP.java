package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.ExampleMapTrainingC;

import java.util.Scanner;

public class MapTrainingP extends GenericPresentation<ExampleMapTrainingC> {

    public MapTrainingP() {
        super(ExampleMapTrainingC.class);
    }

    public void open() {
        final SelectClerkP selectClerkP = new SelectClerkP();
        final SelectTrainingP selectTrainingP = new SelectTrainingP();

        final String clerk = selectClerkP.selectClerk();
        final String training = selectTrainingP.selectTraining();
        final int choice = Input.getInteger("Enter 1 to attend training or 2 to complete training");
        final boolean isCompleted = choice == 2;
        if (isCompleted) {
            this.executeAndHandleError(() -> this.control.completeTraining(clerk, training));
        } else {
            this.executeAndHandleError(() -> this.control.attendTraining(clerk, training));
        }

    }

}
