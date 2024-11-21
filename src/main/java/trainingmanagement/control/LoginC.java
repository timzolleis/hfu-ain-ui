package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class LoginC {
    public final Clerk login(final String username, final String password, final Boolean isAdmin) {
        return Clerk.login(username, password, isAdmin);
    }

}
