import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        /////////
        // CONDITIONALS WITH IF/ELSE
        /////////
        // generate number between 1 and 3
        // as a programmer we often need to transform data from this to that
//        // 0 - 2, 1 - 3
//        int randomNum = new Random().nextInt(5) + 1;
//        System.out.printf("Generated number is: %d.%n", randomNum);


        // if statement evaluates to a boolean
        // if the statement evaluates to false the thread skips the if block and jumps to the next line of execution
//        if (randomNum == 1) {
//            System.out.println("The color is RED");
//        } else if (randomNum == 2){
//            System.out.println("The color is GREEN");
//        } else if (randomNum == 3) {
//            System.out.println("The color is BLUE");
//        } else {
//            System.out.println("The color is POLKA-DOT");
//        }

        // CONTROL FLOW INEQUALITIES
//        if (randomNum <= 2) { //
//            System.out.println("The color is RED");
//        } else if (randomNum >= 4) {
//            System.out.println("The color is BLUE");
//        } else {
//            System.out.println("The color is GREEN");
//        }

        // COMPOUND STATEMENTS
//        if (randomNum <= 2) { //
//            System.out.println("The color is RED");
//        }
//        // randomNum bigger than 4 and is even number
//        else if (randomNum >= 4 && (randomNum % 2 == 0)) {
////        else if (randomNum >= 4 || (randomNum % 2 == 0)) {
//            System.out.println("The color is BLUE");
//        } else {
//            System.out.println("The color is GREEN");
//        }

        // THE SWITCH STATEMENT
//        if (randomNum == 1) {
//            System.out.println("The color is RED");
//        } else if (randomNum == 2){
//            System.out.println("The color is GREEN");
//        } else if (randomNum == 3) {
//            System.out.println("The color is BLUE");
//        } else if (randomNum == 4) {
//            System.out.println("The color is PURPLE");
//        } else {
//            System.out.println("The color is whatever");
//        }
        // functionally equivalent to if/else statement
//        switch (randomNum) {
//            case 1:
//                System.out.println("The color is RED");
//                // if we don't have this break here the thread will keep moving through all the cases
//                // tells the thread to the jump out of the switch block onto the next line, and if no next line then the program just ends
//                // very easy to forget the break
//                break;
//            case 2:
//                System.out.println("The color is GREEN");
//            break;
//            case 3:
//                System.out.println("The color is BLUE");
//                break;
//            case 4:
//                System.out.println("The color is PURPLE");
//                break;
//            default:
//                System.out.println("The color is whatever");
        // optional default break
//                break;
//        }

        //////////////////
//        String command = "stop";
//        String command = null;
//
//        // Most people consider switch statements to be more readable, and switch statements run faster than if statements, due to compiler optimizations
//        // however, the break statements can be easy to forget and not elegant, and not easy way to test for null variables (in versions prior to Java 17)
//        // recommendation against nested if else blocks if possible
//        if (command == null) {
//
//        } else {
//            switch (command) {
//                case "stop":
//                    System.out.println("Stopping now...");
//                    // don't need break here!?
//                case "go":
//                    System.out.println("Going now...");
//                default:
//                    System.out.println("Command not understood");
//            }
//         }
        ////////////////

        ////////////////
        // BLACKJACK
        String card = "king";
        int currentTotalValue = 15;

        // in previous versions of Java couldn't use a switch statement to return and assign a value to something
        // you could print something out, call other methods, or execute statements, but couldnt use a switch statement to return a value
        int currentValue = switch (card) { // can assign a value to the switch statement, returns a value
            // new syntax post Java 14
            // can combine multiple constants which are all going to have same value
            case "king", "queen", "jack" -> 10;
            case "ace" -> {
                if (currentTotalValue < 11) {
                    // if in a method then could use return statement: return 10
                    // doesn't make sense to use return within a case section of a switch clause
                    // as of Java 14 can use yield which is basically the same thing
                    yield 11;
                } else {
                    yield 1;
                }
            }
            default -> Integer.parseInt(card);
        };
//        System.out.println(currentValue);
        System.out.printf("Current Card Value: %d%n", currentValue);
        System.out.printf("Total value: %d%n", currentTotalValue + currentValue);

        ////////////////

    }
}
