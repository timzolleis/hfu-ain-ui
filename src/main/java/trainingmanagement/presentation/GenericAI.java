package trainingmanagement.presentation;

import task02.Select;

import java.util.Map;

public abstract class GenericAI {
    protected final Map<String, Class<? extends AUI>> availableUseCases;

    protected GenericAI(final Map<String, Class<? extends AUI>> availableUseCases) {
        this.availableUseCases = availableUseCases;
    }


    public void open() {
        final String[] options = this.availableUseCases.keySet().stream().sorted().toArray(String[]::new);
        final String selectedOption = Select.select(options);
        final Class<? extends AUI> aui = this.availableUseCases.get(selectedOption);
        try {
            final AUI auiInstance = aui.getDeclaredConstructor().newInstance();
            auiInstance.open();
        } catch (Exception e) {
            System.out.println("Failed to create AUI instance");
        }
    }

}
