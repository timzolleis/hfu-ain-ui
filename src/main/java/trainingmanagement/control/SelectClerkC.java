package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

public class SelectClerkC {
    public final String[] getClerkNames() {
        return Clerk.getAllNames();
    }
}
