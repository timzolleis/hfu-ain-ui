package trainingmanagement.presentation;

import java.util.Map;
import java.util.Objects;

public class NormalAI extends GenericAI {

    public NormalAI() {
        super(getAvailableActions());
    }

    private static Map<String, Class<? extends AUI>> getAvailableActions() {
        return Map.of(
                "Edit a clerk", NormalEditClerkAUI.class,
                "Map a training to a clerk", MapTrainingAUI.class,
                "Delete a training mapping", DeleteTrainingMappingAUI.class,
                "Show training mappings", ShowTrainingMappingsAUI.class,
                "Logout", LogoutAUI.class
        );
    }
}
