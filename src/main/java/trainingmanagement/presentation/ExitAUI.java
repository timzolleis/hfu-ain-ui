package trainingmanagement.presentation;

public class ExitAUI implements AUI{
    @Override
    public void open() {
        System.exit(0);
    }
}
