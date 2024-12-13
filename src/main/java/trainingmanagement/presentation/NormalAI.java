package trainingmanagement.presentation;

import trainingmanagement.actions.GenericAction;
import trainingmanagement.actions.NormalEditClerkAction;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NormalAI extends GenericAI {

    public NormalAI() {
        super("Clerk");
    }

    protected Map<String, Class<? extends AUI>> getAvailableUseCases() {
        return Map.of(
                "Edit", NormalEditClerkAUI.class,
                "Map Training", MapTrainingAUI.class,
                "Delete Training", DeleteTrainingMappingAUI.class,
                "Show Trainings", ShowTrainingMappingsAUI.class,
                "Logout", LogoutAUI.class
        );
    }

    @Override
    protected List<GenericAction> getActions(JFrame frame) {
        return List.of(new NormalEditClerkAction(frame));
    }
}
