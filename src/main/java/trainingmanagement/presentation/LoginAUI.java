package trainingmanagement.presentation;

import trainingmanagement.components.*;
import trainingmanagement.components.TextField;
import trainingmanagement.control.LoginC;
import trainingmanagement.schema.LoginSchema;
import trainingmanagement.schema.ParseResult;
import trainingmanagement.schema.SchemaHelper;

import javax.swing.*;
import java.util.Objects;

public class LoginAUI extends GenericAUI<LoginC> implements AUI {

    public LoginAUI() {
        super(LoginC.class);

        final FormField<String> usernameField = new FormField<>("Username", new TextField());
        final FormField<String> passwordField = new FormField<>("Password", new PasswordField());
        final FormField<String> roleCombobox = new FormField<>("Role", new Combobox<>(new String[]{"User", "Admin"}));

        final Form form = new Form("Login");
        form.addField("username", usernameField);
        form.addField("password", passwordField);
        form.addField("role", roleCombobox);
        form.setOnCancel(this::close);
        form.setOnSubmit(this::handleSubmit);
        form.render();
        this.add(form);
    }

    private void handleSubmit(final Form form) {
        final ParseResult<LoginSchema> parseResult = form.parse(LoginSchema.class);
        if (parseResult.hasErrors()) {
            final String errorMessage = String.join("\n", parseResult.getErrors());
            this.handleErrorMessage(errorMessage);
            return;
        }
        final LoginSchema data = parseResult.getResult();
        final String loginResult = this.control.login(data.getUsername(), data.getPassword(), data.getRole().equals("Admin"));
        if (loginResult == null) {
            final GenericAI aui = Objects.equals(data.getRole(), "Admin") ? new AdminAI() : new NormalAI();
            aui.open();
            this.close();
        } else {
            this.handleErrorMessage(loginResult);
        }

    }

    @Override
    public void open(final JFrame frame) {
        this.render(frame);
    }
}