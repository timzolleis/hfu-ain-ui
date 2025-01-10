package trainingmanagement.presentation;


import trainingmanagement.actions.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class AdminAI extends GenericAI {

    public AdminAI() {
        super("Admin");
        super.add(getToolbar(super.getFrame()), BorderLayout.PAGE_START);
    }


    @Override
    protected List<GenericAction> getActions(final JFrame frame) {
        return List.of(new CreateClerkAction(frame), new AdminEditClerkAction(frame), new AdminDeleteClerkAction(frame), new MapTrainingAction(frame), new ShowTrainingsAction(frame), new DeleteTrainingMappingAction(frame), new LogoutAction(frame));
    }
}
