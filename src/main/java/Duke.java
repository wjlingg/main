import java.util.Scanner;

public class Duke {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";
    private static final String COMMAND_EXIT_PROGRAM = "bye";
    private static final String DIVIDER = "   ____________________________________________________________\n";

    /**
     * Main entry point of the application.
     * Initializes the application and starts the interaction with the user.
     */
    public static void main(String[] args){
        showHelloMessage();
        while (true) {
            String userCommand = getUserInput();
            executeCommand(userCommand);
        }
    }

    /**
     * Display welcome message of the program
     */
    private static void showHelloMessage() {

        String logo =
                "      ___         _        \n"
                        + "     |  _ \\ _   _| | _____ \n"
                        + "     | | | | | | | |/ / _ \\\n"
                        + "     | |_| | |_| |   <  __/\n"
                        + "     |____/ \\__,_|_|\\_\\___|\n"
                        + "\n";

        System.out.println(
                DIVIDER + logo +
                        "     Hello! I'm Duke\n" +
                        "     What can I do for you?\n" +
                        DIVIDER
        );
    }

    /**
     * Executes the command as specified by the {@code userInputString}
     * Exit program as requested
     *
     * @param userInputString raw input from user
     */
    private static void executeCommand(String userInputString) {
        if (userInputString.trim().equals(COMMAND_EXIT_PROGRAM)) {
            System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
            System.exit(0);
        } else {
            System.out.println(DIVIDER + "      " + userInputString + "\n" + DIVIDER);
        }
    }

    /**
     * Reads the text entered by the user.
     *
     * @return full line entered by the user
     */
    private static String getUserInput() {
        String inputLine = SCANNER.nextLine();
        return inputLine;
    }
}