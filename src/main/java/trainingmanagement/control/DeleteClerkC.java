package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class DeleteClerkC {

    public void deleteClerk(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        clerk.delete();
    }
}
