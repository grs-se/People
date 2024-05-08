public class ForLoopExample {
    public static void main(String[] args) {
        int counter;
        for (counter=0; counter < 10; counter++) {
            System.out.printf("Counter is %d%n", counter + 1);
        }

        // each of clauses is optional, but loop would break
        // games sometimes have an infinite loop like below (probably not a for loop) to repaint the frame over and over
        // for (counter=0; ; counter++) {
        // infinite loop of printing 0:
        // for (counter=0; ; ;) {

        // counter = 5;
    }
}
