public class BigNumberHome {
    private int[] digits; // Array to store each digit, assuming a maximum length of 1000

    public BigNumberHome(String number) {
        digits = new int[1000]; // Assuming maximum length of 1000
        int length = number.length();
        for (int i = 0; i < length; i++) {
            digits[999 - i] = number.charAt(length - 1 - i) - '0';
//            System.out.println(digits[999 - i]);
        }
    }

    // Method to add two LargeNumber objects
    public BigNumberHome add(BigNumberHome other) {
        BigNumberHome result = new BigNumberHome("0");
        int carry = 0;
        for (int i = 999; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    // Static method to add multiple LargeNumber objects
    public static BigNumberHome addMultiple(BigNumberHome[] numbers) {
        BigNumberHome sum = new BigNumberHome("0");
        for (BigNumberHome number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    public BigNumberHome multiply(BigNumberHome other) {
        BigNumberHome result = new BigNumberHome("0");
        for (int i = 999; i >= 0; i--) {
            int carry = 0;
            BigNumberHome temp = new BigNumberHome("0");
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
        BigNumberHome[] numbers = {
            new BigNumberHome("123456"),
            new BigNumberHome("12"),
            new BigNumberHome("123456789012345678901234567890")
        };
        BigNumberHome sum = BigNumberHome.addMultiple(numbers);

        BigNumberHome n1 = new BigNumberHome("123");
        BigNumberHome n2 = new BigNumberHome("134");


        System.out.println(n1.multiply(n2).toString());
//        System.out.println(sum.toString());
    }
}
