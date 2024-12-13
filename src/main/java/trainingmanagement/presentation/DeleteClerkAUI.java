package trainingmanagement.presentation;

import trainingmanagement.control.ExampleDeleteClerkC;

import javax.swing.*;

public class DeleteClerkAUI extends GenericAUI<ExampleDeleteClerkC> implements AUI {
    public DeleteClerkAUI() {
        super(ExampleDeleteClerkC.class);
    }

    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        selectClerkAUI.selectClerk(frame, (choice) -> {
            this.executeAndHandleError(() -> this.control.deleteClerk(choice));
        });

    }
}
