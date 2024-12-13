package trainingmanagement.components;

import javax.swing.*;
import java.awt.*;

public class FormField<T> extends JPanel {
    private final FormInput<T> input;

    public FormField(String label, FormInput<T> input) {
        JLabel jLabel = new JLabel(label);
        this.input = input;
        setLayout(new GridLayout(2, 1));
        add(jLabel);
        add((Component) input);
    }

    public final T getValue() {
        return input.getValue();
    }

    public void setDefaultValue(T value) {
        input.setDefaultValue(value);
    }


    public void setEnabled(boolean enabled) {
        input.setEnabled(enabled);
    }

}
