package trainingmanagement.presentation;

import trainingmanagement.components.*;
import trainingmanagement.control.ExampleCreateClerkC;
import trainingmanagement.schema.CreateClerkSchema;
import trainingmanagement.schema.ParseResult;

import javax.swing.*;
import java.util.Objects;

public class AdminCreateClerkAUI extends GenericAUI<ExampleCreateClerkC> implements AUI {
    public AdminCreateClerkAUI() {
        super(ExampleCreateClerkC.class);

        final FormField<String> usernameField = new FormField<>("Username", new TextField());
        final FormField<String> passwordField = new FormField<>("Password", new TextField());
        final FormField<String> confirmPasswordField = new FormField<>("Confirm Password", new TextField());
        final FormField<String> roleCombobox = new RoleSelector("Role");

        final Form form = new Form("Create Clerk");
        form.addField("username", usernameField);
        form.addField("password", passwordField);
        form.addField("confirmPassword", confirmPasswordField);
        form.addField("role", roleCombobox);
        form.setOnCancel(this::close);
        form.setOnSubmit(this::handleSubmit);
        form.render();
        this.add(form);
    }

    private void handleSubmit(final Form form) {
        final ParseResult<CreateClerkSchema> parseResult = form.parse(CreateClerkSchema.class);
        if (parseResult.hasErrors()) {
            final String errorMessage = String.join("\n", parseResult.getErrors());
            this.handleErrorMessage(errorMessage);
            return;
        }
        final CreateClerkSchema data = parseResult.getResult();
        final String createClerkResult = this.control.addClerk(data.getUsername(), data.getPassword(), Objects.equals(data.getRole(), "Admin"));
        if (createClerkResult == null) {
            this.close();
        } else {
            this.handleErrorMessage(createClerkResult);
        }

    }

    @Override
    public void open(final JFrame frame) {
        this.render(frame);
    }

}