package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

class ExampleClerkC {

    final String getPassword(final String username) {
        return Clerk.getClerk(username).getPassword();
    }

    final boolean getPermission(final String username) {
        return Clerk.getClerk(username).isAdmin();
    }


}
