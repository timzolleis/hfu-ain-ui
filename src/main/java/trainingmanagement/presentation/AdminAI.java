package trainingmanagement.presentation;


import java.util.Map;

public class AdminAI extends GenericAI {

    public AdminAI() {
        super(getAvailableActions());
    }

    private static Map<String, Action> getAvailableActions() {
        return Map.of(
                "Create a clerk", Action.CREATE_CLERK,
                "Delete a clerk", Action.DELETE_CLERK,
                "Edit a clerk", Action.EDIT_CLERK,
                "Map a training to a clerk", Action.MAP_TRAINING_TO_CLERK,
                "Delete a training mapping", Action.DELETE_TRAINING_MAPPING,
                "Show training mappings", Action.SHOW_TRAINING_MAPPINGS,
                "Logout", Action.LOGOUT
        );
    }

    protected boolean handleAction(Action action) {
        switch (action) {
            case Action.CREATE_CLERK -> {
                final CreateClerkAUI createClerkAUI = new CreateClerkAUI();
                createClerkAUI.open(true);
                return true;
            }
            case Action.EDIT_CLERK -> {
                final EditClerkAUI editClerkAUI = new EditClerkAUI();
                editClerkAUI.open(true);
                return true;
            }
            default -> {
                return this.handleSharedActions(action);
            }
        }

    }
}
