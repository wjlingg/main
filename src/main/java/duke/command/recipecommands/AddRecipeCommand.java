package duke.command.recipecommands;

import duke.command.Command;
import duke.list.recipelist.RecipeList;
import duke.storage.RecipeStorage;
import duke.task.recipetasks.RecipeTitle;
import duke.ui.Ui;

import java.text.ParseException;
import java.util.ArrayList;

import static duke.common.Messages.*;
import static duke.common.RecipeMessages.*;

public class AddRecipeCommand extends Command<RecipeList, Ui, RecipeStorage> { // need to settle the problem of duplicate recipes.

    public AddRecipeCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public ArrayList<String> execute(RecipeList recipeList, Ui ui, RecipeStorage recipeStorage) throws ParseException {
        ArrayList<String> arrayList = new ArrayList<>();
        if (userInput.trim().equals(COMMAND_ADD_RECIPE)) {
            arrayList.add(ERROR_MESSAGE_GENERAL + MESSAGE_FOLLOWUP_NUll);
            System.out.println("stuck here 7");
        } else if (userInput.trim().charAt(9) == ' ') {
            String description = userInput.split("\\s", 2)[1].trim();
            if (description.contains(" ")) {
                String recipeIndex = description.split("\\s", 2)[0].trim();
                System.out.println("this is the recipe index: " + recipeIndex);
                if (isParsableInt(recipeIndex)) {
                    String title = description.split("\\s", 2)[1].trim();
                    System.out.println("1this is the recipe title: " + title);
                    RecipeTitle recipeTitle = new RecipeTitle(Integer.parseInt(recipeIndex), title);
                    System.out.println("2this is the recipe index: " + recipeTitle.getIndex());
                    System.out.println("3this is the recipe title: " + recipeTitle.getTitle());
                    recipeList.addRecipe(recipeTitle);
                    recipeStorage.saveFile(recipeList);
                    arrayList.add(MESSAGE_RECIPE_ADDED + "       " + description + "\n" + "Now you have " + recipeList.getSize() + " recipe(s) in the list.");
                } else {
                    arrayList.add(ERROR_MESSAGE_INVALID_RECIPE_FORMAT);
                }
            } else {
                arrayList.add(ERROR_MESSAGE_INVALID_RECIPE_FORMAT);
            }
        } else {
            arrayList.add(ERROR_MESSAGE_RANDOM);
        }
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
