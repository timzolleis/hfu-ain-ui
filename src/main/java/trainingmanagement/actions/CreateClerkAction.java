package trainingmanagement.actions;

import trainingmanagement.presentation.AdminCreateClerkAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CreateClerkAction extends GenericAction {
    private final JFrame jFrame;

    public CreateClerkAction(JFrame jFrame) {
        super("Create Clerk", "Create a new clerk", KeyEvent.VK_C);
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final AdminCreateClerkAUI adminCreateClerkAUI = new AdminCreateClerkAUI();
        adminCreateClerkAUI.open(jFrame);
    }
}
