package trainingmanagement.presentation;

import javax.swing.*;

public class ExitAUI implements AUI {
    @Override
    public void open(final JFrame frame) {
        System.exit(0);
    }
}
