public class RegexPractice {
    // Regex transcends any individual programming language
    // though some can be different
    public static void main(String[] args) {
        // ABCs of RegEx
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

        // SHORT HAND CHAR CLASSES:
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

    }
}
