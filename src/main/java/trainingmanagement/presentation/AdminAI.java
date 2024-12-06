package trainingmanagement.presentation;


import trainingmanagement.actions.GenericAction;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public class AdminAI extends GenericAI {

    public AdminAI() {
        super("Admin");
    }

    protected final Map<String, Class<? extends AUI>> getAvailableUseCases() {
        return Map.of(
                "Create clerk", AdminCreateClerkAUI.class,
                "Delete clerk", DeleteClerkAUI.class,
                "Edit clerk", AdminEditClerkAUI.class,
                "Map Training", MapTrainingAUI.class,
                "Delete Training", DeleteTrainingMappingAUI.class,
                "Show Trainings", ShowTrainingMappingsAUI.class,
                "Logout", LogoutAUI.class
        );
    }

    @Override
    protected List<GenericAction> getActions(final JFrame frame) {
        return List.of();
    }
}
