package trainingmanagement.presentation;

import task02.Select;
import trainingmanagement.actions.GenericAction;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public abstract class GenericAI extends JFrame {

    protected GenericAI(final String menuName) {
        this.setJMenuBar(this.createMenuBar(menuName));
    }

    protected final JMenuBar createMenuBar(final String menuName) {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu menu = new JMenu(menuName);
        this.getActions(this).forEach(action -> {
            final JMenuItem menuItem = new JMenuItem(action);
            menu.add(menuItem);
        });
        menuBar.add(menu);
        return menuBar;
    }

    public void open() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    protected JToolBar getToolbar(final JFrame frame) {
        final JToolBar toolbar = new JToolBar();
        this.getActions(frame).forEach(action -> toolbar.add(new JButton(action)));
        return toolbar;
    }

    protected final JFrame getFrame() {
        return this;
    }

    protected abstract List<GenericAction> getActions(final JFrame frame);

}
