package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.ExampleEditClerkC;

public class EditClerkAUI extends GenericAUI<ExampleEditClerkC> {


    public EditClerkAUI() {
        super(ExampleEditClerkC.class);
    }

    protected void editClerk(final String selectedClerk, final boolean editAsAdmin) {
        final String username = Input.getString("Enter username: ");
        final String password = Input.getString("Enter password: ");
        Boolean isAdmin;
        if (editAsAdmin) {
            isAdmin = Input.getBoolean("Enter role (true/false): ");
        } else {
            isAdmin = null;
        }
        this.executeAndHandleError(() -> this.control.updateClerk(selectedClerk, username, password, isAdmin));
    }


}
