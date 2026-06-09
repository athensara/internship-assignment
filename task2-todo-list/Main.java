import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        String input = "0";
        Scanner scanner = new Scanner(System.in);
        while (!(input.equals("5"))) {
            System.out.println(
                    "Your TO-DO List\nPress 1 to Add a Task, 2 to View all task, 3 to Mark as Done, 4 to Delete Task and 5 to EXIT ");
            input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Title of Task: ");
                String title = scanner.nextLine();
                System.out.println("Description: ");
                String description = scanner.nextLine();
                Task task = new Task(title, description);
                taskList.add(task);
                System.out.println("Task added successfully");

            }

            else if (input.equals("2")) {
                if (taskList.size() > 0) {
                    int i = 1;
                    for (Task task : taskList) {
                        System.out.println(i + " " + task.toString());
                        i++;
                    }

                } else {
                    System.out.println("The Task List is empty");
                }
            }

            else if (input.equals("3")) {
                System.out.println("Enter index of Task in TaskList that you completed: ");
                String numberStr = scanner.nextLine();
                try {
                    int index = Integer.parseInt(numberStr) - 1;
                    if (index < taskList.size() && index >= 0) {
                        Task task = taskList.get(index);
                        task.setStatus("Completed");
                        System.out.println(task.getTitle() + " marked completed");
                    } else {
                        System.out.println("Invalid action. Back to main menu");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            else if (input.equals("4")) {
                System.out.println("Enter index of Task in TaskList you want to delete: ");
                String numberStr = scanner.nextLine();
                try {
                    int index = Integer.parseInt(numberStr) - 1;

                    if (index < taskList.size() && index >= 0) {
                        Task task = taskList.remove(index);
                        System.out.println(task.getTitle() + " successfully deleted");
                    } else {
                        System.out.println("Invalid action. Back to main menu");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }

            }

            else if (!(input.equals("5"))) {
                System.out.println("Invalid action. Back to main menu");
            }
        }
        scanner.close();

    }

}
