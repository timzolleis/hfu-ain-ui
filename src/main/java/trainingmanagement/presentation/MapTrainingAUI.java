package trainingmanagement.presentation;

import task02.Input;
import trainingmanagement.components.Form;
import trainingmanagement.components.FormField;
import trainingmanagement.components.RadioButtonGroup;
import trainingmanagement.components.TrainingSelector;
import trainingmanagement.control.ExampleMapTrainingC;
import trainingmanagement.schema.MapTrainingSchema;
import trainingmanagement.schema.ParseResult;

import javax.swing.*;
import java.util.Objects;

public class MapTrainingAUI extends GenericAUI<ExampleMapTrainingC> implements AUI {

    private String selectedClerk;

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
        final ParseResult<MapTrainingSchema> parseResult = form.parse(MapTrainingSchema.class);
        if (parseResult.hasErrors()) {
            final String errorMessage = String.join("\n", parseResult.getErrors());
            this.handleErrorMessage(errorMessage);
            return;
        }
        final MapTrainingSchema data = parseResult.getResult();
        this.executeAndHandleErrorWithCallback(() -> {
            if (Objects.equals(data.getType(), "Attend")) {
                return this.control.attendTraining(this.selectedClerk, data.getTraining());
            } else {
                return this.control.completeTraining(this.selectedClerk, data.getTraining());
            }
        }, this::close);
    }

    private void showForm(final JFrame frame, final String selectedClerk) {
        this.selectedClerk = selectedClerk;
        this.render(frame);
    }

}
