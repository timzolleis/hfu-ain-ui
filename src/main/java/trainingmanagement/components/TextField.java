package trainingmanagement.components;

import javax.swing.*;

public class TextField extends JTextField implements FormInput<String> {

    public String getValue() {
        return this.getText();
    }
}
