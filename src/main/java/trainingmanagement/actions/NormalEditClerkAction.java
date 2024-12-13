package trainingmanagement.actions;

import trainingmanagement.presentation.AdminEditClerkAUI;
import trainingmanagement.presentation.NormalEditClerkAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NormalEditClerkAction extends GenericAction {
    private final JFrame jFrame;

    public NormalEditClerkAction(JFrame jFrame) {
        super("Edit Clerk", "Edit an existing clerk", KeyEvent.VK_E);
        this.jFrame = jFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        final NormalEditClerkAUI normalEditClerkAUI = new NormalEditClerkAUI();
        normalEditClerkAUI.open(jFrame);
    }
}
