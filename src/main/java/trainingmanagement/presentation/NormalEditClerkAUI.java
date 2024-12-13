package trainingmanagement.presentation;

import javax.swing.*;

public class NormalEditClerkAUI extends EditClerkAUI implements AUI {
    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        selectClerkAUI.selectClerk(frame, (choice) -> {
            this.editClerk(frame, choice, false);
        });
    }
}
