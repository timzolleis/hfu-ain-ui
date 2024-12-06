package trainingmanagement.presentation;

import trainingmanagement.control.ExampleCreateClerkC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AdminCreateClerkAUI extends GenericAUI<ExampleCreateClerkC> implements AUI {
    public AdminCreateClerkAUI() {
        super(ExampleCreateClerkC.class);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel createClerkLabel = new JLabel("Create Clerk");
        createClerkLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(createClerkLabel, gbc);




        gbc.gridwidth = 1;
        gbc.gridy++;
        this.add(new JLabel("Username:"), gbc);

        gbc.gridy++;
        JTextField usernameField = new JTextField(15);
        this.add(usernameField, gbc);

        gbc.gridy++;
        this.add(new JLabel("Password:"), gbc);

        gbc.gridy++;
        JPasswordField passwordField = new JPasswordField(15);
        this.add(passwordField, gbc);

        gbc.gridy++;
        this.add(new JLabel("Role:"), gbc);

        gbc.gridy++;
        String[] roles = {"User", "Admin"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        this.add(roleComboBox, gbc);

        gbc.gridy++;
        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        this.add(buttonPanel, gbc);

        submitButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean isAdmin = Objects.equals(roleComboBox.getSelectedItem(), "Admin");
            executeAndHandleError(() -> control.addClerk(username, password, isAdmin));
        });

        cancelButton.addActionListener(e -> {
            this.close();
        });
    }

    @Override
    public void open(final JFrame frame) {
        this.render(frame);
    }
}