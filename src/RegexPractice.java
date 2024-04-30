public class RegexPractice {
    public static void main(String[] args) {
        System.out.println("Bat".matches("[cCbB]at"));
        // range
        // = true
        System.out.println("fat".matches("[a-f]at"));
        // = false
        System.out.println("gat".matches("[a-f]at"));
        // uppercase
        System.out.println("fat".matches("[a-fA-Fw-zW-Z]at"));
        // negative - every char except c
        // = false
        System.out.println("cat".matches("[^c]at"));
        // negation with range - every char a - z
        // = true
        System.out.println("Lat".matches("[^a-z]at"));

    }
}
