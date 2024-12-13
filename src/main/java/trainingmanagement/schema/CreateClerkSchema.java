package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClerkSchema extends Schema {

    private String username;
    private String password;
    private String confirmPassword;
    private String role;

    protected void validateFields() {
        if (this.username.isEmpty()) {
            this.addError("Username is required");
        }
        if (this.password.isEmpty()) {
            this.addError("Password is required");
        }
        if (this.confirmPassword.isEmpty()) {
            this.addError("Confirm Password is required");
        }
        if (!this.password.equals(this.confirmPassword)) {
            this.addError("Password and Confirm Password must match");
        }
        if (this.role.isEmpty()) {
            this.addError("Role is required");
        }
    }
}
