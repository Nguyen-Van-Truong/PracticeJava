public class LargeNumber {
    private int[] digits; // Array to store each digit, assuming a maximum length of 1000

    public LargeNumber(String number) {
        digits = new int[1000]; // Assuming maximum length of 1000
        int length = number.length();
        for (int i = 0; i < length; i++) {
            digits[999 - i] = number.charAt(length - 1 - i) - '0';
        }
    }

    // Method to add two LargeNumber objects
    public LargeNumber add(LargeNumber other) {
        LargeNumber result = new LargeNumber("0");
        int carry = 0;
        for (int i = 999; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    // Static method to add multiple LargeNumber objects
    public static LargeNumber addMultiple(LargeNumber[] numbers) {
        LargeNumber sum = new LargeNumber("0");
        for (LargeNumber number : numbers) {
            sum = sum.add(number);
        }
        return sum;
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
        LargeNumber[] numbers = {
            new LargeNumber("999999999999999999999999999999"),
            new LargeNumber("1"),
            new LargeNumber("1234567890123456789012345678909999999999999999999999999")
        };
        LargeNumber sum = LargeNumber.addMultiple(numbers);
        System.out.println(sum.toString());
    }
}
