package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

class ExampleCreateClerkC {

    final String addClerk(final String username, final String password, final boolean isAdmin) {
        try {
            Clerk.addClerk(new Clerk(username, password, isAdmin));
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }

}
