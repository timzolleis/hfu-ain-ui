package trainingmanagement.presentation;

import javax.swing.*;

public class AdminEditClerkAUI extends EditClerkAUI implements AUI {

    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        final String[] clerkNames = selectClerkAUI.getClerkNames();
        if (clerkNames.length == 0) {
            this.handleErrorMessage("No clerks to edit");
            this.close();
            return;
        }
        selectClerkAUI.selectClerk(frame, (selectedClerk) -> {
            this.editClerk(frame, selectedClerk, true);
        });
    }


}
