package trainingmanagement.presentation;

import java.util.Map;
import java.util.Objects;

public class ClerkP extends GeneralP {

    public ClerkP() {
        super(getAvailableActions());
    }

    private static Map<String, Action> getAvailableActions() {
        return Map.of(
                "Edit a clerk", Action.EDIT_CLERK,
                "Map a training to a clerk", Action.MAP_TRAINING_TO_CLERK,
                "Delete a training mapping", Action.DELETE_TRAINING_MAPPING,
                "Show training mappings", Action.SHOW_TRAINING_MAPPINGS,
                "Logout", Action.LOGOUT
        );
    }

    protected boolean handleAction(Action action) {
        if (Objects.requireNonNull(action) == Action.EDIT_CLERK) {
            final EditClerkP editClerkP = new EditClerkP();
            editClerkP.open(false);
            return true;
        }
        return this.handleSharedActions(action);
    }
}
