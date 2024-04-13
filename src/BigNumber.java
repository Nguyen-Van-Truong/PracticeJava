public class BigNumber {
    private int[] digits; // Array to store each digit, assuming a maximum length of 1000

    public BigNumber(String number) {
        digits = new int[1000]; // Assuming maximum length of 1000
        int length = number.length();
        for (int i = 0; i < length; i++) {
            digits[999 - i] = number.charAt(length - 1 - i) - '0';
//            System.out.println(digits[999 - i]);
        }
    }

    // Method to add two LargeNumber objects
    public BigNumber add(BigNumber other) {
        BigNumber result = new BigNumber("0");
        int carry = 0;
        for (int i = 999; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    // Static method to add multiple LargeNumber objects
    public static BigNumber addMultiple(BigNumber[] numbers) {
        BigNumber sum = new BigNumber("0");
        for (BigNumber number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public BigNumber multiply(BigNumber other) {
        BigNumber result = new BigNumber("0");
        for (int i = 999; i >= 0; i--) {
            int carry = 0;
            BigNumber temp = new BigNumber("0");
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
        StringBuilder sb = new StringBuilder();
        boolean foundFirstNonZero = false;
        for (int digit : digits) {
            if (digit == 0 && !foundFirstNonZero) {
                continue;
            }
            foundFirstNonZero = true;
            sb.append(digit);
        }
        return foundFirstNonZero ? sb.toString() : "0";
    }

    public static void main(String[] args) {
        BigNumber[] numbers = {
            new BigNumber("123456"),
            new BigNumber("12"),
            new BigNumber("123456789012345678901234567890")
        };
        BigNumber sum = BigNumber.addMultiple(numbers);

        BigNumber n1 = new BigNumber("123");
        BigNumber n2 = new BigNumber("134");


        System.out.println(n1.multiply(n2).toString());
//        System.out.println(sum.toString());
    }
}
