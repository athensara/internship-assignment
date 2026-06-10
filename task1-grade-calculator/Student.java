/**
 * Represents a student and their marks.
 *
 * @author Sneha Timsina
 */
public class Student {

    private String name;
    private double[] marks;

    /**
     * Creates a Student object.
     *
     * @param name the student's name
     * @param marks array containing marks for 5 subjects
     */
    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    /**
     * Returns the student's name.
     *
     * @return student name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the student's marks.
     *
     * @return array of subject marks
     */
    public double[] getMarks() {
        return this.marks;
    }
}