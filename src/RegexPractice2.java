public class RegexPractice2 {
    public static void main(String[] args) {
        // CHARACTER CLASSES:
        // true
        System.out.println("doggy".matches("....."));
        // true
        System.out.println("doggy".matches(".*"));
        // 0 or 1
        // false
        System.out.println("doggy".matches(".?"));
        // match characters that are not abc or d
        System.out.println("doggy".matches("[^abcd]"));
        // start at beginning of line and then 5 chars of any sort:
        // true
        System.out.println("doggy".matches("^....."));
        // end of line
        // true
        // ^ = very beginning of string (not the d in doggy, before the d)
        // $ = very end of string (not the y in doggy, after the y)
        System.out.println("doggy".matches("^.....$"));
        // simple unit text editors new line chars (exist in data of file but invisible)
        // on Unix systems by default single char new line (line feed: \n) = 10
        // on Windows = combination of new line and carriage return (\n,\r) = 10,13
        // ASCII (American standard code for information interchange)
        // Octal (base 8), Decimal (base 10), Hexadecimal (base 16)
        // Decimal probably most of us find most comfortable using

        // BOUNDARY CHARACTER CLASS
        // Boundary Character (\\b) class simply matches the area between a word character and a non-word character (order doesn't matter)
        // false
        System.out.println("cat doggy".matches("...\\b....."));
        // true
        System.out.println("cat doggy".matches("...\\s\\b....."));
        // we have something between the space and the word character and that is what the boundary class is matching on

        // WORD CHARACTER CLASS
        // true
        System.out.println("cat".matches("\\w\\w\\w"));
        //
        // capital mean anything other than word characters, i.e. opposite - non-word characters
        // false:
        System.out.println("cat".matches("\\W\\W\\W"));
        // true
        System.out.println("---".matches("\\W\\W\\W"));
        // false
        System.out.println("123".matches("\\W\\W\\W"));

        // Non-digits
        // false
        System.out.println("123".matches("\\D\\D\\D"));
        // true
        System.out.println("abc".matches("\\D\\D\\D"));
        // if you were parsing text and wanted to make sure that no one could put digits in certain positions

        // Non-space chars:
        // false
        System.out.println(" ".matches("\\S"));
        // false - because 1 char that isn't a space, but we have 0 chars
        System.out.println("".matches("\\S"));
        // true - matches - any char that isn't a space
        System.out.println(".".matches("\\S"));


    }
}
