package trainingmanagement.components;

import javax.swing.*;

public class Combobox<T> extends JComboBox<T> implements FormInput<T> {

    public Combobox(T[] items) {
        super(items);
    }


    @Override
    public T getValue() {
        return (T) this.getSelectedItem();
    }

    @Override
    public void setDefaultValue(T value) {
        this.setSelectedItem(value);
    }
}
