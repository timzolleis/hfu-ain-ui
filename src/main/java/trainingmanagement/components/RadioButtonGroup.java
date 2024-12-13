package trainingmanagement.components;

import javax.swing.*;
import java.util.Collections;

public class RadioButtonGroup extends JPanel implements FormInput<String> {

    private final ButtonGroup buttonGroup = new ButtonGroup();

    public RadioButtonGroup(String[] items) {
        for (String item : items) {
            JRadioButton radioButton = new JRadioButton(item);
            radioButton.setActionCommand(item);
            this.buttonGroup.add(radioButton);
        }
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (AbstractButton button : Collections.list(this.buttonGroup.getElements())) {
            this.add(button);
        }

    }

    @Override
    public String getValue() {
        return this.buttonGroup.getSelection().getActionCommand();

    }

    public void setDefaultValue(final String value) {
        for (AbstractButton button : Collections.list(this.buttonGroup.getElements())) {
            if (button.getActionCommand().equals(value)) {
                button.setSelected(true);
            }
        }
    }

    @Override
    public void setEnabled(final boolean enabled) {
        for (AbstractButton button : Collections.list(this.buttonGroup.getElements())) {
            button.setEnabled(enabled);
        }
    }
}
