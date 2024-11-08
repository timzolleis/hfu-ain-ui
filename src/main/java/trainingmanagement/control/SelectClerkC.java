package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class SelectClerkC {
    final String[] getClerkNames() {
        return Clerk.getAllNames();
    }
}
