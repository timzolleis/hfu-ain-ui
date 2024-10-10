package task02;

import java.util.Scanner;

public class Input {
    static String input(final String inputHint) {
        System.out.println(inputHint);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
