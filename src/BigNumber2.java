import java.math.BigInteger;

public class BigNumber2 {
    private int[] digits; // Array to store each digit, assuming a maximum length of 1000

    public BigNumber2(String number) {
        digits = new int[1000]; // Assuming maximum length of 1000
        int length = number.length();
        digits[0] = number.length();
        for (int i = 1; i < length + 1; i++) {
            digits[i] = number.charAt(i - 1) - '0';
        }
    }

    // Method to add two LargeNumber objects
    public BigNumber2 add(BigNumber2 other) {
        BigNumber2 result = new BigNumber2("0");
        int carry = 0;
        int newLength = Math.max(this.digits[0], other.digits[0]) + 3;
        result.digits[0] = newLength;
//        System.out.println(digits[0] + " " + other.digits[0]);
        for (int i = digits[0]; i >= 1; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            System.out.println(result);
            carry = sum / 10;
        }
        return result;
    }

    // Static method to add multiple LargeNumber objects
    public static BigNumber2 addMultiple(BigNumber2[] numbers) {
        BigNumber2 sum = new BigNumber2("0");
        for (BigNumber2 number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public BigNumber2 multiply(BigNumber2 other) {
        BigNumber2 result = new BigNumber2("0");
        for (int i = 999; i >= 0; i--) {
            int carry = 0;
            BigNumber2 temp = new BigNumber2("0");
            for (int j = 999, k = i; j >= 0 && k >= 0; j--, k--) {
                int product = this.digits[j] * other.digits[k] + carry;
                temp.digits[k] = product % 10;
                carry = product / 10;
            }
            result = result.add(temp);
        }
        return result;
    }

    @Override
    public String toString() {
        int length = digits[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        BigNumber2[] numbers = {
//                new BigNumber2("123456"),
//                new BigNumber2("12"),
//                new BigNumber2("123456789012345678901234567890")
//        };
//        BigNumber2 sum = BigNumber2.addMultiple(numbers);

        BigNumber2 n1 = new BigNumber2("123");
        BigNumber2 n2 = new BigNumber2("999");

//        System.out.println(n1);
//        System.out.println(n1.multiply(n2).toString());
        System.out.println(n1.add(n2));

        BigInteger b1 = new BigInteger("123");
        BigInteger b2 = new BigInteger("999");
        System.out.println(b1.add(b2));
    }
}
