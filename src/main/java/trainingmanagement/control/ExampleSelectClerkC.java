package trainingmanagement.control;

import trainingmanagement.entity.Clerk;

class ExampleSelectClerkC {
    final String[] getClerkNames() {
        return Clerk.getAllNames();
    }

}
