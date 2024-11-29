package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.ExampleCreateClerkC;

public class AdminCreateClerkAUI extends GenericAUI<ExampleCreateClerkC> implements AUI {
    public AdminCreateClerkAUI() {
        super(ExampleCreateClerkC.class);
    }

    public void open() {
        final String username = Input.getString("Enter username: ");
        final String password = Input.getString("Enter password: ");
        final boolean isAdmin = Input.getBoolean("Admin Role (true/false)?: ");
        this.executeAndHandleError(() -> this.control.addClerk(username, password, isAdmin));
    }


}
