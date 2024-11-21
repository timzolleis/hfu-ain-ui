package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.control.LoginC;
import trainingmanagement.entity.Clerk;

import java.util.Scanner;

public class LoginP extends GenericPresentation<LoginC> {

    public LoginP() {
        super(LoginC.class);
    }

    public Clerk open() {
        final String username = Input.getString("Enter username: ");
        final String password = Input.getString("Enter password: ");
        final boolean isAdmin = Input.getBoolean("Login as admin (true/false): ");
        try {
            return this.control.login(username, password, isAdmin);
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            return null;
        }
    }
}
