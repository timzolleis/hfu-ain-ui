package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class ExampleDeleteClerkC {
    public final String deleteClerk(final String username) {
        try {
            Clerk.getClerk(username).delete();

        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

}