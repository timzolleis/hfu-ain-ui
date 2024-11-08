package trainingmanagement.control;

import trainingmanagement.entity.Training;

public class SelectTrainingC {
    final String[] getTrainingNames() {
        return Training.getAllNames();
    }

}
