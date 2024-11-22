package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.application.TrainingManagement;

import java.util.Map;

public abstract class GenericAI {
    protected final Map<String, Action> availableActions;

    protected GenericAI(final Map<String, Action> availableActions) {
        this.availableActions = availableActions;
    }

    protected abstract boolean handleAction(Action action);

    public void open() {
        final String[] options = this.availableActions.keySet().stream().sorted().toArray(String[]::new);
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
                final MapTrainingAUI mapTrainingAUI = new MapTrainingAUI();
                mapTrainingAUI.open();
                return true;
            }
            case DELETE_TRAINING_MAPPING -> {
                final DeleteTrainingMappingAUI deleteTrainingMappingAUI = new DeleteTrainingMappingAUI();
                deleteTrainingMappingAUI.open();
                return true;
            }
            case SHOW_TRAINING_MAPPINGS -> {
                final ShowTrainingMappingsAUI showTrainingMappingsAUI = new ShowTrainingMappingsAUI();
                showTrainingMappingsAUI.open();
                return true;
            }
            case Action.DELETE_CLERK -> {
                final DeleteClerkAUI deleteClerkAUI = new DeleteClerkAUI();
                deleteClerkAUI.open();
                return true;
            }
            case LOGOUT -> {
                System.out.println("Logging out...");
                TrainingManagement.logout();
                return false;
            }
            default -> throw new IllegalArgumentException("Invalid action");
        }
    }

}
