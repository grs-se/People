import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompoundInterestCalc {

    // final: should not be changed after it has been created. Make final if possible.
    // NumberFormat returns your locale by default
    // should prefer to use these NumberFormat methods
    private static final NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    public static BigDecimal calculate(String principal, String rate, int period, String contribution) throws ParseException { // period can be int as just a year, i.e. '2018'
        // Balance(Y) = P(1 + r)^y + c[ ((1 + r)^y - 1) / r]
        String rateAsPercent = percentFormatter.parse(rate).toString();
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rateAsPercent)); // (1 + r) // abstract variable name 'a' because don't know what the finance term is for this operation
        BigDecimal b = a.pow(period); // (1 + r)^y
        BigDecimal c = b.subtract(BigDecimal.ONE); // ((1 + r)^y - 1) // slowly expand out, each individual calculation is quite simple
        BigDecimal d = c.divide(new BigDecimal(rateAsPercent)); // ((1 + r)^y - 1) / r
        BigDecimal e = d.multiply(new BigDecimal(moneyFormatter.parse(contribution).toString())); // c[ ((1 + r)^y - 1) / r]
        BigDecimal f = b.multiply(new BigDecimal(moneyFormatter.parse(principal).toString())); // P(1 + r)^y
        BigDecimal g = f.add(e);
        return g;
    }

    public static void main(String[] args) throws ParseException {
        // this is far inferior to using the getCurrencyInstance which out of the box has a formatter for every place in the world and you dont even have to know those rules
//        DecimalFormat df = new DecimalFormat("£#,###.##");
//        DecimalFormat df = new DecimalFormat("£#,###.##;£(#)"); // right of semi-colon = negative
//        DecimalFormat df = new DecimalFormat("£#,###.00;£(#)"); // give us padding of two decimals - always two decimals
        DecimalFormat df = new DecimalFormat("£00000000,000.00;£(#)"); // £00,000,163,270.02 = padding to left of decimal
        DecimalFormat pf = new DecimalFormat("#%"); // 8% // multiply that value by 100, i.e. move decimal point over to right by 2 places: .08 = 8
        // In real life probably wouldn't want to be passing in formatted strings like this as they are highly opinionated
        // However a programme with a UI may want to accept a variety of formats, perhaps b using RegExt to parse
        BigDecimal balance = CompoundInterestCalc.calculate("£25,300.00", "8%", 10, "£7,500");
        System.out.println(df.format(balance)); // £163,270.02
        System.out.println(df.format(balance.negate())); // £(163,270.02)
        System.out.println(pf.format(.08));
        //
        // Additional ways to format numbers:
        System.out.printf("%f%n", balance); // 163270.020925 # format this variable as a floating point number and then put a new line after it: %f = floating point, %n = smart enough to new line across different platforms
        System.out.printf("$%.2f%n", balance); // $163270.02 # 2 decimal places
        System.out.printf("$%,.2f%n", balance); // $163,270.02 # comma flag = grouping
        System.out.printf("$%,(.2f%n", balance.negate()); // $(163,270.02) # negative numbers # ( = just a flag, not explicitly telling where to put the parentheses;
        // Only scratching the surface with printf, check docs
        // Far more formatting options, espeically with Date and Time
        // can also use format() method, printf() actually calls the format() method; printf inspired by C lang, Java wanted to have same method name
        System.out.format("$%,(.2f%n", balance.negate()); // $(163,270.02)
        // String.format() = same thing
        String myMoney = String.format("$%,(.2f%n", balance.negate());
        System.out.println(myMoney); // $(163,270.02)
        // Let's say you want to append or concatenate a bunch of strings beyond just 1 value
        // i.e. myMoney.concat().split()
        // professionally going to use String.format() to format data, rather than just printf or printLn,

    }
}