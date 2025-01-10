package trainingmanagement.components;

import trainingmanagement.control.ExampleSelectTrainingC;

public class TrainingSelector extends FormField<String> {
    public TrainingSelector(String label) {
        super(label, new Combobox<>(new ExampleSelectTrainingC().getAllNames()));
    }

    public TrainingSelector(String label, String[] values) {
        super(label, new Combobox<>(values));
    }
}
