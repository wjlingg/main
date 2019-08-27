import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final ArrayList<Task> myList = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    private static final String MESSAGE_TASKED = "     Here are the tasks in your list:";
    private static final String MESSAGE_MARKED = "     Nice! I've marked this task as done:\n";
    private static final String MESSAGE_ADDED = "     Got it. I've added this task:\n";
    private static final String MESSAGE_ITEMS1 = "     Now you have ";
    private static final String MESSAGE_ITEMS2 = " tasks in the list.\n";
    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_DONE = "done";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_EVENT = "event";
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
     * Adding items to the list
     * Display items in the list
     * Mark items in the list as completed
     * Exit program as requested
     *
     * @param userInputString raw input from user
     */
    private static void executeCommand(String userInputString) {
        if(userInputString.trim().equals(COMMAND_LIST)) {
            System.out.println(DIVIDER + MESSAGE_TASKED);
            for (int i = 0; i < myList.size(); i++) {
                final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
                System.out.println(
                        "     " + displayIndex + ". " + myList.get(i)
                );
            }
            System.out.println(DIVIDER);
        }else if (userInputString.trim().equals(COMMAND_EXIT_PROGRAM)) {
            System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
            System.exit(0);
        }else if(userInputString.contains(COMMAND_DONE)) {
            commandDone(userInputString);
        }else if(userInputString.contains(COMMAND_TODO)){
            commandTodo(userInputString);
        }else if(userInputString.contains(COMMAND_DEADLINE)){
            commandDeadline(userInputString);
        }else if(userInputString.contains(COMMAND_EVENT)){
            commandEvent(userInputString);
        }
    }

    private static void commandDone(String userInputString) {
        String description = userInputString.split("\\s",2)[1];
        //converting string to integer
        int index = Integer.parseInt(description);
        //marking targeted item as completed
        myList.get(index - 1).markAsDone();
        System.out.println(
                DIVIDER + MESSAGE_MARKED +
                        "       " + myList.get(index - 1) + "\n" + DIVIDER
        );
    }

    private static void commandTodo(String userInputString){
        String msg = "";
        String description = userInputString.split("\\s",2)[1];
        myList.add(new Todo(description));
        int index = myList.size();
        if (index == 1) {
            msg = " task in the list.\n";
        } else {
            msg = MESSAGE_ITEMS2;
        }
        System.out.println(
                DIVIDER + MESSAGE_ADDED +
                        "       " + myList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg +
                        DIVIDER
        );

    }

    private static void commandDeadline(String userInputString){
        String msg = "";
        String description = userInputString.split("\\s",2)[1];
        String details = description.split(" /by ",2)[0];
        String date = description.split(" /by ",2)[1];
        myList.add(new Deadline(details, date));
        int index = myList.size();
        if (index == 1) {
            msg = " task in the list.\n";
        } else {
            msg = MESSAGE_ITEMS2;
        }
        System.out.println(
                DIVIDER + MESSAGE_ADDED +
                        "       " + myList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg +
                        DIVIDER
        );
    }

    private static void commandEvent(String userInputString){
        String msg = "";
        String description = userInputString.split("\\s",2)[1];
        String details = description.split(" /at ",2)[0];
        String date = description.split(" /at ",2)[1];
        myList.add(new Event(details, date));
        int index = myList.size();
        if (index == 1) {
            msg = " task in the list.\n";
        } else {
            msg = MESSAGE_ITEMS2;
        }
        System.out.println(
                DIVIDER + MESSAGE_ADDED +
                        "       " + myList.get(index - 1) + "\n" + MESSAGE_ITEMS1 + index + msg +
                        DIVIDER
        );
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