import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParser {
    public static void main(String[] args) {
        String transcript = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;
        String regex = """
        Student\\sNumber:\\s(?<studentNum>\\d{10}).* # Get student number
        Grade:\\s+(?<grade>\\d{1,2}).* # Get grade
        Birthdate:\\s+(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}).* # Get birthdate
        Gender:\\s+(?<gender>\\w+)\\b.* # Get grade # One or more word characters followed by a word boundary
        State\\sID:\\s+(?<stateID>\\d+)\\b.*? # Get state ID
        Cumulative.*?(?<weightedGPA>[\\d\\.]+)\\b.* # Get the weighted GPA
        #Weighted\\)\\s+(?<weightedGPA>[\\d\\.]+)\\b.* # Get the weighted GPA
        #Unweighted\\)\\s+(?<unweightedGPA>[\\d\\.]+)\\b.* # Get the unweighted GPA
        """;

        // Pattern.DOTALL = flag (flags in programming are things that we toggle on or off)
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(transcript);
        if (mat.matches()) {
            System.out.println(mat.group("studentNum"));
            System.out.println(mat.group("grade"));
            System.out.println(mat.group("birthMonth"));
            System.out.println(mat.group("birthDay"));
            System.out.println(mat.group("birthYear"));
            System.out.println(mat.group("gender"));
            System.out.println(mat.group("stateID"));
            System.out.println(mat.group("weightedGPA"));
//            System.out.println(mat.group("unweightedGPA"));
        }
        // * = GREEDY OPERATOR - grabs everything and works backwards
        // * = greedy, wants to consume as many chars as it can
        // it will go from * to end of string and then it will go backwards until it finds something that matches the expression
    // *? = will go forwards rather than backwards, so not greedy


    }
}
