package trainingmanagement.actions;

import trainingmanagement.presentation.AdminEditClerkAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AdminEditClerkAction extends GenericAction{
    private final JFrame jFrame;

    public AdminEditClerkAction(JFrame jFrame) {
        super("Edit Clerk", "Edit an existing clerk", KeyEvent.VK_E);
        this.jFrame = jFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        final AdminEditClerkAUI adminEditClerkAUI = new AdminEditClerkAUI();
        adminEditClerkAUI.open(jFrame);
    }
}
