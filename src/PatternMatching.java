import static java.lang.StringTemplate.STR;

public class PatternMatching {
    public static void main(String[] args) {
        record Person(String firstName, String lastName, int age) {}
        String var1 = "Hello World";
        Integer var2 = 34;
        String[] var3 = {"hello", "world"};
        Person var4 = new Person("Jake", "Johnson", 40);
        Person var5 = new Person("Abe", "Johnson", 40);
        Object obj = var5;
        // with pattern matching functionality that has been added to switches we have the ability now to test for the type of object we are switching on
        // and to avoid casting that object if its case is a match
        // and we can additionally test on properties of that variable

//        // Prior to the introdutcion of pattern matching for switches we had to do extra code to get this functionality
//        if (obj instanceof String) {
//            String msg = (String) obj;
//            System.out.println(msg.toLowerCase());
//        }
        // equivalent to one single conside line:
//        case String msg -> System.out.println(msg);


        switch(obj) {
            // in the original implementation of Java switches you could not test for null
            case null -> System.out.println("It's null");
            // if obj = string then let's call it msg and then print out the value of msg
            // automatic casting
            case String msg -> System.out.println(msg);
            case Integer num -> System.out.println("Your number is: " + num);
            // if obj is of type person then cast it to p and if that's true then check if length of firstname is greater than 3 only then can sout execute
            // used to use && instead of when. && no longer valid syntax
            case Person p
                    when p.firstName().length() > 3
                    -> System.out.println("Looks like Jake");
            case String[] arr -> System.out.println(STR."Looks like an array with \{arr.length} elements");
            default -> System.out.println("Have no idea");
        }
    }
}
