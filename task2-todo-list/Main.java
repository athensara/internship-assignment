/**
 * A simple console-based To-Do List application.
 *
 * Features:
 * - Add tasks
 * - View all tasks
 * - Mark tasks as completed
 * - Delete tasks
 * - Exit the application
 *
 * Tasks are stored in an ArrayList during program execution.
 *
 * @author Sneha Timsina
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    /**
     * Runs the To-Do List application and displays the menu.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Stores all tasks currently in memory
        ArrayList<Task> taskList = new ArrayList<>();
        String input = "0";
        Scanner scanner = new Scanner(System.in);

        // Continue showing the menu until the user chooses Exit
        while (!(input.equals("5"))) {

            System.out.println(
                "Your TO-DO List\nPress 1 to Add a Task, 2 to View all task, 3 to Mark as Done, 4 to Delete Task and 5 to EXIT "
            );

            input = scanner.nextLine();

            // Add a new task
            if (input.equals("1")) {

                System.out.println("Title of Task: ");
                String title = scanner.nextLine();

                System.out.println("Description: ");
                String description = scanner.nextLine();

                Task task = new Task(title, description);

                taskList.add(task);

                System.out.println("Task added successfully");
            }

            // View all tasks currently in the list
            else if (input.equals("2")) {

                if (taskList.size() > 0) {

                    // Display tasks using user-friendly numbering starting from 1
                    int i = 1;

                    for (Task task : taskList) {
                        System.out.println(i + " " + task);
                        i++;
                    }

                } else {

                    System.out.println("The Task List is empty");
                }
            }

            // Mark a task as completed
            else if (input.equals("3")) {

                System.out.println("Enter index of Task in TaskList that you completed: ");

                String numberStr = scanner.nextLine();

                try {

                    // Convert user input to ArrayList index
                    int index = Integer.parseInt(numberStr) - 1;

                    // Verify index exists in the list
                    if (index < taskList.size() && index >= 0) {

                        Task task = taskList.get(index);

                        task.setStatus("Completed");

                        System.out.println(task.getTitle() + " marked completed");

                    } else {

                        System.out.println("Task not Found. Back to main menu");
                    }

                } catch (NumberFormatException e) {

                    System.out.println("Please enter a valid number.");
                }
            }

            // Delete a task from the list
            else if (input.equals("4")) {

                System.out.println("Enter index of Task in TaskList you want to delete: ");

                String numberStr = scanner.nextLine();

                try {

                    // Convert user input to ArrayList index
                    int index = Integer.parseInt(numberStr) - 1;

                    // Verify index exists before removing
                    if (index < taskList.size() && index >= 0) {

                        Task task = taskList.remove(index);

                        System.out.println(task.getTitle() + " successfully deleted");

                    } else {

                        System.out.println("Task not Found. Back to main menu");
                    }

                } catch (NumberFormatException e) {

                    System.out.println("Please enter a valid number.");
                }
            }

            // Handle invalid menu options
            else if (!(input.equals("5"))) {

                System.out.println("Please enter a valid action.");
            }
        }
        
        // Close scanner before exiting program
        scanner.close();
    }
}