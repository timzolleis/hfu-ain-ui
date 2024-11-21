package trainingmanagement.presentation;

import task02.Input;
import task02.Select;
import trainingmanagement.application.TrainingManagement;

import java.util.Map;

public abstract class GeneralP {
    protected final Map<String, Action> availableActions;

    protected GeneralP(final Map<String, Action> availableActions) {
        this.availableActions = availableActions;
    }

    protected abstract boolean handleAction(Action action);

    public void open() {
        final String[] options = this.availableActions.keySet().toArray(String[]::new);
        final String selectedOption = Select.select(options);
        final Action action = this.availableActions.get(selectedOption);
        final boolean shouldContinue = this.handleAction(action);
        if (shouldContinue) {
            this.open();
        }
    }

    public final boolean handleSharedActions(final Action action) {
        switch (action) {
            case MAP_TRAINING_TO_CLERK -> {
                final MapTrainingP mapTrainingP = new MapTrainingP();
                mapTrainingP.open();
                return true;
            }
            case DELETE_TRAINING_MAPPING -> {
                final DeleteTrainingMappingP deleteTrainingMappingP = new DeleteTrainingMappingP();
                deleteTrainingMappingP.open();
                return true;
            }
            case SHOW_TRAINING_MAPPINGS -> {
                final ShowTrainingMappingsP showTrainingMappingsP = new ShowTrainingMappingsP();
                showTrainingMappingsP.open();
                return true;
            }
            case Action.DELETE_CLERK -> {
                final DeleteClerkP deleteClerkP = new DeleteClerkP();
                deleteClerkP.open();
                return true;
            }
            case LOGOUT -> {
                TrainingManagement.logout();
                return false;
            }
            default -> {
                throw new IllegalArgumentException("Invalid action");
            }
        }
    }

}
