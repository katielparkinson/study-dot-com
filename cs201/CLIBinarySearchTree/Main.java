import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);
        // use a boolean for treecreated that is initially set to false and isn't set to
        // true until the default tree is created. All other methods or menu options
        // will check to see that treecreated is set to true before they run.
        boolean treeCreated = false;
        int userMenuChoice;
        System.out.println("Welcome to the Binary Search Tree program.");
        // Menu Options
        // using a do while loop to ensure that the user can continue to select menu
        // options until they select 7. Exit Program
        do {
            System.out.println("Please choose from the menu options below:");
            System.out.println("1. Create a binary search tree");
            System.out.println("2. Add a node");
            System.out.println("3. Delete a node");
            System.out.println("4. Print nodes by InOrder");
            System.out.println("5. Print nodes by PreOrder");
            System.out.println("6. Print nodes by PostOrder");
            System.out.println("7. Exit program");
            userMenuChoice = validateUserMenuChoice(input);

            switch (userMenuChoice) {
                case 1:
                    // LOOK HERE!!! create the default binary search tree
                    // set treeCreated to true
                    break;
                case 2:
                    // LOOK HERE!!! Add a node.
                    //Check that treeCreated is true
                    break;
                case 3:
                    // LOOK HERE!!! Delete a node.
                    //Check that treeCreated is true
                    break;
                case 4:
                    // LOOK HERE!!! Print nodes InOrder
                    //Check that treeCreated is true
                    //check if(root == null) System.out.println("The tree is empty. There are no nodes to display.");
                    //this is because someone could technically create the tree and then delete all the nodes
                    break;
                case 5:
                    // LOOK HERE!!! Print nodes PreOrder
                    //Check that treeCreated is true
                    //check if(root == null) System.out.println("The tree is empty. There are no nodes to display.");
                    break;
                case 6:
                    // LOOK HERE!!! Print nodes PostOrder
                    //Check that treeCreated is true
                    //check if(root == null) System.out.println("The tree is empty. There are no nodes to display.");

                    break;
                case 7:
                    // LOOK HERE!!! Exit the program
                    break;
            }
        } while (userMenuChoice != 7);
        input.close();
    }

    // method to check that the menu choice was valid. The loop will continue as
    // long as
    // the input is invalid(number not 1-7)
    public static int validateUserMenuChoice(Scanner input) {
        int choice;
        // using a do-while loop so the input is checked at least once
        do {
            while (!input.hasNextInt()) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a value between 1 and 7.");
                // consume invalid token
                input.next();
            }
            choice = input.nextInt();
            if (choice <= 0 || choice > 7) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a value between 1 and 7.");
            }
            // loop will continue if input is not 1-7
        } while (choice <= 0 || choice > 7);
        // valid input is returned to the method that called it
        return choice;
    }

    // method to check that the inkput was a valid integer
    public static int validateInputInt(Scanner input) {
        int value;
        // using do-while loop so the input is checked at least once
        while (!input.hasNextInt()) {
            // if the input was invalid prompt the user to enter a number again
            System.out.println("Sorry, That was an invalid input. Please enter a whole number.");
            // consume invalid token
            input.next();
        }
        value = input.nextInt();
        // valid input is returned to the method that called it
        return value;
    }

}
