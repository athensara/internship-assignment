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
        double total = getAverage(marks);
        if (total>=90 && total<=100){
            return ("A");
        }
        else if (total>=75 && total<=89){
            return("B");
        }
        else if (total>=60 && total<=74){
            return("C");
        }
        else if (total>=45 && total<=59){
            return("D");
        }
        else {
            return("F");
        }
    }
    
}
