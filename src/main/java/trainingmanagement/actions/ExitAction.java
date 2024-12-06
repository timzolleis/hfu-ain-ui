package trainingmanagement.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ExitAction extends GenericAction {

    private final JFrame frame;

    public ExitAction(final JFrame frame) {
        super("Exit", "Exit the application", KeyEvent.VK_Q);
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
