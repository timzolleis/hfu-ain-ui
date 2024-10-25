package task02;

public class Select {
    public static void main(String[] args) {
        final String[] options = {"Option 1", "Option 2", "Option 3"};
        System.out.println(select(options));
    }

    static String select(final String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        boolean isRepeatedInput = false;
        while (true) {
            final String selection = Input.input(isRepeatedInput ? "Please repeat your input:" : "Please select an option by providing a number:");
            if (selection.isEmpty()) {
                isRepeatedInput = true;
                System.out.println("No input detected");
            } else if (!isNumber(selection)) {
                isRepeatedInput = true;
                System.out.println("Invalid input");
            } else if (!isValidIndex(Integer.parseInt(selection), options.length)) {
                isRepeatedInput = true;
                System.out.println("Invalid index");
            } else {
                return options[Integer.parseInt(selection) - 1];
            }
        }
    }

    private static boolean isValidIndex(final int index, final int length) {
        return index >= 0 && index < length;
    }


    private static boolean isNumber(final String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
