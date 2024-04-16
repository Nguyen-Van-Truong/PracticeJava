import java.math.BigInteger;

public class BigNumber {
    int[] digit;
    int len;
    private static final int MAX_DIGITS = 1000;

    public BigNumber(String number) {
        this.digit = new int[MAX_DIGITS];
        this.len = number.length();
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            digit[i] = Character.getNumericValue(number.charAt(j));
        }
    }

    public void addBigNumber(BigNumber that) {
        BigNumber result = new BigNumber("0");
        int max = this.len > that.len ? this.len : that.len;
        this.len = max;
        int mem = 0, total;

        for (int i = 0; i < max; i++) {
            total = mem + this.digit[i] + that.digit[i];
            mem = total / 10;
            this.digit[i] = total % 10;
        }

        if (mem > 0) {
            this.digit[max] = mem;
            this.len++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(digit[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String n1 = "789798798798798798978";
        String n2 = "98797899879878989899999999999";

        // Create two BigNumber instances with large numbers
        BigNumber number1 = new BigNumber(n1);
        BigNumber number2 = new BigNumber(n2);

        // Display the numbers before addition
        System.out.println("BigNumber 1: " + number1);
        System.out.println("BigNumber 2: " + number2);

        // Add the numbers together using BigNumber
        number1.addBigNumber(number2);

        // Display the result after addition
        System.out.println("BigNumber Sum: " + number1);

        // Now using BigInteger for comparison

        BigInteger bigInt1 = new BigInteger(n1);
        BigInteger bigInt2 = new BigInteger(n2);

        // Add the numbers together using BigInteger
        BigInteger bigIntSum = bigInt1.add(bigInt2);

        // Display the result after addition
        System.out.println("BigInteger Sum: " + bigIntSum);

        // Compare results
        System.out.println("Results are the same: " + number1.toString().equals(bigIntSum.toString()));
    }
}
