package trainingmanagement.schema;

import trainingmanagement.components.Form;

import java.lang.reflect.Field;
import java.util.List;

public class SchemaHelper<T extends Schema> {
    final Class<T> clazz;

    public SchemaHelper(Class<T> clazz) {
        this.clazz = clazz;
    }

    public final ParseResult<T> parse(final Form form) {
        ParseResult<T> result = new ParseResult<>();
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName().toLowerCase();
                Object value = form.getValue(fieldName);
                if (value == null) {
                    result.addError("Field " + fieldName + " is required");
                    continue;
                }
                field.set(instance, value);
            }
            final List<String> customValidationErrors = instance.validate();
            result.getErrors().addAll(customValidationErrors);
            result.setResult(instance);
        } catch (Exception e) {
            result.addError(e.getMessage());
        }

        return result;
    }

}
