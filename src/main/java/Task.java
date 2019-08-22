public class Task {
    protected String description; //User input
    protected boolean isDone; //To check if the task is completed

    public Task(String description) {
        this.description = description; //user input string
        this.isDone = false; //initially marked as not completed
    }

    public void markAsDone(){
        isDone = true;
    } //marked as completed when done

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
}