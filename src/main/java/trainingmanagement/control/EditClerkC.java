package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class EditClerkC {

    void updateClerk(final String oldName, final String newName, final String newPassword, final boolean newIsAdmin) {
        final Clerk clerk = Clerk.getClerk(oldName);
        clerk.setUsername(newName);
        clerk.setPassword(newPassword);
        clerk.setRole(newIsAdmin);
    }
}
