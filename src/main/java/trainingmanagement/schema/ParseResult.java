package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ParseResult<T> {
    @Getter
    private final List<String> errors = new java.util.ArrayList<>();
    @Getter
    @Setter
    private T result;

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void addError(final String error) {
        errors.add(error);
    }


}
