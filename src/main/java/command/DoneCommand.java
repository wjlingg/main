package command;

import exception.DukeException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import static common.Messages.*;

/**
 * Handles the done command and inherits all the fields and methods of Command parent class
 */
public class DoneCommand extends Command {

    /**
     * Constructor for class DoneCommand
     * @param userInputCommand input command from user
     */
    public DoneCommand(String userInputCommand) {
        this.userInputCommand = userInputCommand;
    }

    /**
     * Validate that user inputs an integer value for the index
     * @param input String containing integer input from user for the index
     * @return true if the user inputs an integer and false otherwise
     */
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Processes the done command to mark task as done in the task list
     * @param taskList contains the task list
     * @param ui deals with interactions with the user
     * @param storage deals with loading tasks from the file and saving tasks in the file
     * @throws DukeException if Duke cannot recognize the user input
     *                      or user inputs an invalid index or the list of tasks is empty
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        if (userInputCommand.trim().equals(COMMAND_DONE)) {
            throw new DukeException(ERROR_MESSAGE_EMPTY_INDEX + MESSAGE_FOLLOWUP_EMPTY_INDEX);
        }else if(userInputCommand.trim().charAt(4) == ' '){
            String description = userInputCommand.trim().split("\\s",2)[1];
            if(isParsable(description)){
                //converting string to integer
                int index = Integer.parseInt(description);
                if (index > taskList.getSize() || index <= 0) {
                    if (taskList.getSize() == 0) {
                        throw new DukeException(ERROR_MESSAGE_EMPTY_LIST);
                    } else {
                        throw new DukeException(ERROR_MESSAGE_INVALID_INDEX + taskList.getSize() + ".");
                    }
                } else {
                    taskList.doneTask(index - 1);
                    storage.saveFile(taskList);
                }
            }else{
                throw new DukeException(ERROR_MESSAGE_UNKNOWN_INDEX);
            }
        }else{
            throw new DukeException(ERROR_MESSAGE_RANDOM);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
