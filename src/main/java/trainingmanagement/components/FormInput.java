package trainingmanagement.components;

public interface FormInput<T> {
    T getValue();
    void setDefaultValue(T value);
    void setEnabled(boolean enabled);
}
