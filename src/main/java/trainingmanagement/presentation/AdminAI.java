package trainingmanagement.presentation;


import java.util.Map;

public class AdminAI extends GenericAI {

    public AdminAI() {
        super(getAvailableUseCases());
    }

    private static Map<String, Class<? extends AUI>> getAvailableUseCases() {
        return Map.of(
                "Create a clerk", AdminCreateClerkAUI.class,
                "Delete a clerk", DeleteClerkAUI.class,
                "Edit a clerk", AdminEditClerkAUI.class,
                "Map a training to a clerk", MapTrainingAUI.class,
                "Delete a training mapping", DeleteTrainingMappingAUI.class,
                "Show training mappings", ShowTrainingMappingsAUI.class,
                "Logout", LogoutAUI.class
        );
    }
}
