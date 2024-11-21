package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class CreateClerkC {

    public void createClerk(final String name, final String password, final boolean isAdmin) {
        final Clerk clerk = new Clerk(name, password, isAdmin);
        Clerk.addClerk(clerk);
    }
}
