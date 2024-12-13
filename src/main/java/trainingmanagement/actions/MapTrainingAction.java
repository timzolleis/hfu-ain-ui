package trainingmanagement.actions;

import trainingmanagement.presentation.MapTrainingAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MapTrainingAction extends GenericAction{

    private final JFrame jFrame;

    public MapTrainingAction(final JFrame jFrame) {
        super("Map training", "Map a training to a clerk", KeyEvent.VK_M);
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final MapTrainingAUI mapTrainingAUI = new MapTrainingAUI();
        mapTrainingAUI.open(jFrame);
    }
}
