package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.ExampleCreateClerkC;

public class CreateClerkAUI extends GenericAUI<ExampleCreateClerkC> {
    public CreateClerkAUI() {
        super(ExampleCreateClerkC.class);
    }

    public void open(final boolean openAsAdmin) {
        final String username = Input.getString("Enter username: ");
        final String password = Input.getString("Enter password: ");
        final boolean isAdmin = openAsAdmin ? Input.getBoolean("Admin Role (true/false)?: ") : false;
        this.executeAndHandleError(() -> this.control.addClerk(username, password, isAdmin));
    }


}
