/**
 * Represents a task in the To-Do List application.
 *
 * Each task contains a title, description, and status.
 *
 * @author Sneha Timsina
 */
public class Task {
    //initialize instance variables
    private String title;
    private String description;
    private String status;

    /**
     * Creates a new task with a title and description.
     * The default status of a new task is "Pending".
     *
     * @param title the title of the task
     * @param description a brief description of the task
     */
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = "Pending";
    }

    /**
     * Returns the title of the task.
     *
     * @return the task title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the status of the task.
     *
     * @param newStatus the new status to assign to the task
     */
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    /**
     * Returns a formatted String representation of the task.
     *
     * @return formatted task information
     */
    @Override
    public String toString() {
        return (title + " : " + description + " [ " + status + " ]");
    }
}