package duke.logic.command.recipecommands;

import duke.logic.command.Command;
import duke.model.list.recipelist.RecipeList;
import duke.storage.RecipeStorage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Handles the list command and inherits all the fields and methods of Command parent class.
 */
public class ListRecipeIngredientCommand extends Command<RecipeList, Ui, RecipeStorage> {

    /**
     * Constructor for class ListCommand.
     * @param userInput String containing input command from user
     */
    public ListRecipeIngredientCommand(String userInput) {
        this.userInput = userInput;
    }

    public ArrayList<String> execute(RecipeList recipeIngredientList, Ui ui, RecipeStorage recipeIngredientStorage) {
        ArrayList<String> arrayList = new ArrayList<>();
//        if (userInput.trim().equals(COMMAND_LIST_RECIPE_INGREDIENT)) {
//            arrayList.add(ERROR_MESSAGE_GENERAL + MESSAGE_FOLLOWUP_NUll);
//            System.out.println("stuck here1");
//        } else if (userInput.trim().charAt(14) == ' ') {
//            String title = userInput.split("\\s", 2)[1];
//            arrayList.add(MESSAGE_TASKED);
//            for (Recipe recipe : recipeIngredientList.getRecipeIngredientList()) {
//                if (recipe.getRecipeTitle().equals(title)) {
//                    arrayList.add(recipeIngredient.toString());
//                }
//            }
//        } else {
//            arrayList.add(ERROR_MESSAGE_RANDOM);
//        }
        return arrayList;
    }

    private static boolean isParsableInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}