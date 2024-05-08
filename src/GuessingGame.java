import java.util.Random;

public class GuessingGame {

    public static final int MAX_ALLOWED_TRIES = 4;

    public static void main(String[] args) {
        /*
        /////////
        // CONDITIONALS WITH IF/ELSE
        /////////
        // generate number between 1 and 3
        // as a programmer we often need to transform data from this to that
        // 0 - 2, 1 - 3
        int randomNum = new Random().nextInt(5) + 1;
        System.out.printf("Generated number is: %d.%n", randomNum);


        // if statement evaluates to a boolean
        // if the statement evaluates to false the thread skips the if block and jumps to the next line of execution
        if (randomNum == 1) {
            System.out.println("The color is RED");
        } else if (randomNum == 2){
            System.out.println("The color is GREEN");
        } else if (randomNum == 3) {
            System.out.println("The color is BLUE");
        } else {
            System.out.println("The color is POLKA-DOT");
        }

        // CONTROL FLOW INEQUALITIES
        if (randomNum <= 2) { //
            System.out.println("The color is RED");
        } else if (randomNum >= 4) {
            System.out.println("The color is BLUE");
        } else {
            System.out.println("The color is GREEN");
        }

        // COMPOUND STATEMENTS
        if (randomNum <= 2) { //
            System.out.println("The color is RED");
        }
        // randomNum bigger than 4 and is even number
        // else if (randomNum >= 4 || (randomNum % 2 == 0)) {
        else if (randomNum >= 4 && (randomNum % 2 == 0)) {
            System.out.println("The color is BLUE");
        } else {
            System.out.println("The color is GREEN");
        }

        // THE SWITCH STATEMENT
        if (randomNum == 1) {
            System.out.println("The color is RED");
        } else if (randomNum == 2){
            System.out.println("The color is GREEN");
        } else if (randomNum == 3) {
            System.out.println("The color is BLUE");
        } else if (randomNum == 4) {
            System.out.println("The color is PURPLE");
        } else {
            System.out.println("The color is whatever");
        }
        // functionally equivalent to if/else statement
        switch (randomNum) {
            case 1:
                System.out.println("The color is RED");
                // if we don't have this break here the thread will keep moving through all the cases
                // tells the thread to the jump out of the switch block onto the next line, and if no next line then the program just ends
                // very easy to forget the break
                break;
            case 2:
                System.out.println("The color is GREEN");
            break;
            case 3:
                System.out.println("The color is BLUE");
                break;
            case 4:
                System.out.println("The color is PURPLE");
                break;
            default:
                System.out.println("The color is whatever");
                // optional default break
                break;
        }
        //////////////////
        */

        /*
        //////////////////
        String command = "stop";
        String command = null;

        // Most people consider switch statements to be more readable, and switch statements run faster than if statements, due to compiler optimizations
        // however, the break statements can be easy to forget and not elegant, and not easy way to test for null variables (in versions prior to Java 17)
        // recommendation against nested if else blocks if possible
        if (command == null) {

        } else {
            switch (command) {
                case "stop":
                    System.out.println("Stopping now...");
                    // don't need break here!?
                case "go":
                    System.out.println("Going now...");
                default:
                    System.out.println("Command not understood");
            }
         }
        ////////////////
        */


        /*
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
        // System.out.println(currentValue);
        System.out.printf("Current Card Value: %d%n", currentValue);
        System.out.printf("Total value: %d%n", currentTotalValue + currentValue);
        ////////////////
        */

        /*
        ////////////////
        // WHILE LOOPS
        // When we use the java command to execute a java programme we are actually pointing it at the final byte code version that Java built for us, and so we have to tell Java where that is.
        // That folder is under the out/ folder.
        // terminal command: ' java -cp .\out\production\People GuessingGame'
        int randomNum = new Random().nextInt(10) + 1;

        // console = related to computer and monitor?
        // can't call a method on a null object
        String guessedNumStr = null;
        // while (guessedNumStr.equals("q")) {
        // flip around: "q" will always exist as it is hardcoded
        while (!"q".equals(guessedNumStr)) {
            guessedNumStr = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            // nested if statements (inside while loops) increase complexity of the programme
            // probably not the best way, more complex to process in head
            // somewhat realistic scenario to use a reg ex
            if (guessedNumStr.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumStr);
                if (guessedNum == randomNum) {
                    System.out.printf("The random number was %d. You got it!%n", randomNum);
                    return;
                } else {
                    System.out.println("You didn't get it!");
                }
            }
        }
        ////////////////
        */

        /*
        ////////////////
        // DO WHILE LOOP
        ////////////////
        // only distinction between while loop and do while loop is that
        // with the do while the body of the loop is guaranteed to run at least once
        // program seems to run exactly as before

        int randomNum = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNum);

        String guessedNumStr = null;

        int wrongGuessCount = 1;

        do {
            guessedNumStr = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumStr.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumStr);
                if (guessedNum == randomNum) {
                    // ternary operator best for small conditionals
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    // by default with printf or format each replacement code %d %s gets replaced with a corresponding variable in the order in which they come - %d (digit) = randomNum, %d = wrongGuessCount, %s = tryText
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNum, wrongGuessCount, tryText);
                    return;
                }
                // prepare things before presenting things
                System.out.println("You didn't get it!");
                wrongGuessCount++;
            }
        }  while (!"q".equals(guessedNumStr) && wrongGuessCount <= MAX_ALLOWED_TRIES);

        if (wrongGuessCount >= MAX_ALLOWED_TRIES) {
            System.out.printf("You've had %d incorrect guesses. The random number is %d. Ending program now.", wrongGuessCount-1, randomNum);
        }

        // both parts have to be true to evaluate to true
        // didn't press q = 1, less than 5 wrong guesses = 1 --> loop continues
        // any other scenario and the loop will stop

        // SCOPE
        // any time you record a variable in a code block
        // as soon as thread leaves the code block the variables that were declared in that code block cease to exist.
        // only come back into existence when the thread comes back into the code block
        // local variables. Local to that block of code (function, method)
        // maintain state of this variable declare it outside of scope of loop
        // Note: you might be inclined to keep all variables as global as possible, high up in the program, but that would be a mistake: can be wasteful of memory and resources.
        // Where will I need access to any given variable and how long will that variable need to retain its data.
        // you want to keep variables as local to where they are going to be used as possible.

        // Java (Java Virtual Machine) has 'Garbage Collection' - variables take space in memory, when the thread leaves the scope, those variables are allowed to be garbage collected by Java, meaning the space that those variables took in memory can be reclaimed.
        // JVM decides when is the best time to collectthe garbage
        // If we were to run this programs loop and guess incorrectly 1 million times really quickly then we would end up with 1 million string objects in memory and they would never get collected for memory.

        // Minimally edited video to show process of a professional developer thinking through a problem in nearly real-time - it's not magic, it's trial and error.
        // sometimes good to think through what variables are in advance, sometimes a waste of time as better to just run the program and see what you get.
        // }
        ////////////
         */

        ////////////
        // FOR LOOPS
        ////////////
        // Most popular type of loop is For loop
        // by default For loop only loops a certain number of times
        // mostly used for iterating over a list of things (primitives, People, etc.)
        // for loops (as well as while loops) are in most programming languages, and syntax mostly the same.

        int randomNum = new Random().nextInt(10) + 1;
        System.out.printf("Random number is %d.%n", randomNum);
        String guessedNumStr = null;
        int wrongGuessCount; // default value of int = 0;
        for (wrongGuessCount = 1; wrongGuessCount <= MAX_ALLOWED_TRIES; wrongGuessCount++) {
            guessedNumStr = System.console().readLine("Please guess a number between 1 and 10 inclusively: ");
            if (guessedNumStr.matches("-?\\d{1,2}")) {
                int guessedNum = Integer.parseInt(guessedNumStr);
                if (guessedNum == randomNum) {
                    String tryText = wrongGuessCount == 1 ? "try" : "tries";
                    System.out.printf("The random number was %d. You got it in %d %s!%n", randomNum, wrongGuessCount, tryText);
                    // return will exit the loop and end the program (if the loop is directly within the main method)
                    // break will only exit the loop (but in this case the program will also end)
                    // break statement works with all loops (do/while, for, while)
                    break;
                }
                System.out.println("You didn't get it!");
                // continue: short-circuits any remaining code that might get executed within a loop and causes the thread to go back to the top of the loop and start again.
                continue;
            }
        }
        if (wrongGuessCount >= MAX_ALLOWED_TRIES) {
            System.out.printf("You've had %d incorrect guesses. The random number is %d. Ending program now.", wrongGuessCount - 1, randomNum);
        }

        // Alternative syntax for initializing variable for use in a for loop, but rarely use it
        // int wrongGuessCount = 1; // default value of int = 0;
        // for (; wrongGuessCount <= MAX_ALLOWED_TRIES; wrongGuessCount++) {

    }
}