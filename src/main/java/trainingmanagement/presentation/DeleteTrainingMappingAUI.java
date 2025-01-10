package trainingmanagement.presentation;

import trainingmanagement.components.Form;
import trainingmanagement.components.FormField;
import trainingmanagement.components.TrainingSelector;
import trainingmanagement.control.ExampleDeleteTrainingMappingC;
import trainingmanagement.schema.DeleteTrainingMappingSchema;
import trainingmanagement.schema.ParseResult;

import javax.swing.*;

public class DeleteTrainingMappingAUI extends GenericAUI<ExampleDeleteTrainingMappingC> {

    private String[] deletableTrainings = new String[]{};
    private String selectedClerk;

    public DeleteTrainingMappingAUI() {
        super(ExampleDeleteTrainingMappingC.class);
    }

    private void handleSubmit(final Form form) {
        final ParseResult<DeleteTrainingMappingSchema> parseResult = form.parse(DeleteTrainingMappingSchema.class);
        if (parseResult.hasErrors()) {
            final String errorMessage = String.join("\n", parseResult.getErrors());
            this.handleErrorMessage(errorMessage);
            return;
        }
        final String training = parseResult.getResult().getTraining();
        this.executeAndHandleErrorWithCallback(() -> this.control.deleteTrainingMapping(this.selectedClerk, training), this::close);
        this.close();
    }

    private void renderForm() {
        final Form form = new Form("Delete Training Mapping");
        final FormField<String> selectedTraining = new TrainingSelector("Training", this.deletableTrainings);
        form.addField("training", selectedTraining);
        form.setOnCancel(this::close);
        form.setOnSubmit(this::handleSubmit);
        form.render();
        this.add(form);
    }

    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        selectClerkAUI.selectClerk(frame, (choice) -> {
            this.selectedClerk = choice;
            this.deletableTrainings = this.control.getDeletableTrainings(choice);
            this.renderForm();
            this.render(frame);
        });
    }

}
