package trainingmanagement.actions;

import trainingmanagement.presentation.LoginAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LoginAction extends GenericAction {
    private final JFrame frame;

    public LoginAction(final JFrame frame) {
        super("Login", "Login to the system", KeyEvent.VK_L);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final LoginAUI loginAUI = new LoginAUI();
        loginAUI.open(frame);
    }
}
