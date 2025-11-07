package cs201.CLIStringSearch;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);
        int userMenuChoice;
        System.out.println("Welcome to the String Search program.");

        // Menu Options
        // using a do while loop to ensure that the user can continue to select menu
        // options until they select 3. Exit Program
        do {
            System.out.println("Please choose from the menu options below:");
            System.out.println("1. Display the text");
            System.out.println("2. Search");
            System.out.println("3. Exit Program");
            userMenuChoice = validateUserMenuChoice(input);

            switch (userMenuChoice) {
                case 1:
                    // Display the names of 50 states in the USA.
                    StringSearchMenuHelper.displayStates();

                    break;

                case 2:
                    String needleString;
                    // using a do-while loop because I don't want users to search for the delimiter
                    // or nothing
                    do {
                        // prompt user for needle.
                        System.out.println("Please enter part of a state name to search for.");
                        // store user input
                        needleString = input.nextLine();
                        if (needleString.isEmpty() || needleString.contains("|")) {
                            System.out.println("Invalid input: cannot be empty or contain '|'.");
                        }
                    } while (needleString.isEmpty() || needleString.contains("|"));
                    // convert user input and stringStates from string to character array
                    // converting to lowercase as well as I don't want to search to be case
                    // sensitive
                    char[] needleLower = needleString.toLowerCase().toCharArray();
                    char[] haystackLower = StringSearchMenuHelper.stringStates.toLowerCase().toCharArray();
                    // call boyerMooreSearch method with user input
                    List<Integer> matches = StringSearchMenuHelper.boyerMooreSearch(haystackLower,
                            needleLower);
                    if (matches.isEmpty()) {
                        System.out.println("Sorry, no matches were found.");
                    } else {
                        System.out.println("Matches at indices: " + matches);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the program. Goodbye!");
                    break;
            }
        } while (userMenuChoice != 3);
        input.close();
    }

    // method to check that the menu choice was valid. The loop will continue as
    // long as the input is invalid(number not 1-3)
    public static int validateUserMenuChoice(Scanner input) {
        int choice;
        // using a do-while loop so the input is checked at least once
        do {
            while (!input.hasNextInt()) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a value between 1 and 3.");
                // consume invalid token
                input.next();
            }
            choice = input.nextInt();
            // clear leftover newline
            input.nextLine();
            if (choice <= 0 || choice > 3) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a value between 1 and 3.");
            }
            // loop will continue if input is not 1-3
        } while (choice <= 0 || choice > 3);
        // valid input is returned to the method that called it
        return choice;
    }
}