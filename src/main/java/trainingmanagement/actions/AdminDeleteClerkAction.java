package trainingmanagement.actions;

import trainingmanagement.presentation.DeleteClerkAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AdminDeleteClerkAction extends GenericAction {
    private final JFrame jFrame;

    public AdminDeleteClerkAction(final JFrame jFrame) {
        super("Delete Clerk", "Delete an exising clerk", KeyEvent.VK_D);
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final DeleteClerkAUI deleteClerkAUI = new DeleteClerkAUI();
        deleteClerkAUI.open(jFrame);
    }
}
