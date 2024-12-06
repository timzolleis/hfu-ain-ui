package trainingmanagement.schema;

import java.util.ArrayList;
import java.util.List;

public abstract class Schema {
    private final List<String> schemaErrors = new ArrayList<>();

    public final List<String> validate() {
        this.schemaErrors.clear();
        this.validateFields();
        return this.schemaErrors;
    }

    protected void addError(final String error) {
        this.schemaErrors.add(error);
    }

    protected abstract void validateFields();
}
