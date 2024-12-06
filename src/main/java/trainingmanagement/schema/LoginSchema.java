package trainingmanagement.schema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginSchema extends Schema {

    private String username;
    private String password;
    private String role;

    protected void validateFields() {
        if (this.username.isEmpty()) {
            this.addError("Username is required");
        }
        if (this.password.isEmpty()) {
            this.addError("Password is required");
        }
        if (this.role.isEmpty()) {
            this.addError("Role is required");
        }
        if (!this.role.equals("User") && !this.role.equals("Admin")) {
            this.addError("Role must be either User or Admin");
        }
    }
}
