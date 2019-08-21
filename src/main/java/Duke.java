import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final ArrayList<Task> myList = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";
    private static final String MESSAGE_MARKED = "     Nice! I've marked this task as done:\n";
    private static final String MESSAGE_TASKED = "     Here are the tasks in your list:\n";

    private static final String COMMAND_GET_LIST = "list";
    private static final String COMMAND_MARKED_DONE = "done";
    private static final String COMMAND_EXIT_PROGRAM = "bye";
    private static final String DIVIDER = "   ____________________________________________________________\n";

    /**
     * Main entry point of the application.
     * Initializes the application and starts the interaction with the user.
     */
    public static void main(String[] args) {
        showLogo();
        showHelloMessage();
        while (true) {
            String userCommand = getUserInput();
            executeCommand(userCommand);
        }
    }

    /**
     * Display logo of the program
     */
    private static void showLogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Display welcome message of the program
     */
    private static void showHelloMessage() {
        System.out.println(
            DIVIDER +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            DIVIDER
        );
    }

    /**
     * Executes the command as specified by the {@code userInputString}
     * Adding items to the list
     * Display items in the list
     * Mark items in the list as completed
     * Exit program as requested
     *
     * @param userInputString  raw input from user
     */
    private static void executeCommand(String userInputString) {
        if(userInputString.equals(COMMAND_GET_LIST)) {
            System.out.println(DIVIDER + MESSAGE_TASKED);
            for (int i = 0; i < myList.size(); i++) {
                final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
                System.out.println(
                    "     " + displayIndex + ". [" + myList.get(i).getStatusIcon() + "] "
                            + myList.get(i).description
                );
            }
            System.out.println(DIVIDER);
        }else if(userInputString.contains(COMMAND_MARKED_DONE)){
            //splitting the string into "done" and integer
            String[] arrOfStr = userInputString.split(" ", 2);
            //converting string to integer
            int index = Integer.parseInt(arrOfStr[1]);
            //marking targeted item as completed
            myList.get(index - 1).markAsDone();
            System.out.println(
                DIVIDER + MESSAGE_MARKED +
                "       [" + myList.get(index - 1).getStatusIcon() + "] "
                        + myList.get(index - 1).description + "\n" + DIVIDER
            );
        }else if(userInputString.equals(COMMAND_EXIT_PROGRAM)){
            System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
            System.exit(0);
        }else{
            System.out.println(
                DIVIDER +
                "     added: " + userInputString + "\n" +
                DIVIDER
            );
        }
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     *
     * @return full line entered by the user
     */
    private static String getUserInput() {
        String inputLine = SCANNER.nextLine();
        Task t = new Task(inputLine);
        if (!inputLine.equals(COMMAND_GET_LIST) && !inputLine.contains(COMMAND_MARKED_DONE)) {
            myList.add(t);
        }
        // silently consume all blank
        while (inputLine.trim().isEmpty()) {
            inputLine = SCANNER.nextLine();
        }
        return inputLine;
    }
}