package command;

import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

/**
 * Handles the bye command and inherits all the fields and methods of Command parent class
 */
public class ByeCommand extends Command {

    /**
     * Display the exit message and the program
     * @param taskList contains the task list
     * @param ui deals with interactions with the user
     * @param storage deals with loading tasks from the file and saving tasks in the file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showGoodbye();
        isExit();
    }

    /**
     * A flag to raise a request to exit the program
     * @return true if user wants to exit the program
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
