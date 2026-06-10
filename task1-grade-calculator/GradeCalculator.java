/**
 * Performs grade-related calculations for a student.
 *
 * This class provides methods to calculate:
 * - Total marks
 * - Average marks
 * - Letter grade based on the average
 *
 * Grade Scale:
 * A: 90-100
 * B: 75-89
 * C: 60-74
 * D: 45-59
 * F: Below 45
 *
 * @author Sneha Timsina
 */
public class GradeCalculator {

    /**
     * Calculates the total marks obtained across all subjects.
     *
     * @param marks array containing marks for 5 subjects
     * @return total marks
     */
    public double getTotal(double[] marks) {
        double total = 0;

        for (double i : marks) {
            total += i;
        }

        return total;
    }

    /**
     * Calculates the average mark across all subjects.
     *
     * @param marks array containing marks for 5 subjects
     * @return average mark
     */
    public double getAverage(double[] marks) {
        return (getTotal(marks) / 5);
    }

    /**
     * Assigns a letter grade based on the student's average mark.
     *
     * @param marks array containing marks for 5 subjects
     * @return the letter grade (A, B, C, D, or F)
     */
    public String getGrade(double[] marks) {

        double average = getAverage(marks);

        if (average >= 90) {
            return "A";
        } else if (average >= 75) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 45) {
            return "D";
        } else {
            return "F";
        }
    }
}