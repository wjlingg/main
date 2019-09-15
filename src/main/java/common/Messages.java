package common;

/**
 * A class to store all the initialisation of the static error messages to String value
 */
public class Messages {

    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public static final String filePath = "C:\\Users\\Wen Jian\\Desktop\\duke\\src\\main\\data\\duke.txt";

    public static final String MESSAGE_ADDED = "     Got it. I've added this task:\n";
    public static final String MESSAGE_BYE = "     Bye. Hope to see you again soon!";
    public static final String MESSAGE_DELETE = "     Noted. I've removed this task:\n";
    public static final String MESSAGE_FIND = "     Here are the matching tasks in your list:";
    public static final String MESSAGE_FOLLOWUP_EMPTY_INDEX = "       Kindly enter the command again with an index.";
    public static final String MESSAGE_FOLLOWUP_NUll = "       Kindly enter the command again with a description.";
    public static final String MESSAGE_ITEMS1 = "     Now you have ";
    public static final String MESSAGE_ITEMS2 = " tasks in the list.";
    public static final String MESSAGE_MARKED = "     Nice! I've marked this task as done:\n";
    public static final String MESSAGE_TASKED = "     Here are the tasks in your list:";

    public static final String ERROR_MESSAGE_DEADLINE = "       ☹ OOPS!!! Please specify the deadline in this format: \n         deadline [event description] /by [day/month/year time]\n         Eg: 28/8/2019 2359 (For date and time format)";
    public static final String ERROR_MESSAGE_EMPTY_INDEX = "       ☹ OOPS!!! The index cannot be empty.\n";
    public static final String ERROR_MESSAGE_EMPTY_LIST = "       ☹ OOPS!!! The list is empty.\n       Kindly add a task.";
    public static final String ERROR_MESSAGE_EVENT = "       ☹ OOPS!!! Please specify the event details in this format: \n         event [event description] /at [event time or venue]";
    public static final String ERROR_MESSAGE_GENERAL = "       ☹ OOPS!!! The description cannot be empty.\n";
    public static final String ERROR_MESSAGE_INVALID_DATE = "       ☹ OOPS!!! Please specify the date and time in this format: \n         [day/month/year time] Eg: 28/8/2019 2359";
    public static final String ERROR_MESSAGE_INVALID_INDEX = "     Invalid index entered.\n     Kindly enter command with index not more than ";
    public static final String ERROR_MESSAGE_UNKNOWN_INDEX = "     Unknown index entered.\n     Kindly enter an integer for the index.";
    public static final String ERROR_MESSAGE_LOADING = "     ☹ OOPS!!! Error loading file: ";
    public static final String ERROR_MESSAGE_NOTFOUND = "     ☹ OOPS!!! I'm sorry, but there is no matching tasks in your list.";
    public static final String ERROR_MESSAGE_RANDOM = "     ☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static final String COMMAND_BYE = "bye";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_EVENT = "event";
    public static final String COMMAND_FIND = "find";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_TODO = "todo";
    public static final String DIVIDER = "   ____________________________________________________________\n";
}
