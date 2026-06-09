import java.util.Scanner; // Import the Scanner class
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object connected to standard input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        double[] marks = new double[5];

        for (int i = 1; i <= 5; i++) {
            boolean condition = true;
            while (condition) {
                System.out.print("Enter marks in Subject " + i + " (0-100): ");
                double subMark = scanner.nextInt();
                if (!(subMark <= 100 && subMark >= 0)) {
                    condition = true;
                    System.out.println("Invalid marks, enter within range (0-100)");
                } else {
                    condition = false;
                    marks[i-1]= subMark; 
                }

            }
        }

        Student student = new Student(name, marks);
        GradeCalculator calculate = new GradeCalculator();

        System.out.println(" Your individual subject marks in 5 subjects: " + Arrays.toString(student.getMarks()));
        System.out.println(" Total marks: " + calculate.getTotal(student.getMarks()));
        System.out.println(" Average marks: " + calculate.getAverage(student.getMarks()));
        System.out.println(" Final Grade: " + calculate.getGrade(student.getMarks()));

        scanner.close();
    }
}
