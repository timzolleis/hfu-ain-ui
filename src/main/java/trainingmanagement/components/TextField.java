package trainingmanagement.components;

import javax.swing.*;

public class TextField extends JTextField implements FormInput<String> {

    public String getValue() {
        return this.getText();
    }

    @Override
    public void setDefaultValue(String value) {
        this.setText(value);
    }
}
