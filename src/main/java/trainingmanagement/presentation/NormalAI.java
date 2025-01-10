package trainingmanagement.presentation;

import trainingmanagement.actions.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NormalAI extends GenericAI {

    public NormalAI() {
        super("Clerk");
        super.add(getToolbar(super.getFrame()), BorderLayout.PAGE_START);
    }


    @Override
    protected List<GenericAction> getActions(JFrame frame) {
        return List.of(new NormalEditClerkAction(frame),  new MapTrainingAction(frame), new ShowTrainingsAction(frame), new DeleteTrainingMappingAction(frame), new LogoutAction(frame));
    }
}
