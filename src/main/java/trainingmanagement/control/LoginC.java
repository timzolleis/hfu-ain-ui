package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class LoginC {

    public final String login(final String username, final String password, final Boolean isAdmin) {
        try {
            final Clerk clerk = Clerk.login(username, password, isAdmin);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
