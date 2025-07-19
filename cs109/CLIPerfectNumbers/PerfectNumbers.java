public class PerfectNumbers {
    // method for determining if user input is a perfect number
    public static void calcPerfectNum(long input) {
        // outer loop iterates through numbers 1 up to the user input
        for (long i = 1; i <= input; i++){
        // sum is initialized to 1 because we already know that 1 will be included in
        // our sum as it is a factor of all numbers
        long sum = 1;
        // loop to check what numbers between 1 and i are factors of i.
        // we don't need to check "1" because we know one is a divisor of all numbers.
        for (long j = 2; j < i; j++) {
            // if i is a factor of the user input it is added to sum.
            if (i % j == 0) {
                sum += j;
            }
        }
        // if the sum is equal to i then i is a perfect number
        // one is not a perfect number because it does not have any proper
        // divisors(divisors excluding the number itself)
        if (sum == i && sum != 1) {
            System.out.println(sum + " is a perfect number!");
        }
    }
}
}