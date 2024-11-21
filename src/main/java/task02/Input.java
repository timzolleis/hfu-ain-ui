package task02;

import java.util.Scanner;

public class Input {
    public static String getString(final String inputHint) {
        System.out.println(inputHint);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Boolean getBoolean(final String inputHint) {
        System.out.println(inputHint);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }

    public static Integer getInteger(final String inputHint) {
        System.out.println(inputHint);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
