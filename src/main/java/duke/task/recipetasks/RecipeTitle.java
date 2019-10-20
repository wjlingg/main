package duke.task.recipetasks;

public class RecipeTitle {

    private String recipeTitle;
    private int index;

    public RecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public RecipeTitle(int index, String recipeTitle) {
        this.recipeTitle = recipeTitle;
        this.index = index;
    }

    public int getIndex() {
        System.out.println("this is the recipe index: " + index);
        return this.index;
    }

    public String getTitle() {
        System.out.println("this is the recipe title: " + recipeTitle);
        return this.recipeTitle;
    }

    public String toSaveString() {
        return index + " | " + recipeTitle;
    }

    public String toString() {
        return "[" + index + "]" + "[Recipe Title: " + recipeTitle + "]";
    }
}
