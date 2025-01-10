package trainingmanagement.actions;

import trainingmanagement.presentation.LoginAUI;
import trainingmanagement.presentation.LogoutAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LogoutAction extends GenericAction{
    private final JFrame frame;

    public LogoutAction(final JFrame frame) {
        super("Logout", "Logout of the system", KeyEvent.VK_T);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final LogoutAUI logoutAUI = new LogoutAUI();
        logoutAUI.open(frame);
    }
}
