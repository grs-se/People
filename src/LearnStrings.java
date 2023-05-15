import java.awt.*;


public class LearnStrings {
    public static void main(String[] args) {
//        createStrings();
//        upperLowerCasing();
//        blankOrEmpty();
//        replaceTextWithinStrings();
//        removingWhiteSpace();
//        getIndividualChars();
//        compareForAlphabeticalOrder();
//        contains();
//        stringConcatenation();
//        determineLength();
//        subString();
//        searchWithinAString();
//        parsePhoneNumber("(234) 333-5551");
//        splitStringApart();
//        startsWithEndsWith();
//        contentEquals();
        person("tim", "smith");
        catToDog("My cat smells");
        noUnintendedSpaces("    Over and Out!      ");
        capitalizeLastLetter("Haberdashery");
        parseAddress("12345 Big St., Alphabet City, CA 90210");

    }



    public static void createStrings() {
//        Point to same memory address
        String fruit = "apple";
        String anotherFruit = "apple";
//        Point to different memory address
        String vegetable = new String("broccoli");
        String anotherVegetable = new String("broccoli");
        System.out.println(fruit == anotherFruit);
        System.out.println(vegetable == anotherVegetable);
    }

    public static void upperLowerCasing() {
        String myText = "abcdefg";
        System.out.println(myText.toUpperCase());
        String myText2 = "ABCDEFG";
        System.out.println(myText2.toLowerCase());
    }

    public static void blankOrEmpty() {
        String myText3 = "";
        System.out.println(myText3.isEmpty());
        System.out.println(myText3.isBlank());
    }

    public static void replaceTextWithinStrings() {
        String myText4 = "here's my firf awesome firf text";
        System.out.println(myText4.replace('e', 'Z'));
    }

//        REMOVING WHITE SPACE - strip()
    public static void removingWhiteSpace() {
//        String firstName = "  Jake ";
//        multi-line string / "text block"
        String firstName = """
                first line here
                second line here
                third line here
                """;
        String firstName3 = "first line here" +
                "second line here" +
                "third line here";
        System.out.format("'%s'", firstName.stripTrailing());
        System.out.format("'%s'", firstName.stripLeading());
        System.out.format("'%s'", firstName.strip());
        System.out.format("'%s'", firstName.trim());
        System.out.format("'%s'", firstName.stripIndent());
        System.out.format("'%s'", strip(firstName));
    }
        public static String strip(String text) {
        return text.replace(" ", "");
    }

//        Getting Individual Characters of a String
    public static void getIndividualChars() {
        String myText4 = "Apples";
        String middleName = "Christopher";
        int length = myText4.length();
//        protecting from out of range exceptions
        if (length > 1) {
            System.out.println(myText4.charAt(0));
        }
    }

    public static void compareForAlphabeticalOrder() {
//        if the first string comes before the second string then the compareTo() method returns a negative number <0
//        if same as 2nd string then returns 0
//        if 1st after 2ns then returns >0
        String firstWord = "Apple";
        String secondWord = "apple";

        System.out.println(firstWord.compareToIgnoreCase(secondWord));

        System.out.println(compareToIgnoreCase("Boat", "boat"));
    }

        public static int compareToIgnoreCase(String text1, String text2) {
        String lowerText1 = text1.toLowerCase();
        String lowerText2 = text2.toLowerCase();
        return lowerText1.compareTo(lowerText2);
    }

    public static void contains() {
        String myText = "Four score and sevens years ago";
        System.out.println(myText.contains("seven"));
    }

//        String Concatenation
    public static void stringConcatenation() {
        String text1 = "this is my text1";
        String text2 = "this is my text2";
//        Inefficient in terms of memory
        System.out.println(text1 + text2);

        System.out.println(text1.concat(text2));

        System.out.println("my string literal".concat("second string literal "));
//        More efficient in terms of memory, especially inside of loops
//        No args default constructor
//        String finalString = new StringBuilder()
//        String builder can take args which tell it exactly how long the string is going to be and therefore exactly how much memory to allocate, which can make your programme faster and more efficient
        String finalString = new StringBuilder(text1.length() + text2.length() + 1)
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();
        System.out.println(finalString);

//        Does exactly same thing as StringBuffer - older method, but has issues with re. running threads simultaneously. StringBuffer is 'thread safe', which means multiple threads rae able to interact with the instance
//        With the instance of the stringbuffer safely, however this thread safety comes at cost of performance, becuase the extra precautions it has to take to protect its data from one thread to another makes it slower
//        and in the vast level of cases developers dont actually need that level of thread safety for something like string Buffer. Hence Sun Microsystems created StringBuilder.
        String otherFinalString = new StringBuffer()
                .append(text1)
                .append(" ")
                .append(text2)
                .toString();

        System.out.format("%s %s\n", text1, text2);
        String oneMoreFinalString = String.format("%s %s", text1, text2);
        System.out.println(oneMoreFinalString);
    }

//        Determining the length of a string
    public static void determineLength() {
        String myText = "for score and seven years ago";
        System.out.println(myText.length());
        char[] chars = myText.toCharArray();
        int index = 23;
        if (index < myText.length()) {
            System.out.println(chars[index]);
        }
//        String myText2 = "for";
        String secondText = "score";
        StringBuilder builder = new StringBuilder(myText.length() + secondText.length())
                .append(myText)
                .append(secondText);
    }

        public static void subString() {
            String myText = "apple";
//            start at 1st(0) char and then go up to but not including the 2nd(1) char but don't include it.
//            Easier to think of 2nd param as length, but technically it refers to the non-inclusive index of the char that you want to go up to.
            String firstPart = myText.substring(0, 1);
            String secondPart = myText.substring(1);
            String capitalizedFirstLetter = firstPart.toUpperCase();
//            String myNewText = capitalizedFirstLetter.concat(secondPart);
//            String myNewText = new StringBuilder(capitalizedFirstLetter)
//                    .append(secondPart).toString();
//            String myNewText = new StringBuilder()
//                    .append(capitalizedFirstLetter)
//                    .append(secondPart)
//                    .toString();
//            Optimized StringBuilder
            int capacity = capitalizedFirstLetter.length() + secondPart.length();
            String myNewText = new StringBuilder(capacity)
                    .append(capitalizedFirstLetter)
                    .append(secondPart)
                    .toString();
            System.out.println(myNewText);
        }

// indexOf() - popular/overused; several variations
// number in args, i.e. indexOf(65) = numerical val of char in Unicode encoding (65='A'), not index in array
// indexOf stops when it finds the first match
// -1 = no match
    //    Real-world implementation, except for the static methods, though also possible to use a more concise method using RegEx!
    //    split() - splits string into an array of strings, by looking for a 'delimiter', a char or substring that typically would repeat itself within the greater string

    public static void searchWithinAString() {
//        String myText = "four score and seven years ago";
        String myText = "ABCDEFGABCDEFG";

        System.out.println(myText.indexOf("A"));
        System.out.println(myText.lastIndexOf("A"));
//        skip past no of chars and start from there:
        System.out.println(myText.indexOf("A", 2));
    }

    public static void parsePhoneNumber(String phoneNum) {
        String phoneNumber = phoneNum.strip();
        String areaCode = parseAreaCode(phoneNumber);
        String exchange = parseExchange(phoneNumber);
        String lineNumber = parseLineNumber(phoneNumber);

        System.out.println(areaCode);
        System.out.println(exchange);
        System.out.println(lineNumber);
    }

    public static String parseAreaCode(String phoneNumber) {
        int openParens = phoneNumber.indexOf("(");
        int closeParens = phoneNumber.indexOf(")");
        String areaCode = phoneNumber.substring(openParens + 1, closeParens);
        return areaCode;
    }

    public static String parseExchange(String phoneNumber) {
        int startExchangeIndex = phoneNumber.indexOf(" ");
        int endExchangeIndex = phoneNumber.indexOf("-");
        String exchange = phoneNumber.substring(startExchangeIndex + 1, endExchangeIndex);
        return exchange;
    }

    public static String parseLineNumber(String phoneNumber) {
//        int startLineNumberIndex = phoneNumber.indexOf("-");
//        int endLineNumberIndex = phoneNumber.length();
//        No need to specify end index in substring() method as if unspecified goes to end anyway.
//        String lineNumber = phoneNumber.substring(startLineNumberIndex + 1, endLineNumberIndex);
//        return lineNumber;
        int startLineNumberIndex = phoneNumber.indexOf("-");
        String lineNumber = phoneNumber.substring(startLineNumberIndex + 1);
        return lineNumber;
    }

//    \n char = invisible in csv ("comma separated value")
//    split() is powerful
    public static void splitStringApart() {
        String text = """
                Smith,Fred,01/01/1979,1111 ABC St.,Apple,CA
                McGuire,Jerry,02/02/1980,2222 Def St.,Orange,NV
                Flintstone,Fred,03/03/1981,3333 GHI st.,Pineapple,IL
                Rubble,Barney,04/04/1982,4444 JKL St.,Pear,MO
                """;
//        end of line - ctrl+alt+v
//        String[] people = text.split("\n");
//        limit the number of elements to search for
        String[] people = text.split("\n", 2);
        System.out.println(people.length);
//        alt+shift+cursor = select multiple lines
        System.out.println(people[1]);
        String[] person = people[1].split(",");
        System.out.println(person[2]);
    }

    public static void startsWithEndsWith() {
        String filename = "   file001.txt";

        String strippedString = filename.strip();

        System.out.println(strippedString.endsWith(".txt"));
        System.out.println(strippedString.endsWith(".doc"));

        System.out.println(strippedString.startsWith("file"));
        System.out.println(strippedString.startsWith("azfile"));
    }

    public static void contentEquals() {
//        String and StringBuffer are both character sequences, and both are permissible for use with the contentEquals() method
        String firstText = "Apple";
        StringBuffer secondText = new StringBuffer("Apple");
//
        System.out.println(firstText.contentEquals(secondText));
//        equals() is stricter, will only allow to compare two strings
        System.out.println(firstText.equals(secondText));
    }

    public static void person(String firstName, String lastName) {
        String fName = firstName;
        String lName = lastName;

        String fullName = firstName.toUpperCase() + ' ' + lastName.toUpperCase();
        System.out.println(fullName);
    }

    public static void catToDog(String text) {
        String catToDog = text.replace("cat", "dog");
        System.out.println(catToDog);
    }

    public static void noUnintendedSpaces(String text) {
        String strip = text.strip();
        System.out.println(strip);
    }

    public static void capitalizeLastLetter(String text) {
        String strippedText = text.strip();
        int lastIndex = strippedText.length() - 1;
        String lastChar = String.valueOf(strippedText.charAt(lastIndex));
        String capitalizedLastChar = lastChar.toUpperCase();
        String firstPart = strippedText.substring(0, lastIndex);
        String finalString = firstPart + capitalizedLastChar;

        System.out.println(finalString);
    }

    public static void parseAddress(String text) {
        String splitString = text.replace(" ", "\n");
        System.out.println(splitString);
    }
}
