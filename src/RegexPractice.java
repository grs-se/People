import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {
    // Regex transcends any individual programming language
    // though some can be different
    public static void main(String[] args) {
        // 1. ABCs of RegEx
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
        // allow for word that has any 3 latin chars
        System.out.println("Lat".matches("\\wat"));
        // allow for word that has any 3 latin chars
        // true
        System.out.println("_at".matches("\\wat"));

        // 2. SHORT HAND CHAR CLASSES:
        // allow for word that has any 3 latin chars
        // false - hyphen doesn't underscore does!?
        System.out.println("_at".matches("\\wat"));
        // any 3 word chars
        System.out.println("G_t".matches("\\w\\w\\w"));
        // Numbers / D for digit
        System.out.println("_at".matches("\\d"));
        System.out.println("1a3".matches("\\d\\d\\d"));
        // Phone number
        System.out.println("321-333-7651".matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
        // Quantifier:
        // quantify how many times we want a regex to match
        // true
        System.out.println("321-333-7651".matches("\\d{3}-\\d{3}-\\d{4}"));
        System.out.println("321.333.7651".matches("\\d{3}[-.]\\d{3}[.-]\\d{4}"));
        //regex = highly flexible and yet constrained what you are allowed to check against with text
        // allow for commas, spaces, hyphens, periods and spaces
        System.out.println("321 333 7651".matches("\\d{3}[-.,\\s]\\d{3}[-.,\\s]\\d{4}"));
        // arbitrary spaces
        // quantifier
        // + = 1 or more of char in front of +, so 1 or more of any of the following characters [-.,\s]+
        System.out.println("321 333 7651".matches("\\d{3}[-.,\\s]+\\d{3}[-.,\\s]+\\d{4}"));
        // regex = concise computer language, easy to read by computer, but can be hard to read by humans
        //
        // allow for possibility of 0 or more = *
        // true matches
        System.out.println("3213337651".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}"));
        // true matches
        System.out.println("321 333 7651".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}"));
        // true matches
        System.out.println("321 333   7651".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}"));
        // true matches
        System.out.println("321-333-7651".matches("\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}"));
        //
        // quantifier 0 or 1, but not more than 1:
        // true matches
        System.out.println("321-333-7651".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}"));
        // true matches
        System.out.println("3213337651".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}"));
        // false
        System.out.println("321  333   7651".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}"));
        //
        // numerical quantifiers:
        // 3 or 4 digits long
        // true matches
        System.out.println("321 333 6513".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}"));
        // true matches
        System.out.println("321 333 651".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}"));
        // false
        System.out.println("321 333 651342".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}"));
        // false
        System.out.println("321 333 65".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,4}"));
        // at least 3 digits long but no upper limit
        // true matches
        System.out.println("321 333 65243242342342342".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,}"));
        // false:
        System.out.println("321 333 65".matches("\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{3,}"));
        // Reduce duplication (lazy)
        // (group "321 " and add quantifier to say match grouping 2x = (\d{3}[-.,\s]?){2})
        // true matches
        System.out.println("321 333 6524".matches("(\\d{3}[-.,\\s]?){2}\\d{4}"));
        // up to 2 duplications
        // true:
        System.out.println("321 333 6524".matches("(\\d{3}[-.,\\s]?){1,2}\\d{4}"));
        // optional 1.
        // true
        System.out.println("1.321.333.6524".matches("(\\d[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}"));
        // if you do put something in first position it has to be 1
        // true
        System.out.println("321.333.6524".matches("(1[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}"));
        // This is powerful!

        // start at beginning and go slowly

        // 3. Capture Groups:
        // a reg ex is a pattern
        // reg ex is a programming language - a program (RegEx) within a program (Java)
        // reg ex needs to be compiled
        // java easy to read by humans but not easy to read for computers, so intermediate step where computer translates java into bytecode (machine code - 0011010)
        // similarly reg ex get compiles into another form that is more efficient to use by computer
        // compiling reg ex is expensive - so dont use Pattern.compile too much over and over again
        // compilation in general is expensive
        // Matcher class
        // when you use quantifiers with capture groups you only have access to the last thing that matched which is why it's throwing 333
        // String regex = "(1[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}";

//        String regex = "(\\d{1,2}[-.,\\s]?)?(\\d{3}[-.,\\s]?)(\\d{3}[-.,\\s]?)\\d{4}";
        // parse and return numbers with special characters
        // order of capture groups changes
        // This one line is equivalent of LearnStrings phone number methods
        // less readable but one line and much more flexible
//        String regex = "((\\d{1,2})[-.,\\s]?)?((\\d{3})[-.,\\s]?)((\\d{3})[-.,\\s]?)(\\d{4})";
// ?: inside opening parentheses says "don't remember" - non-capturing
        String regex = "(?:(\\d{1,2})[-.,\\s]?)?(?:(\\d{3})[-.,\\s]?)(?:(\\d{3})[-.,\\s]?)(\\d{4})";

        String phoneNumber = "(232) 333-6524";
//        String phoneNumber = "12.232.333.6524";

        //boilerplate to set up regex in more complex ways
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phoneNumber);

        // capture groups within ()
        if (mat.matches()) {
            System.out.format("Country code: %s\n", mat.group(1));
            System.out.format("Area code: %s\n",mat.group(2));
            System.out.format("Exchange: %s\n",mat.group(3));
            System.out.format("Line number: %s\n", mat.group(4));
            // capture group 0 = entire string
            System.out.println(mat.group(0));
        }

        // NAMED CAPTURE GROUPS
        String namedCaptureGroupRegex = """
# This regex parses parts of a phone number
(?:(?<countryCode>\\d{1,2})[-.,\\s]?)? # Get's country code
# parentheses are special chars so need to escape them and then 0 or 1 (optional)
(?:\\(?(?<areaCode>\\d{3})\\)?[-.,\\s]?) # Get's area code
(?:(?<exchange>\\d{3})[-.,\\s]?) # Get's exchange
(?<lineNumber>\\d{4}) # Get's line number
""";

        // note: allowing comments tells regex engine to ignore spaces, so can't put literal spaces in, instead \\s
        Pattern pat2 = Pattern.compile(namedCaptureGroupRegex, Pattern.COMMENTS);
        Matcher mat2 = pat2.matcher(phoneNumber);

        // Terry prefers named capture groups: unwieldy but easier to understand
        // capture groups within ()
        if (mat2.matches()) {
            System.out.format("Country code: %s\n", mat2.group("countryCode"));
            System.out.format("Area code: %s\n",mat2.group("areaCode"));
            System.out.format("Exchange: %s\n",mat2.group("exchange"));
            System.out.format("Line number: %s\n", mat2.group("lineNumber"));
            // capture group 0 = entire string
//            System.out.println(mat.group(0));
        }

    }
}
