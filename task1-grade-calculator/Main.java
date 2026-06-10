/**
 * Student Grade Calculator Application.
 *
 * The program calculates and displays:
 * - Individual subject marks
 * - Total marks
 * - Average marks
 * - Final letter grade
 * from user input.
 *
 * @author Sneha Timsina
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Array to store marks for 5 subjects
        double[] marks = new double[5];

        // Collect marks for each subject
        for (int i = 1; i <= 5; i++) {

            // Continue prompting until valid marks are entered
            boolean condition = true;

            while (condition) {

                System.out.print("Enter marks in Subject " + i + " (0-100): ");

                double subMark = scanner.nextInt();

                // Validate that marks are within the allowed range
                if (!(subMark <= 100 && subMark >= 0)) {

                    System.out.println("Invalid marks, enter within range (0-100)");

                } else {

                    // Store valid marks in the array
                    marks[i - 1] = subMark;
                    condition = false;
                }
            }
        }

        // Create objects for the student and grade calculations
        Student student = new Student(name, marks);
        GradeCalculator calculate = new GradeCalculator();

        // Display the student's results
        System.out.println(" Your individual subject marks in 5 subjects: " + Arrays.toString(student.getMarks()));
        System.out.println(" Total marks: " + calculate.getTotal(student.getMarks()));
        System.out.println(" Average marks: " + calculate.getAverage(student.getMarks()));
        System.out.println(" Final Grade for " + student.getName()+ " is " + calculate.getGrade(student.getMarks()));

        // Close scanner to release system resources
        scanner.close();
    }
}