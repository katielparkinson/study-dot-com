package MiscLessonPractice.src;
public class MethodPracII {
    public static void main(String[] args){
        double startingSalary = 800.00;
        double salary = 200.00;
        double myNewSalary;
        System.out.println("Demonstrating some raises");
        myNewSalary = predictRaise(400.00);
        myNewSalary = predictRaise(salary);
        myNewSalary = predictRaise(startingSalary);
        System.out.println("Current Salary: " + salary + " After Raise: " + myNewSalary);
    }
    public static double predictRaise(double salary){
        final double raiseRate = 1.65;
        double newSalary = salary * raiseRate;
        System.out.println(newSalary);
        return newSalary;
        
    }
}
