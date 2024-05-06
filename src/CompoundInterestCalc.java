import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CompoundInterestCalc {

    // final: should not be changed after it has been created. Make final if possible.
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
        // In real life probably wouldn't want to be passing in formatted strings like this as they are highly opinionated
        // However a programme with a UI may want to accept a variety of formats, perhaps b using RegExt to parse
        BigDecimal balance = CompoundInterestCalc.calculate("£25,300.00", "8%", 10, "£7,500");
        System.out.println(moneyFormatter.format(balance)); // £36,075.81

    }
}
