package task04;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Clerk {
    private final String username;
    private final String password;
    private final boolean isAdmin;
    private final Map<String, Training> completedTrainings = new HashMap<>();
    private final Map<String, Training> attendedTrainings = new HashMap<>();
    public static Map<String, Clerk> allClerks;

    public Clerk(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    public static String[] getAllNames() {
        return allClerks.keySet().toArray(String[]::new);
    }

    public void add(final Clerk clerk) {
        allClerks.put(clerk.getUsername(), clerk);
    }

    public void delete(final String clerkName) {
        if (!allClerks.containsKey(clerkName)) {
            throw new IllegalArgumentException("Clerk not found");
        }
        allClerks.remove(clerkName);
    }

    public static Clerk getClerk(final String clerkName) {
        if (!allClerks.containsKey(clerkName)) {
            throw new NoSuchElementException("Clerk not found");
        }
        return allClerks.get(clerkName);
    }

    public static boolean usernameExists(final String username) {
        return allClerks.containsKey(username);
    }

    public static boolean passwordMatches(final String username, final String password) {
        return allClerks.get(username).getPassword().equals(password);
    }

    public static boolean hasClerk() {
        return !allClerks.isEmpty();
    }

    public static boolean canDelete(final String username) {
        if (!allClerks.containsKey(username)) {
            throw new NoSuchElementException("Clerk not found");
        }
        if (allClerks.get(username).isAdmin()) {
            final long adminCount = allClerks.values().stream().filter(Clerk::isAdmin).count();
            return adminCount > 1;
        }
        return true;
    }

    public static boolean hasAdmin() {
        return allClerks.values().stream().anyMatch(Clerk::isAdmin);
    }

    public final boolean hasAttendedTraining() {
        return !attendedTrainings.isEmpty();
    }

    public void addAttendedTraining(final Training training) {
        attendedTrainings.put(training.getName(), training);
    }

    public void addCompletedTraining(final Training training) {
        if (!attendedTrainings.containsKey(training.getName())) {
            throw new IllegalArgumentException("Training not attended");
        }
        completedTrainings.put(training.getName(), training);
    }


}
