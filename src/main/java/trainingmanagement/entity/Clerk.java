package trainingmanagement.entity;

import lombok.Getter;
import trainingmanagement.exception.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Getter
public class Clerk {
    private String username;
    private String password;
    private boolean isAdmin;
    private final Map<String, Training> completedTrainings = new HashMap<>();
    private final Map<String, Training> attendedTrainings = new HashMap<>();
    private static final Map<String, Clerk> allClerks = new HashMap<>();

    public Clerk(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static void addClerk(final Clerk clerk) {
        if (!Clerk.validPassword(clerk.getPassword())) {
            throw new IllegalArgumentException("Password does not match criteria");
        }
        if (Clerk.usernameExists(clerk.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        allClerks.put(clerk.getUsername(), clerk);
    }

    public static Clerk getClerk(final String clerkName) {
        if (!allClerks.containsKey(clerkName)) {
            throw new ClerkNotFoundException(clerkName);
        }
        return allClerks.get(clerkName);
    }

    public static String[] getAllNames() {
        return allClerks.keySet().toArray(String[]::new);
    }

    public static boolean hasClerks() {
        return !allClerks.isEmpty();
    }

    public static boolean hasAdmin() {
        return allClerks.values().stream().anyMatch(Clerk::isAdmin);
    }

    public static boolean passwordMatches(final String username, final String password) {
        return allClerks.get(username).getPassword().equals(password);
    }

    private static boolean usernameExists(final String username) {
        return allClerks.containsKey(username);
    }

    private static boolean validPassword(final String password) {
        final boolean minLength = password.length() >= 8;
        final Pattern numberRegex = Pattern.compile(".*\\d.*");
        final Pattern specialCharacterRegex = Pattern.compile(".*[!@#$%^&*].*");

        return minLength && numberRegex.matcher(password).matches() && specialCharacterRegex.matcher(password).matches();
    }

    public void setUsername(final String username) {
        if (Clerk.usernameExists(username)) {
            throw new InvalidUsernameException("Username already exists");
        }
        this.username = username;
        Clerk.allClerks.put(username, this);
    }

    public void setPassword(final String password) {
        if (!Clerk.validPassword(password)) {
            throw new InvalidPasswordException("Password does not match criteria");
        }
        this.password = password;
        Clerk.allClerks.put(username, this);
    }

    public void setRole(final boolean isAdmin) {
        if (!isAdmin && this.isLastAdmin()) {
            throw new IllegalArgumentException("Cannot remove last admin");
        }
        this.isAdmin = isAdmin;
        Clerk.allClerks.put(username, this);
    }

    public void delete() {
        if (!this.canDelete(this.getUsername())) {
            throw new ClerkNotDeletableException("Clerk cannot be deleted");
        }
        allClerks.remove(this.getUsername());
    }

    private boolean isLastAdmin() {
        final long adminCount = allClerks.values().stream().filter(Clerk::isAdmin).count();
        return adminCount == 1 && this.isAdmin;
    }

    private boolean canDelete(final String username) {
        if (!allClerks.containsKey(username)) {
            throw new ClerkNotFoundException(username);
        }
        if (allClerks.get(username).isAdmin()) {
            return isLastAdmin();
        }
        return true;
    }

    public final boolean hasAttendedTraining() {
        return !attendedTrainings.isEmpty();
    }

    public void addAttendedTraining(final Training training) {
        attendedTrainings.put(training.getName(), training);
    }

    public void addCompletedTraining(final Training training) {
        if (!attendedTrainings.containsKey(training.getName())) {
            throw new TrainingNotAttendedException(training.getName());
        }
        attendedTrainings.remove(training.getName());
        completedTrainings.put(training.getName(), training);
    }

    public void removeAttendedTraining(final Training training) {
        if (!attendedTrainings.containsKey(training.getName())) {
            throw new TrainingNotAttendedException(training.getName());
        }
        attendedTrainings.remove(training.getName());
    }

    public void removeCompletedTraining(final Training training) {
        if (!completedTrainings.containsKey(training.getName())) {
            throw new TrainingNotCompletedException(training.getName());
        }
        completedTrainings.remove(training.getName());
    }
}