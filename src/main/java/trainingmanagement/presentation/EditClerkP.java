package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.EditClerkC;
import trainingmanagement.control.ExampleEditClerkC;

public class EditClerkP extends GenericPresentation<ExampleEditClerkC> {


    public EditClerkP() {
        super(ExampleEditClerkC.class);
    }

    public void open(final boolean editAsAdmin) {
        final SelectClerkP selectClerkP = new SelectClerkP();
        final String[] clerkNames = selectClerkP.getClerkNames();
        if (clerkNames.length == 0) {
            System.out.println("No clerks to edit");
            return;
        }
        final String selectedClerk = selectClerkP.selectClerk();
        this.editClerk(selectedClerk, editAsAdmin);
    }


    private void editClerk(final String selectedClerk, final boolean editAsAdmin) {
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
