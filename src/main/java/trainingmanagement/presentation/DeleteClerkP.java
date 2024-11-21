package trainingmanagement.presentation;

import trainingmanagement.control.ExampleDeleteClerkC;

public class DeleteClerkP extends GenericPresentation<ExampleDeleteClerkC> {
    public DeleteClerkP() {
        super(ExampleDeleteClerkC.class);
    }

    public void open() {
        final SelectClerkP selectClerkP = new SelectClerkP();
        final String[] clerkNames = selectClerkP.getClerkNames();
        if (clerkNames.length == 0) {
            System.out.println("No clerks to delete");
        } else {
            final String choice = selectClerkP.selectClerk();
            this.executeAndHandleError(() -> this.control.deleteClerk(choice));
        }
    }
}
