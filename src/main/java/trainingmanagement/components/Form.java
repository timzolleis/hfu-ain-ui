package trainingmanagement.components;

import lombok.Setter;
import trainingmanagement.schema.ParseResult;
import trainingmanagement.schema.Schema;
import trainingmanagement.schema.SchemaHelper;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Form extends JPanel {
    private final String title;
    private final Map<String, FormField<?>> fields = new LinkedHashMap<>();
    @Setter
    private Runnable onCancel;
    @Setter
    private Consumer<Form> onSubmit;

    public Form(String title) {
        this.title = title;
    }

    public void render() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        final JLabel titleLabel = new JLabel(this.title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, gbc);
        gbc.gridwidth = 1;
        gbc.gridy++;
        this.fields.forEach((key, field) -> {
            this.add(field, gbc);
            gbc.gridy++;
        });
        gbc.gridy++;
        JPanel buttonPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        JButton submitButton = new JButton("Submit");

        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        this.add(buttonPanel, gbc);

        submitButton.addActionListener(e -> {
            if (onSubmit != null) {
                onSubmit.accept(this);
            }
        });

        cancelButton.addActionListener(e -> {
            if (onCancel != null) {
                onCancel.run();
            }
        });
    }

    public void addField(final String key, final FormField<?> field) {
        this.fields.put(key, field);
    }

    public final Object getValue(final String key) {
        if (this.fields.containsKey(key)) {
            return this.fields.get(key).getValue();
        }
        return null;
    }

    public final <T extends Schema> ParseResult<T> parse(final Class<T> clazz) {
        final SchemaHelper<T> helper = new SchemaHelper<>(clazz);
        return helper.parse(this);
    }


}
