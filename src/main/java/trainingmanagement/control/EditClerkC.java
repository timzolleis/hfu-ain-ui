package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class EditClerkC {

    public void updateClerk(final String oldName, final String newName, final String newPassword, final Boolean newIsAdmin) {
        final Clerk clerk = Clerk.getClerk(oldName);
        clerk.setUsername(newName);
        clerk.setPassword(newPassword);
        clerk.setRole(newIsAdmin == null ? clerk.isAdmin() : newIsAdmin);
    }
}
