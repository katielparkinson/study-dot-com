package MiscLessonPractice.src;

import java.util.Scanner;

public class LearnScanner {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What is your first name?");
            String userFirstName = input.next();
            switch (userFirstName.toLowerCase()) {
                case "mckay":
                    System.out.println("ahhhhh... It's Katie's boyfriend. You have our condolences.");
                    break;
                case "brian":
                    System.out.println("yo yo it's the daddio");
                    break;
                case "shanie":
                    System.out.println("Hello mumther");
                    break;
                case "katie":
                    System.out.println("All hail our great creator!");
                    break;
                case "brooke":
                    System.out.println("Well, if it isn't our favorite Swifty!");
                    break;
                default:
                    System.out.println("Hello, " + userFirstName);
                    break;
            }
            if (userFirstName.toLowerCase().equals("brooke")) {
                System.out.println("What is your favorite color?");
                String faveColor = input.next();
                switch (faveColor.toLowerCase()) {
                    case "blue":
                        System.out.println("I'm blue da ba dee da ba di.");
                        break;
                    case "red":
                        System.out.println("Ah just just like the blood of your enemies.");
                        break;
                    case "black":
                        System.out.println("Black? Ok Edgelord.");
                        break;
                    case "purple":
                        System.out.println("Ooooo I like this one too!");
                        break;
                    case "green":
                        System.out.println("Go touch grass.");
                        break;
                    default:
                        System.out.println(faveColor + ". What a nice color.");
                        break;
                }
            } else {
                System.out.println("How old are you?");
                int userAge;
                while (!input.hasNextDouble()) {
                    // using double instead of int and then casting the double as int allows for
                    // users to enter a decimal for age
                    System.out.println("Bruh. Was that really a number? -_-");
                    input.next();
                }
                double tempAge = input.nextDouble();
                userAge = (int) tempAge;
                // casts tempAge double data type to int
                System.out.println(userAge + " Damn. You're old.");
            }
        } catch (Exception e) {
            System.err.println("Well frick you broke it.");
        }
    }
}
