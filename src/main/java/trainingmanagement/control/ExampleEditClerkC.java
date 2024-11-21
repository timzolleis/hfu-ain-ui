package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class ExampleEditClerkC {

    public final String updateClerk(final String oldUsername, final String newUsername, final String password, final Boolean isAdmin) {
        final Clerk clerk = Clerk.getClerk(oldUsername);
        try {
            clerk.setUsername(newUsername);
            clerk.setPassword(password);
            clerk.setRole(isAdmin == null ? clerk.isAdmin() : isAdmin);
            return null;
        } catch (final Exception e) {
            return e.getMessage();
        }
    }
}
