package trainingmanagement.components;

import javax.swing.*;

public class PasswordField extends JPasswordField implements FormInput<String> {

    public String getValue() {
        return new String(this.getPassword());
    }
}
