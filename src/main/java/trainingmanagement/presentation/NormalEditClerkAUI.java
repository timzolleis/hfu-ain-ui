package trainingmanagement.presentation;

public class NormalEditClerkAUI extends EditClerkAUI implements AUI {
    public void open() {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        final String[] clerkNames = selectClerkAUI.getClerkNames();
        if (clerkNames.length == 0) {
            System.out.println("No clerks to edit");
            return;
        }
        final String selectedClerk = selectClerkAUI.selectClerk();
        this.editClerk(selectedClerk, false);
    }
}
