package trainingmanagement.presentation;

import javax.swing.*;
import java.util.function.Supplier;

public class GenericAUI<T> extends JPanel {
    protected final T control;

    public GenericAUI(Class<T> clazz) {
        try {
            this.control = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create control instance", e);
        }
    }

    protected void handleErrorMessage(final String errorMessage) {
        //Show error message pop-up
        if (errorMessage != null && !errorMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void executeAndHandleError(Supplier<String> action) {
        String errorMessage = action.get();
        handleErrorMessage(errorMessage);
    }

    protected void executeAndHandleErrorWithCallback(Supplier<String> action, Runnable callback) {
        String errorMessage = action.get();
        if (errorMessage != null) {
            handleErrorMessage(errorMessage);
        } else {
            callback.run();
        }
    }

    protected void render(final JFrame frame) {
        frame.add(this);
        frame.revalidate();
        frame.repaint();
    }

    public void close() {
        final JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        frame.remove(this);
        frame.revalidate();
        frame.repaint();
    }

    protected void closeFrame() {
        final JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        frame.dispose();
    }
}