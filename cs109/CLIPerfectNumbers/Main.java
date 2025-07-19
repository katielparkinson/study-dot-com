/*
 * The purpose of this program is to identify perfect numbers between 1 and 200. 
 * It will also allow a user to enter an integer and then tell them if it is a perfect number.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);
        boolean another;
        // determining perfect numbers between 1 and 200
        System.out.println("The perfect numbers between 1 and 200 are:");
        // calling calcPerfectNum method with an input of 200 to find perfect numbers up
        // to the limit of 200. 
        PerfectNumbers.calcPerfectNum(200);
        do {
            // prompt user to enter an integer to check for perfect number
            System.out.println("Hello, let's identify the perfect numbers up to a new limit!");
            System.out.println("Please enter a positive number for the upper limit.");
            // check that user input is an integer
            long userNumInput = validateInputLong(input);
            // if user input is an integer then call the calcPerfectNum method to check for
            // perfect number
            PerfectNumbers.calcPerfectNum(userNumInput);
            // see if user would like to check another number
            System.out.println("Would you like to check numbers up to a different limit? \"yes\" or \"no\"");
            another = validateYesNoInput(input);
        } while (another);
        System.out.println("Goodbye!");
        // close the scanner to prevent resource leaks
        input.close();
    }

    // method to check that input was valid. only "yes" or "no" are valid inputs
    public static boolean validateYesNoInput(Scanner input) {
        String yesNo;
        // using a do-while loop so the input is checked at least once
        do {
            /*
             * storing input as yesNo and using trim and toLowerCase to eliminate any spaces
             * before or after response and accept yes or no inputs that may not have been
             * all lowercase by converting input to lowercase before check
             */
            yesNo = input.next().trim().toLowerCase();
            switch (yesNo) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    // if the input was invalid prompt the user to enter a number again
                    System.out.println("Sorry, That was an invalid input. Please enter \"yes\" or \"no\".");
            }
            // This can just be set to true because the only time this will have a chance to
            // run is when the default case is hit.
            // The default case only runs when the input is invalid.
        } while (true);
    }

    // method to check that the input was valid. The loop will continue as long as
    // the input is invalid(not an integer and/or negative)
    public static long validateInputLong(Scanner input) {
        long numberInput;
        // using a do-while loop so the input is checked at least once
        do {
            // this checks for input mismatch errors(was it a double and it wasn't too big)
            while (!input.hasNextLong()) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input or the number was too large.");
                // consume invalid token
                input.next();
            }
            numberInput = input.nextLong();
            // this checks that the input is a positive number
            if (numberInput <= 0) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a positive number.");
            }
            // loop will continue as long as the integer is less than or equal to 0
        } while (numberInput <= 0);
        // valid input is returned to the method that called it
        return numberInput;
    }
}
