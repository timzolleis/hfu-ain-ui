package trainingmanagement.presentation;

import java.util.Map;

public class PublicAI extends GenericAI {
    public PublicAI() {
        super(getAvailableActions());
    }

    private static Map<String, Class<? extends AUI>> getAvailableActions() {
        return Map.of(
                "Login", LoginAUI.class,
                "Exit", ExitAUI.class
        );
    }
}
