package trainingmanagement.components;

import trainingmanagement.control.SelectClerkC;

public class ClerkSelector extends FormField<String> {
    public ClerkSelector(String label) {
        super(label, new Combobox<>(new SelectClerkC().getClerkNames()));
    }
}
