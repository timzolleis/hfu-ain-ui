package trainingmanagement.presentation;

import trainingmanagement.control.ExampleDeleteClerkC;

public class DeleteClerkAUI extends GenericAUI<ExampleDeleteClerkC> implements AUI{
    public DeleteClerkAUI() {
        super(ExampleDeleteClerkC.class);
    }

    public void open() {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        final String[] clerkNames = selectClerkAUI.getClerkNames();
        if (clerkNames.length == 0) {
            System.out.println("No clerks to delete");
        } else {
            final String choice = selectClerkAUI.selectClerk();
            this.executeAndHandleError(() -> this.control.deleteClerk(choice));
        }
    }
}
