package command;

import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

import static common.Messages.MESSAGE_TASKED;

/**
 * Handles the list command and inherits all the fields and methods of Command parent class
 */
public class ListCommand extends Command {

    /**
     * Constructor for class ListCommand
     * @param userInputCommand String containing input command from user
     */
    public ListCommand(String userInputCommand) {
        this.userInputCommand = userInputCommand;
    }

    /**
     * Processes the list command to display all tasks in task list
     * @param taskList contains the task list
     * @param ui deals with interactions with the user
     * @param storage deals with loading tasks from the file and saving tasks in the file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        System.out.println(MESSAGE_TASKED);
        for (int i = 0; i < taskList.listTask().size(); i++){
            System.out.println(taskList.listTask().get(i));
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
