package trainingmanagement.presentation;

import javax.swing.*;

public class LogoutAUI implements AUI {
    @Override
    public void open(final JFrame frame) {
        frame.dispose();
        final PublicAI publicAI = new PublicAI();
        publicAI.open();
    }
}
