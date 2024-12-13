package trainingmanagement.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public abstract class GenericAction extends AbstractAction {


    public GenericAction(final String name, final String description, final int mnemonic) {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(mnemonic, InputEvent.CTRL_DOWN_MASK));
        putValue(MNEMONIC_KEY, mnemonic);
        putValue(NAME, name);
        putValue(SHORT_DESCRIPTION, description);
    }

    public abstract void actionPerformed(ActionEvent e);

    public final String getName() {
        return (String) getValue(NAME);
    }

}