public class GradeCalculator {
    public double getTotal(double[] marks){
        double total = 0;
        for (double i : marks){
            total += i;
        }
        return total;
    }

    public double getAverage(double[] marks){
        return (getTotal(marks)/5);
    }

    public String getGrade(double[] marks){
        double average = getAverage(marks);
        if (average>=90){
            return ("A");
        }
        else if (average>=75){
            return("B");
        }
        else if (average>=60){
            return("C");
        }
        else if (average>=45){
            return("D");
        }
        else {
            return("F");
        }
    }
    
}
