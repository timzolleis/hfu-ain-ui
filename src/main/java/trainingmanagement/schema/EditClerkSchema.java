package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditClerkSchema extends Schema {

    private String username;
    private String password;
    private String role;

    @Override
    protected void validateFields() {
        if (this.username.isEmpty()) {
            this.addError("Username is required");
        }
        if (this.password.isEmpty()) {
            this.addError("Password is required");
        }
    }
}
