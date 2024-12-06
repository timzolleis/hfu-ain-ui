package trainingmanagement.application;

import lombok.Getter;
import trainingmanagement.actions.LoginAction;
import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;
import trainingmanagement.presentation.AdminAI;
import trainingmanagement.presentation.NormalAI;
import trainingmanagement.presentation.LoginAUI;
import trainingmanagement.presentation.PublicAI;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class TrainingManagementMI extends JFrame {
    @Getter
    private static Clerk clerk;

    public static void main(String[] args) {
        initialize();
        SwingUtilities.invokeLater(() -> {
            final TrainingManagementMI trainingManagementMI = new TrainingManagementMI();
            trainingManagementMI.open();
        });
    }

    private void open() {
        final PublicAI publicAI = new PublicAI();
        publicAI.open();
    }

    public static void setClerk(final Clerk clerk) {
        TrainingManagementMI.clerk = clerk;
    }


    public static void initialize() {
        //Adds a clerk and some example mappings to the software
        final Clerk exampleAdmin = new Clerk("admin", "password123$", true);
        final Clerk exampleUser = new Clerk("user", "password123$", false);
        Clerk.addClerk(exampleAdmin);
        Clerk.addClerk(exampleUser);

        final Training maths1 = new Training(new HashSet<>(), "Maths 1");
        Training.addTraining(maths1);
        final Training maths2 = new Training(Set.of(maths1), "Maths 2");
        Training.addTraining(maths2);
        final Training business = new Training(new HashSet<>(), "Business");
        Training.addTraining(business);
        final Training costCalculation = new Training(Set.of(maths1, business), "Cost Calculation");
        Training.addTraining(costCalculation);
    }


}
