import java.math.BigInteger;

public class BigNumberHome2 {
    private int[] digits; // Array to store each digit, assuming a maximum length of 1000

    public BigNumberHome2(String number) {
        digits = new int[1000]; // Assuming maximum length of 1000
        int length = number.length();
        digits[0] = number.length();
        for (int i = 1; i < length + 1; i++) {
            digits[i] = number.charAt(i - 1) - '0';
        }
    }

    // Method to add two LargeNumber objects
    public BigNumberHome2 add(BigNumberHome2 other) {
        int maxLen = Math.max(this.digits[0], other.digits[0]);
        BigNumberHome2 result = new BigNumberHome2("0");
        result.digits[0] = maxLen; // Assume result length to be the max of both
        int carry = 0;

        for (int i = maxLen; i > 0; i--) {
            int d1 = i <= this.digits[0] ? this.digits[i] : 0;
            int d2 = i <= other.digits[0] ? other.digits[i] : 0;
            int sum = d1 + d2 + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry > 0) {
            // Handle carry at the most significant digit
            if (result.digits[0] < 999) {
                result.digits[0]++;
                for (int i = result.digits[0]; i > 1; i--) {
                    result.digits[i] = result.digits[i - 1];
                }
                result.digits[1] = carry;
            }
        }
        return result;
    }


    // Static method to add multiple LargeNumber objects
    public static BigNumberHome2 addMultiple(BigNumberHome2[] numbers) {
        BigNumberHome2 sum = new BigNumberHome2("0");
        for (BigNumberHome2 number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public BigNumberHome2 multiply(BigNumberHome2 other) {
        BigNumberHome2 result = new BigNumberHome2("0");
        for (int i = 1; i <= this.digits[0]; i++) {
            BigNumberHome2 temp = new BigNumberHome2("0");
            temp.digits[0] = i + other.digits[0] - 1; // Initial length of partial product
            int carry = 0;

            for (int j = 1; j <= other.digits[0]; j++) {
                int product = this.digits[i] * other.digits[j] + carry;
                temp.digits[i + j - 1] = product % 10;
                carry = product / 10;
            }

            if (carry > 0) {
                temp.digits[temp.digits[0] + 1] = carry;
                temp.digits[0]++;
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

        BigNumberHome2 n1 = new BigNumberHome2("123");
        BigNumberHome2 n2 = new BigNumberHome2("999");

//        System.out.println(n1);
//        System.out.println(n1.multiply(n2).toString());
        System.out.println(n1.add(n2));

        BigInteger b1 = new BigInteger("123");
        BigInteger b2 = new BigInteger("999");
        System.out.println(b1.add(b2));
    }
}
