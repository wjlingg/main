package command;

import exception.DukeException;
import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import static common.Messages.*;

/**
 * Handles the event command and inherits all the fields and methods of Command parent class
 */
public class EventCommand extends Command {

    /**
     * Constructor for class EventCommand
     * @param userInputCommand String containing input command from user
     */
    public EventCommand(String userInputCommand) {
        this.userInputCommand = userInputCommand;
    }

    /**
     * Processes the event command to add event task to task list
     * @param taskList contains the task list
     * @param ui deals with interactions with the user
     * @param storage deals with loading tasks from the file and saving tasks in the file
     * @throws DukeException if Duke cannot recognize the user input or user inputs a wrong format for the description
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        if (userInputCommand.trim().equals(COMMAND_EVENT)) {
            throw new DukeException(ERROR_MESSAGE_EVENT);
        }else if(userInputCommand.trim().charAt(5) == ' '){
            String description = userInputCommand.trim().split("\\s",2)[1];
            if(description.contains(" /at ")){
                String details = description.trim().split(" /at ", 2)[0];
                String date = description.trim().split(" /at ", 2)[1];
                if(details == null || date == null){
                    throw new DukeException(ERROR_MESSAGE_EVENT);
                }else{
                    taskList.addEventTask(details, date);
                    storage.saveFile(taskList);
                }
            }else{
                throw new DukeException(ERROR_MESSAGE_EVENT);
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
