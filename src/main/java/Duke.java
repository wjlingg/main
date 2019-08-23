import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static final ArrayList<Task> myList = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";
    private static final String MESSAGE_MARKED = "     Nice! I've marked this task as done:\n";
    private static final String MESSAGE_TASKED = "     Here are the tasks in your list:";
    private static final String MESSAGE_ADDED = "     Got it. I've added this task:\n";
    private static final String MESSAGE_ITEMS1 = "     Now you have ";
    private static final String MESSAGE_ITEMS2 = " tasks in the list.\n";



    private static final String COMMAND_GET_LIST = "list";
    private static final String COMMAND_MARKED_DONE = "done";
    private static final String COMMAND_DEADLINE = "deadline";
    private static final String COMMAND_TODO = "todo";
    private static final String COMMAND_EVENT = "event";
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

        String logo = "      ___         _        \n"
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
        }else if(userInputString.contains(COMMAND_MARKED_DONE)) {
            try {
                //splitting the string into "done" and integer
                String[] arrOfStrDone = userInputString.split(" ", 2);
                //converting string to integer
                int index = Integer.parseInt(arrOfStrDone[1]);
                //marking targeted item as completed
                myList.get(index - 1).markAsDone();
                System.out.println(
                    DIVIDER + MESSAGE_MARKED +
                    "       " + myList.get(index - 1) + "\n" + DIVIDER
                );
            } catch (Exception e) {
                Task s = new Task(userInputString);
                myList.add(s);
                System.out.println(
                    DIVIDER +
                    "     added: " + userInputString + "\n" +
                    DIVIDER
                );
            }
        }else if(userInputString.contains(COMMAND_TODO)){
            String[] arrOfStrTodo = userInputString.split(" ", 2);
            String str = arrOfStrTodo[1];
            Task[] todo = new Task[100];
            todo[0] = new Todo(str);
            myList.add(todo[0]);
            int index = myList.size();
            String msg;
            if(index == 1){
                msg = " task in the list.\n";
            }else{
                msg = MESSAGE_ITEMS2;
            }
            System.out.println(
                DIVIDER + MESSAGE_ADDED +
                "       " + myList.get(index-1) + "\n" + MESSAGE_ITEMS1 + index + msg +
                DIVIDER
            );
        }else if(userInputString.contains(COMMAND_DEADLINE)){
            String[] arrOfStrDeadlineSlash = userInputString.split("/", 3);
            String str1 = arrOfStrDeadlineSlash[1];
            String[] arrOfStrSpace = arrOfStrDeadlineSlash[0].split("\\s", 2);
            String str2 = arrOfStrSpace[1];
            String date = "";
            if(str1.contains("by")){
                String[] arrSubString = str1.split("\\s", 2);
                date = arrSubString[1];
            }
            Task[] deadline = new Task[100];
            deadline[0] = new Deadline(str2, date);
            myList.add(deadline[0]);
            String msg;
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
        }else if(userInputString.contains(COMMAND_EVENT)) {
            String[] arrOfStrEventSlash = userInputString.split("/", 3);
            String str1 = arrOfStrEventSlash[1];
            String[] arrOfStrSpace = arrOfStrEventSlash[0].split("\\s", 2);
            String str2 = arrOfStrSpace[1];
            String date = "";
            if (str1.contains("at")) {
                String[] arrSubString = str1.split("\\s", 2);
                date = arrSubString[1];
            }
            Task[] event = new Task[100];
            event[0] = new Event(str2, date);
            myList.add(event[0]);
            String msg;
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
     * Reads the text entered by the user.
     *
     * @return full line entered by the user
     */
    private static String getUserInput() {
        String inputLine = SCANNER.nextLine();
        Task t = new Task(inputLine);
        if (!inputLine.equals(COMMAND_GET_LIST) && !inputLine.contains(COMMAND_MARKED_DONE)
                && !inputLine.contains(COMMAND_TODO) && !inputLine.contains(COMMAND_DEADLINE)
                && !inputLine.contains(COMMAND_EVENT)) {
            myList.add(t);
        }
        // silently consume all blank
        while (inputLine.trim().isEmpty()) {
            inputLine = SCANNER.nextLine();
        }
        return inputLine;
    }
}