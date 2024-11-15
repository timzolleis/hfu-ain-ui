package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

class ExampleDeleteClerkC {
    final String deleteClerk(final String username) {
        try {
            Clerk.getClerk(username).delete();

        } catch (Exception e) {
            return e.getMessage();
        }
        return null;
    }

}
