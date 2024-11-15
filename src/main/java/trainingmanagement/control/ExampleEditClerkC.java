package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

class ExampleEditClerkC {

    final String updateClerk(final String oldUsername, final String newUsername, final String password, final boolean isAdmin) {
        final Clerk clerk = Clerk.getClerk(oldUsername);
        try {
            clerk.setUsername(newUsername);
            clerk.setPassword(password);
            clerk.setRole(isAdmin);
            return null;
        } catch (final Exception e) {
            return e.getMessage();
        }
    }
}
