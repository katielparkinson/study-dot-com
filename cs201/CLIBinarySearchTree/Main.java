import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);
        Node root = null;
        int userMenuChoice;
        boolean anotherTree;
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
                    // This check is if the user tries to create a tree again.
                    // creating another tree will delete the tree they have already created.
                    if (root != null) {
                        System.out.println("Creating a new tree will delete the old one.");
                        System.out.println("Would you like to continue? yes or no");
                        anotherTree = validateYesNoInput(input);
                        if (anotherTree) {
                            root = BSTMenuHelper.createDefaultBST();
                        } else {
                            System.out.println("Operation Cancelled");
                        }
                    } else {
                        // create the default binary search tree
                        root = BSTMenuHelper.createDefaultBST();
                    }
                    break;

                case 2:
                    if (BSTMenuHelper.treeHasNode(root)) {
                        // Add a node.
                        System.out.println("Please enter a value to add.");
                        int valueToAdd = validateInputInt(input);
                        root = BSTMenuHelper.addNode(root, valueToAdd);
                    }
                    break;

                case 3:
                    if (BSTMenuHelper.treeHasNode(root)) {
                        // Delete a node.
                        System.out.println("Please enter a value to delete.");
                        int valueToDelete = validateInputInt(input);
                        root = BSTMenuHelper.deleteNode(root, valueToDelete);
                    }
                    break;

                case 4:
                    // Print nodes InOrder
                    if (BSTMenuHelper.treeHasNode(root)) {
                        System.out.print("In-order traversal: ");
                        BSTMenuHelper.printInOrder(root);
                        System.out.println();
                    }
                    break;

                case 5:
                    // Print nodes PreOrder
                    if (BSTMenuHelper.treeHasNode(root)) {
                        System.out.print("Pre-order traversal: ");
                        BSTMenuHelper.printPreOrder(root);
                        System.out.println();
                    }
                    break;

                case 6:
                    // Print nodes PostOrder
                    if (BSTMenuHelper.treeHasNode(root)) {
                        System.out.print("Post-order traversal: ");
                        BSTMenuHelper.printPostOrder(root);
                        System.out.println();
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the program. Goodbye!");
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
            // clear leftover newline
            input.nextLine();
            if (choice <= 0 || choice > 7) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a value between 1 and 7.");
            }
            // loop will continue if input is not 1-7
        } while (choice <= 0 || choice > 7);
        // valid input is returned to the method that called it
        return choice;
    }

    // method to check that the input was a valid integer
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
        // clear leftover newline
        input.nextLine();
        // valid input is returned to the method that called it
        return value;
    }

    // method to check that input was valid. only "yes" or "no" are valid inputs
    public static boolean validateYesNoInput(Scanner input) {
        String yesNo;
        // using a do-while loop so the input is checked at least once
        do {
            yesNo = input.nextLine().trim().toLowerCase();
            switch (yesNo) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    // if the input was invalid prompt the user to enter yes or no again
                    System.out.println("Sorry, That was an invalid input. Please enter \"yes\" or \"no\".");
            }
            // Loop only repeats when the input is invalid.
        } while (true);
    }
}
