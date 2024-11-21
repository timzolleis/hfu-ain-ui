package trainingmanagement.presentation;

import java.util.function.Supplier;

public class GenericPresentation<T> {
    protected final T control;

    public GenericPresentation(Class<T> clazz) {
        try {
            this.control = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create control instance", e);
        }
    }

    protected void handleErrorMessage(final String errorMessage) {
        if (errorMessage != null) {
            System.out.println("\u001B[31mError: " + errorMessage + "\u001B[0m");
        }
    }

    protected void executeAndHandleError(Supplier<String> action) {
        String errorMessage = action.get();
        handleErrorMessage(errorMessage);
    }
}