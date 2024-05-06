import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
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
        else if (randomNum >= 4 && (randomNum % 2 == 0)) {
//        else if (randomNum >= 4 || (randomNum % 2 == 0)) {
            System.out.println("The color is BLUE");
        } else {
            System.out.println("The color is GREEN");
        }
    }


}
