package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.control.ExampleSelectClerkC;
import trainingmanagement.control.SelectClerkC;

public class SelectClerkP extends GenericPresentation<ExampleSelectClerkC> {

    public SelectClerkP() {
        super(ExampleSelectClerkC.class);
    }

    public final String[] getClerkNames() {
        return this.control.getClerkNames();
    }

    public final String selectClerk() {
        return Select.select(this.getClerkNames());
    }

}
