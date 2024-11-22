package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.control.ExampleSelectClerkC;

public class SelectClerkAUI extends GenericAUI<ExampleSelectClerkC> {

    public SelectClerkAUI() {
        super(ExampleSelectClerkC.class);
    }

    public final String[] getClerkNames() {
        return this.control.getClerkNames();
    }

    public final String selectClerk() {
        return Select.select(this.getClerkNames());
    }

}
