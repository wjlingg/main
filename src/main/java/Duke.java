import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static final ArrayList<String> myList = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char INPUT_COMMENT_MARKER = '#';

    private static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!\n";

    private static final String COMMAND_GET_LIST = "list";
    private static final String COMMAND_EXIT_PROGRAM = "bye";
    private static final int DISPLAYED_INDEX_OFFSET = 1;
    private static final String DIVIDER = "   ____________________________________________________________\n";


    public static void main(String[] args) {
        showLogo();
        showHelloMessage();
        while (true) {
            String userCommand = getUserInput();
            executeCommand(userCommand);
        }
    }

    private static void showLogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    private static void showHelloMessage() {
        System.out.println(
            DIVIDER +
            "     Hello! I'm Duke\n" +
            "     What can I do for you?\n" +
            DIVIDER
        );
    }

//    private static void echoUserCommand(String userCommand) {
//        System.out.println(
//            DIVIDER +
//            "     " + userCommand + "\n" +
//            DIVIDER
//        );
//    }

    private static void executeCommand(String userInputString) {
        if(userInputString.equals(COMMAND_GET_LIST)){
            System.out.println(DIVIDER);
            for (int i = 0; i < myList.size(); i++) {
                final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
                System.out.println(
                        "     " + displayIndex + ". " + myList.get(i)
                );
            }
            System.out.println(DIVIDER);
        }else if(userInputString.equals(COMMAND_EXIT_PROGRAM)){
            System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
            System.exit(0);
        }else{
            System.out.println(
                DIVIDER +
                "     " + userInputString + "\n" +
                DIVIDER
            );
        }
//        switch (userInputString) {
//            case COMMAND_GET_LIST:
//                System.out.println(DIVIDER);
//                for (int i = 0; i < myList.size(); i++) {
//                    final int displayIndex = i + DISPLAYED_INDEX_OFFSET;
//                    System.out.println(
//                            "     " + displayIndex + ". " + myList.get(i)
//                    );
//                }
//                System.out.println(DIVIDER);
//            case COMMAND_EXIT_PROGRAM:
//                System.out.println(DIVIDER + MESSAGE_BYE + DIVIDER);
//                System.exit(0);
//                // Fallthrough
//            default:
//                System.out.println(
//                    DIVIDER +
//                    "     " + userInputString + "\n" +
//                    DIVIDER
//                );
//        }
    }

    private static String getUserInput() {
        //System.out.print(LINE_PREFIX + "Enter command: ");
        String inputLine = SCANNER.nextLine();
        if (!inputLine.equals(COMMAND_GET_LIST)) {
            myList.add(inputLine);
        }
        // silently consume all blank
        while (inputLine.trim().isEmpty()) {
            inputLine = SCANNER.nextLine();
        }
        return inputLine;
    }
}