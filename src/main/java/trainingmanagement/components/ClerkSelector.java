package trainingmanagement.components;

import trainingmanagement.control.ExampleSelectClerkC;

public class ClerkSelector extends FormField<String> {
    public ClerkSelector(String label) {
        super(label, new Combobox<>(new ExampleSelectClerkC().getClerkNames()));
    }
}
