package trainingmanagement.actions;

import trainingmanagement.presentation.DeleteTrainingMappingAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteTrainingMappingAction extends GenericAction{
    private final JFrame jFrame;

    public DeleteTrainingMappingAction(final JFrame jFrame) {
        super("Delete training", "Delete a training from a clerk", KeyEvent.VK_R);
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final DeleteTrainingMappingAUI deleteTrainingMappingAUI = new DeleteTrainingMappingAUI();
        deleteTrainingMappingAUI.open(jFrame);
    }
}
