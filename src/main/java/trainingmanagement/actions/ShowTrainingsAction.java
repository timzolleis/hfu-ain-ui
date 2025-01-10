package trainingmanagement.actions;


import trainingmanagement.presentation.DeleteTrainingMappingAUI;
import trainingmanagement.presentation.ShowTrainingMappingsAUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ShowTrainingsAction extends GenericAction{

    private final JFrame jFrame;

    public ShowTrainingsAction(final JFrame jFrame) {
        super("Show trainings", "Show the trainings of a clerk", KeyEvent.VK_S);
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final ShowTrainingMappingsAUI showTrainingMappingsAUI = new ShowTrainingMappingsAUI();
        showTrainingMappingsAUI.open(jFrame);
    }
}
