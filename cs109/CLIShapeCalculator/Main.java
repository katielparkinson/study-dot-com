import java.util.Scanner;

/* 
The purpose of this program is to calculate the area of rectangle 
based on the user inputs for length and width. This program will also be able to
calculate the volume of a sphere, cylinder, or cube depending on a user's inputs.
 */
public class Main {
    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);
        boolean anotherCalc;
        // do-while loop to make it so a user can go through multiple calculations if
        // they would like
        do {
            System.out.println("Hello! Let's do some calculations.");
            System.out.println("Enter \"1\" to calculate the area of a rectangle.");
            System.out.println("Enter \"2\" to calculate the volume of a sphere.");
            System.out.println("Enter \"3\" to calculate the volume of a cylinder.");
            System.out.println("Enter \"4\" to calculate the volume of a cube.");
            int userCalcChoice = validateUserCalcChoice(input);
            switch (userCalcChoice) {
                case 1:
                    // prompt user to enter a number for rectangle Length
                    System.out.println("Let's calculate the area of your rectangle!");
                    System.out.println("Please enter the rectangle's length:");
                    // valid input is stored as rectangle length
                    double rectLength = validateInputDouble(input);
                    // prompt user to enter a number for rectangle Width
                    System.out.println("Please enter the rectangle's width:");
                    // valid input is stored as rectangle width
                    double rectWidth = validateInputDouble(input);
                    // an instance of the Rectangle class is created using the stored user inputs of
                    // length and width
                    Rectangle userRect = new Rectangle(rectLength, rectWidth);
                    // the rectangleArea method is called
                    System.out.println("Your rectangle's area is: " + userRect.rectangleArea());
                    break;
                case 2:
                    // prompt user to enter a number for sphere radius
                    System.out.println("Let's calculate the Volume of your sphere!");
                    System.out.println("Please enter the sphere's radius:");
                    // valid input is stored as sphere radius
                    double sphereRadius = validateInputDouble(input);
                    // an instance of the sphere class is created using the stored user input of
                    // radius
                    Sphere userSphere = new Sphere(sphereRadius);
                    // the sphereVolume method is called
                    System.out.println("Your sphere's volume is: " + userSphere.sphereVolume());
                    break;
                case 3:
                    // prompt user to enter a number for cylinder radius
                    System.out.println("Let's calculate the Volume of your cylinder!");
                    System.out.println("Please enter the cylinder's radius:");
                    // valid input is stored as cylinder radius
                    double cylinderRadius = validateInputDouble(input);
                    // prompt user to enter a number for cylinder height
                    System.out.println("Please enter the cylinder's height:");
                    // valid input is stored as cylinder height
                    double cylinderHeight = validateInputDouble(input);
                    // an instance of the cylinder class is created using the stored user inputs of
                    // radius and height
                    Cylinder userCylinder = new Cylinder(cylinderRadius, cylinderHeight);
                    // the cylinderVolume method is called
                    System.out.println("Your cylinder's volume is: " + userCylinder.cylinderVolume());
                    break;
                case 4:
                    // prompt user to enter a number for cube length
                    System.out.println("Let's calculate the Volume of your cube!");
                    System.out.println("Please enter the cube's side length:");
                    // valid input is stored as cube length
                    double cubeLength = validateInputDouble(input);
                    // an instance of the cube class is created using the stored user input of
                    // length
                    Cube userCube = new Cube(cubeLength);
                    // the cubeVolume method is called
                    System.out.println("Your cube's volume is: " + userCube.cubeVolume());
                    break;
            }

            System.out.println("Would you like to perform another calculation? \"yes\" or \"no\"");
            anotherCalc = validateYesNoInput(input);
        } while (anotherCalc);
        input.close();
        System.out.println("Thanks for using the calculator. Goodbye!");
    }

    // method to check that the input was valid. The loop will continue as long as
    // the input is invalid(not a double and/or negative)
    public static double validateInputDouble(Scanner input) {
        double measurement;
        // using a do-while loop so the input is checked at least once
        do {
            while (!input.hasNextDouble()) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a positive number.");
                // consume invalid token
                input.next();
            }
            measurement = input.nextDouble();
            if (measurement <= 0) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter a positive number.");
            }
            // loop will continue as long as the double is less than or equal to 0
        } while (measurement <= 0);
        // valid input is returned to the method that called it
        return measurement;
    }

    // method to check that the input was valid. The loop will continue as long as
    // the input is invalid(number not 1-4)
    public static int validateUserCalcChoice(Scanner input) {
        int measurement;
        // using a do-while loop so the input is checked at least once
        do {
            while (!input.hasNextInt()) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter 1, 2, 3, or 4.");
                // consume invalid token
                input.next();
            }
            measurement = input.nextInt();
            if (measurement <= 0 || measurement > 4) {
                // if the input was invalid prompt the user to enter a number again
                System.out.println("Sorry, That was an invalid input. Please enter 1, 2, 3, or 4.");
            }
            // loop will continue if input is not 1-4
        } while (measurement <= 0 || measurement > 4);
        // valid input is returned to the method that called it
        return measurement;
    }

    // method to check that input was valid. only "yes" or "no" are valid inputs
    public static boolean validateYesNoInput(Scanner input) {
        String yesNo;
        // using a do-while loop so the input is checked at least once
        do {
            /* 
            storing input as yesNo and using trim and toLowerCase to eliminate any soaces
            before or after response and accept yes or no inputs that may not have been
            all lowercase by converting input to lowercase before check
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
        //This can just be set to true because the only time this will have a chance to run is when the default case is hit. 
        //The default case only runs when the input is invalid.
        } while (true);
    }
}
