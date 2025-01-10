package trainingmanagement.presentation;

import trainingmanagement.control.ExampleShowTrainingMappingC;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ShowTrainingMappingsAUI extends GenericAUI<ExampleShowTrainingMappingC> implements AUI {

    public ShowTrainingMappingsAUI() {
        super(ExampleShowTrainingMappingC.class);
    }

    public void open(final JFrame frame) {
        final SelectClerkAUI selectClerkAUI = new SelectClerkAUI();
        selectClerkAUI.selectClerk(frame, (choice) -> {
            final String[] completedTrainingNames = control.getCompletedTrainingNames(choice);
            final String[] attendedTrainingNames = control.getAttendedTrainingNames(choice);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            this.add(createTrainingPanel("Attended Trainings", attendedTrainingNames));

            this.add(Box.createRigidArea(new Dimension(0, 20)));

            this.add(createTrainingPanel("Completed Trainings", completedTrainingNames));
            this.render(frame);
        });
    }

    private static JPanel createTrainingPanel(String title, String[] trainings) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        final JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(titleLabel);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        for (String training : trainings) {
            final JLabel trainingLabel = new JLabel(training);
            trainingLabel.setHorizontalAlignment(SwingConstants.CENTER);
            trainingLabel.setOpaque(true);
            trainingLabel.setBackground(Color.WHITE);

            trainingLabel.setBorder(new CompoundBorder(
                    new LineBorder(Color.BLACK, 2, true),
                    new EmptyBorder(10, 20, 10, 20)
            ));
            trainingLabel.setPreferredSize(new Dimension(200, 40));
            panel.add(trainingLabel);

            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        return panel;
    }
}
