package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.application.TrainingManagementMI;
import trainingmanagement.control.LoginC;
import trainingmanagement.entity.Clerk;

public class LoginAUI extends GenericAUI<LoginC> implements AUI {

    public LoginAUI() {
        super(LoginC.class);
    }

    public void open() {
        final String username = Input.getString("Enter username: ");
        final String password = Input.getString("Enter password: ");
        final boolean isAdmin = Input.getBoolean("Login as admin (true/false): ");
        final String loginResult = this.control.login(username, password, isAdmin);
        if (loginResult == null) {
            TrainingManagementMI.setClerk(new Clerk(username, password, isAdmin));
            return;
        }
        this.handleErrorMessage(loginResult);
    }
}
