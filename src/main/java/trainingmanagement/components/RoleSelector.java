package trainingmanagement.components;

public class RoleSelector extends FormField<String> {
    public RoleSelector(String label) {
        super(label, new Combobox<>(new String[]{"User", "Admin"}));
    }
}
