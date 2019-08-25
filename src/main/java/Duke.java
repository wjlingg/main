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
    private static final String MESSAGE_DELETE = "     Noted. I've removed this task:\n";
    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";

    private static final String ERROR_MESSAGE_TODO = "  ☹ OOPS!!! The description of a todo cannot be empty.\n";
    private static final String ERROR_MESSAGE_RANDOM = "  ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";


    private static final String COMMAND_GET_LIST = "list";
    private static final String COMMAND_MARKED_DONE = "done";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_EVENT = "event";
    private static final String COMMAND_DELETE = "delete";
    private static final String COMMAND_EXIT_PROGRAM = "bye";
    private static final String DIVIDER = "   ____________________________________________________________\n";

    /**
     * Main entry point of the application.
     * Initializes the application and starts the interaction with the user.
     */
    public static void main(String[] args) {
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
     * @param userInputString  raw input from user
     */
    private static void executeCommand(String userInputString) {
        if(userInputString.equals(COMMAND_GET_LIST)) {
            System.out.println(DIVIDER + MESSAGE_TASKED);
            for (int i = 0; i < myList.size(); i++) {
                final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
                System.out.println(
                        "     " + displayIndex + ". " + myList.get(i)
                );
            }
            System.out.println(DIVIDER);
        }else if(userInputString.equals(COMMAND_EXIT_PROGRAM)) {
            System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
            System.exit(0);
        }else{
            String[] command = userInputString.split("\\s", 2);
            String msg = "";
            String types = command[0]; //getting the type of task input
            String description = command[1]; //getting the details of the task
            if(types.equals(COMMAND_MARKED_DONE)) {
                //converting string to integer
                int index = Integer.parseInt(description);
                //marking targeted item as completed
                myList.get(index - 1).markAsDone();
                System.out.println(
                    DIVIDER + MESSAGE_MARKED +
                    "       " + myList.get(index - 1) + "\n" + DIVIDER
                );
            }else if(types.equals(COMMAND_TODO)){
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
            }else if(types.equals(COMMAND_DEADLINE)){
                String[] strDeadline = description.split(" /by ", 2);
                myList.add(new Deadline(strDeadline[0], strDeadline[1]));
                if(myList.size() == 1){
                    msg = " task in the list.\n";
                }else{
                    msg = MESSAGE_ITEMS2;
                }
                System.out.println(
                    DIVIDER + MESSAGE_ADDED +
                    "       " + myList.get(myList.size()-1) + "\n" + MESSAGE_ITEMS1 + myList.size() + msg +
                    DIVIDER
                );
            }else if(types.equals(COMMAND_EVENT)) {
                String[] strEvent = description.split(" /at ", 2);
                myList.add(new Event(strEvent[0], strEvent[1]));
                if (myList.size() == 1) {
                    msg = " task in the list.\n";
                } else {
                    msg = MESSAGE_ITEMS2;
                }
                System.out.println(
                    DIVIDER + MESSAGE_ADDED +
                    "       " + myList.get(myList.size() - 1) + "\n" + MESSAGE_ITEMS1 + myList.size() + msg +
                    DIVIDER
                );
            }else if(userInputString.contains(COMMAND_DELETE)) {
                int index = Integer.parseInt(description);
                Task removed = myList.get(index - 1);
                myList.remove(removed);
                System.out.println(
                    DIVIDER + MESSAGE_DELETE +
                    "       " + removed + "\n" + MESSAGE_ITEMS1 + myList.size() + MESSAGE_ITEMS2 +
                    DIVIDER
                );
            }
        }
    }

    /**
     * Reads the text entered by the user.
     *
     * @return full line entered by the user
     */
    private static String getUserInput() {
        String inputLine = SCANNER.nextLine();
        // silently consume all blank
        while (inputLine.trim().isEmpty()) {
            inputLine = SCANNER.nextLine();
        }
        return inputLine;
    }
}