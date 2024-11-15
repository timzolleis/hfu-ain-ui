package trainingmanagement.control;

import trainingmanagement.entity.Clerk;
import trainingmanagement.entity.Training;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

class SelectTrainginC {
    static String[] getAllNames() {
        return Training.getAllNames();
    }

    public final String[] getTrainingNamesToAttend(final String username) {
        final Clerk clerk = Clerk.getClerk(username);
        final Collection<Training> trainings = Training.getAllTrainings().values();
        final Set<String> trainingsToAttend = new LinkedHashSet<>();

        for (Fortbildung fortbildung : trainings) {
            if (isToAttend(clerk, fortbildung)) {
                trainingsToAttend.add(fortbildung.gibName());
            }
        }

        return trainingsToAttend.toArray(new String[0]);
    }

    public String[] gibZuBestehendeFortbildungenNamen(String benutzername) {
        Sachbearbeiter sachbearbeiter = Sachbearbeiter.gib(benutzername);
        Collection<Fortbildung> fortbildungen = Fortbildung.gibDieFortbildungen().values();
        Set<String> nochZuBestehendeFortbildungen = new LinkedHashSet<>();

        for (Fortbildung fortbildung : fortbildungen) {
            if (pruefeBestehen(sachbearbeiter, fortbildung)) {
                nochZuBestehendeFortbildungen.add(fortbildung.gibName());
            }
        }

        return nochZuBestehendeFortbildungen.toArray(new String[0]);
    }

    private boolean isToAttend(Clerk clerk, Training training) {
        if (clerk.hasAttendedTraining(training)) {
            return false;
        } else if (clerk.hasCompletedTraining(training)) {
            return false;
        } else if (!alleVoraussetzungenVorhanden(clerk, training)) {
            return false;
        } else {
            return true;
        }
    }

    boolean alleVoraussetzungenVorhanden(Clerk clerk, Training training) {
        Set<Fortbildung> voraussetzungen = fortbildung.gibVoraussetzungen();

        for (Fortbildung voraussetzung : voraussetzungen) {
            if (!clerk.istBestanden(voraussetzung)) {
                return false;
            }
        }

        return true;
    }

    private boolean pruefeBestehen(Sachbearbeiter sachbearbeiter, Fortbildung fortbildung) {
        if (!sachbearbeiter.istBelegt(fortbildung)) {
            return false;
        } else if (sachbearbeiter.istBestanden(fortbildung)) {
            return false;
        } else {
            return true;
        }
    }

}
