package trainingmanagement.application;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;
import trainingmanagement.presentation.AdminP;
import trainingmanagement.presentation.ClerkP;
import trainingmanagement.presentation.LoginP;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TrainingManagement {
    private static Clerk clerk;

    public static void main(String[] args) {
        initialize();
        while (true) {
            if (clerk == null) {
                login();
            }
            if (clerk.isAdmin()) {
                final AdminP adminP = new AdminP();
                adminP.open();
            } else {
                final ClerkP clerkP = new ClerkP();
                clerkP.open();
            }
        }
    }

    private static void login() {
        final LoginP loginP = new LoginP();
        final Clerk loggedInClerk = loginP.open();
        if (loggedInClerk != null) {
            TrainingManagement.clerk = loggedInClerk;
        } else {
            System.out.println("Please log in to continue");
            login();
        }
    }
    public static void logout() {
        clerk = null;
        login();
    }


    public static void initialize() {
        //Adds a clerk and some example mappings to the software
        final Clerk exampleAdmin = new Clerk("admin", "password123$", true);
        final Clerk exampleUser = new Clerk("user", "password123$", false);
        Clerk.addClerk(exampleAdmin);
        Clerk.addClerk(exampleUser);

        final Training maths1 = new Training(new HashSet<Training>(), "Maths 1");
        Training.addTraining(maths1);
        final Training maths2 = new Training(Set.of(maths1), "Maths 2");
        Training.addTraining(maths2);
        final Training business = new Training(new HashSet<>(), "Business");
        Training.addTraining(business);
        final Training costCalculation = new Training(Set.of(maths1, business), "Cost Calculation");
        Training.addTraining(costCalculation);
    }


}
