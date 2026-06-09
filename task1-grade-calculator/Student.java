public class Student {
    String name;
    double[] marks;

    public Student (String name, double[] marks){
        this.name = name;
        this.marks = marks;
    }

    public String getName(){
        return this.name;
    }

    public double[] getMarks(){
        return this.marks;
    }
    
}
