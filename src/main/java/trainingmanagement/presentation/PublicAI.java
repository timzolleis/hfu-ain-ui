package trainingmanagement.presentation;

import trainingmanagement.actions.ExitAction;
import trainingmanagement.actions.GenericAction;
import trainingmanagement.actions.LoginAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class PublicAI extends GenericAI {
    public PublicAI() {
        super("Menu");
        super.add(getToolbar(super.getFrame()), BorderLayout.PAGE_START);
    }

    private JToolBar getToolbar(final JFrame frame) {
        final JToolBar toolbar = new JToolBar();
        final JButton loginButton = new JButton(new LoginAction(frame));
        final JButton exitButton = new JButton(new ExitAction(frame));
        toolbar.add(loginButton);
        toolbar.add(exitButton);
        return toolbar;
    }


    protected List<GenericAction> getActions(final JFrame frame) {
        return List.of(new LoginAction(frame), new ExitAction(frame));
    }
}
