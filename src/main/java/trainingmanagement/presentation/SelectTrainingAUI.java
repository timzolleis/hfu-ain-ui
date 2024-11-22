package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.control.ExampleSelectTrainingC;

public class SelectTrainingAUI extends GenericAUI<ExampleSelectTrainingC> {

    public SelectTrainingAUI() {
        super(ExampleSelectTrainingC.class);
    }

    public final String[] getTrainingNames() {
        return this.control.getAllNames();
    }

    public final String selectTraining() {
        return Select.select(this.getTrainingNames());

    }


}
