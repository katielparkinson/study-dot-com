package MiscLessonPractice.src;
public class MathsMeth {

    public static void main(String[] args) {
        double tester = 4.00;
        System.out.println("The factorial of " + tester + " = " + calcFactorial(tester));
        TowerOfHanoi tower = new TowerOfHanoi();
        int disks = 3;
        tower.solvePuzzle(disks, "Peg 1", "Peg 2", "Peg 3");
        System.out.println('\n');
        System.out.println("***** FIBONACCI SERIES ***** \n");
        int count = 15;
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.print(a + " " + b);
        printFibonacci(count - 2, c, b, a);
        System.out.println(" ");
    }

    // next add the calcFactorial method; the method that calls itself
    public static double calcFactorial(double input) {
        if (input == 1.0) {
            return 1.0;
        }
        return input * calcFactorial(input - 1.0);
    }

    static void printFibonacci(int count, int c, int b, int a) {
        if (count > 0) {
            c = b + a;
            a = b;
            b = c;
            System.out.print(" " + c);
            printFibonacci(count - 1, c, b, a);
        }
    }

    public static class TowerOfHanoi {
        public void solvePuzzle(int n, String begin, String temp, String end) {
            if (n == 1) {
                System.out.println(begin + " ---> " + end);
            } else {
                solvePuzzle(n - 1, begin, end, temp);
                System.out.println(begin + " ---> " + end);
                solvePuzzle(n - 1, temp, begin, end);
            }
        }
    }
}
