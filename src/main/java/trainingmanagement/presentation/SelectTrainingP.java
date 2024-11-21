package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.control.ExampleSelectTrainingC;

public class SelectTrainingP extends GenericPresentation<ExampleSelectTrainingC> {

    public SelectTrainingP() {
        super(ExampleSelectTrainingC.class);
    }

    public final String[] getTrainingNames() {
        return this.control.getAllNames();
    }

    public final String selectTraining() {
        return Select.select(this.getTrainingNames());

    }


}
