package trainingmanagement.presentation;

import trainingmanagement.components.ClerkSelector;
import trainingmanagement.components.Form;
import trainingmanagement.components.FormField;
import trainingmanagement.control.ExampleSelectClerkC;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SelectClerkAUI extends GenericAUI<ExampleSelectClerkC> {

    public SelectClerkAUI() {
        super(ExampleSelectClerkC.class);
    }

    public final String[] getClerkNames() {
        return this.control.getClerkNames();
    }

    public final void selectClerk(final JFrame parentFrame, final Consumer<String> onClerkSelection) {
        final Form form = new Form("Select Clerk");
        final ClerkSelector clerkSelector = new ClerkSelector("Clerk");
        form.addField("clerk", clerkSelector);
        final JDialog dialog = new JDialog(parentFrame, "Select Clerk", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(form, BorderLayout.CENTER);
        form.setOnCancel(dialog::dispose);
        form.setOnSubmit(submitted -> {
            handleSelection(submitted, onClerkSelection);
            dialog.dispose();
        });
        form.render();
        dialog.pack();
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setVisible(true);
        this.render(parentFrame);
    }

    private void handleSelection(final Form form, final Consumer<String> onClerkSelection) {
        final FormField<String> nameField = form.getField("clerk");
        final String selectedClerk = nameField.getValue();
        onClerkSelection.accept(selectedClerk);
    }

}
