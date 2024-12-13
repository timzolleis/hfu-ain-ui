package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.components.Form;
import trainingmanagement.components.FormField;
import trainingmanagement.components.RadioButtonGroup;
import trainingmanagement.components.TrainingSelector;
import trainingmanagement.control.ExampleMapTrainingC;

import javax.swing.*;

public class MapTrainingAUI extends GenericAUI<ExampleMapTrainingC> implements AUI {

    public MapTrainingAUI() {
        super(ExampleMapTrainingC.class);
        final Form form = new Form("Map Training");
        final FormField<String> selectedTraining = new TrainingSelector("Training");
        final FormField<String> trainingType = new FormField<>("Training Type", new RadioButtonGroup(new String[]{"Attend", "Complete"}));
        form.addField("training", selectedTraining);
        form.addField("type", trainingType);
        form.setOnCancel(this::close);
        form.setOnSubmit(this::handleSubmit);
        form.render();
        this.add(form);
    }

    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        selectClerkAUI.selectClerk(frame, (choice) -> {
            this.showForm(frame, choice);
        });

    }

    private void handleSubmit(final Form form) {
        this.close();
    }

    private void showForm(final JFrame frame, final String selectedClerk) {
        this.render(frame);
    }

}
