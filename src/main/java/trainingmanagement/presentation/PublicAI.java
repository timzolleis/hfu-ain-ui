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

    protected List<GenericAction> getActions(final JFrame frame) {
        return List.of(new LoginAction(frame), new ExitAction(frame));
    }
}
