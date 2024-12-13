package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.components.Form;
import trainingmanagement.components.FormField;
import trainingmanagement.components.RoleSelector;
import trainingmanagement.components.TextField;
import trainingmanagement.control.ExampleEditClerkC;
import trainingmanagement.schema.EditClerkSchema;
import trainingmanagement.schema.ParseResult;

import javax.swing.*;
import java.util.Objects;

public class EditClerkAUI extends GenericAUI<ExampleEditClerkC> {

    private final Form form;
    private String selectedClerk;

    public EditClerkAUI() {
        super(ExampleEditClerkC.class);
        final FormField<String> usernameField = new FormField<>("Username", new TextField());
        final FormField<String> passwordField = new FormField<>("Password", new TextField());
        final FormField<String> roleField = new RoleSelector("Role");

        final Form form = new Form("Edit Clerk");
        form.addField("username", usernameField);
        form.addField("password", passwordField);
        form.addField("role", roleField);
        form.setOnCancel(this::close);
        form.setOnSubmit(this::handleSubmit);
        this.form = form;
        this.add(form);
    }


    protected void handleSubmit(final Form form) {
        final ParseResult<EditClerkSchema> parseResult = form.parse(EditClerkSchema.class);
        if (parseResult.hasErrors()) {
            final String errorMessage = String.join("\n", parseResult.getErrors());
            this.handleErrorMessage(errorMessage);
            return;
        }
        final EditClerkSchema data = parseResult.getResult();
        this.executeAndHandleErrorWithCallback(() -> this.control.updateClerk(selectedClerk, data.getUsername(), data.getPassword(), Objects.equals(data.getRole(), "Admin")), this::close);

    }

    protected void editClerk(final JFrame frame, final String selectedClerk, final boolean editAsAdmin) {
        this.selectedClerk = selectedClerk;
        this.form.getField("username").setDefaultValue(selectedClerk);
        this.form.getField("password").setDefaultValue(this.control.getCurrentPassword(selectedClerk));
        this.form.getField("role").setDefaultValue(this.control.isCurrentlyAdmin(selectedClerk) ? "Admin" : "User");
        this.form.getField("role").setEnabled(editAsAdmin);
        this.form.render();
        this.render(frame);
    }


}
