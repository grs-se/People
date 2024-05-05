import java.math.BigDecimal;

public class CompoundInterestCalc {
    public static BigDecimal calculate(String principal, String rate, int period, String contribution) { // period can be int as just a year, i.e. '2018'
        // Balance(Y) = P(1 + r)^y + c[ ((1 + r)^y - 1) / r]
        BigDecimal a = BigDecimal.ONE.add(new BigDecimal(rate)); // (1 + r) // abstract variable name 'a' because don't know what the finance term is for this operation
        BigDecimal b = a.pow(period); // (1 + r)^y
        BigDecimal c = b.subtract(BigDecimal.ONE); // ((1 + r)^y - 1) // slowly expand out, each individual calculation is quite simple
        BigDecimal d = c.divide(new BigDecimal(rate)); // ((1 + r)^y - 1) / r
        BigDecimal e = d.multiply(new BigDecimal(contribution)); // c[ ((1 + r)^y - 1) / r]
        BigDecimal f = b.multiply(new BigDecimal(principal)); // P(1 + r)^y
        BigDecimal g = f.add(e);
        return g;
    }

    public static void main(String[] args) {
        BigDecimal balance = CompoundInterestCalc.calculate("10000.00", ".08", 10, "1000");
        System.out.println(balance); // 230500.0000

    }
}
