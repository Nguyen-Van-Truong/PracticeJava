import java.util.logging.Logger;

public class MyBigNumber {
    private static final Logger LOGGER = Logger.getLogger(MyBigNumber.class.getName());

    public String sum(String stn1, String stn2) {
        if (stn1.length() < stn2.length()) {
            String temp = stn1;
            stn1 = stn2;
            stn2 = temp;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;

        int length1 = stn1.length();
        int length2 = stn2.length();
        for (int i = 0; i < length1; i++) {
            int digit1 = stn1.charAt(length1 - 1 - i) - '0';
            int digit2 = (i < length2) ? stn2.charAt(length2 - 1 - i) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;

            // Ghi log cho mỗi bước cộng
            LOGGER.info("Step " + (i + 1) + ": " + digit1 + " + " + digit2 + " + carry = " + sum + ", Result: " + (sum % 10) + ", New carry: " + carry);
        }

        // Xử lý nếu còn nhớ (carry)
        if (carry > 0) {
            result.append(carry);
            LOGGER.info("Final carry: " + carry);
        }

        // Đảo ngược kết quả
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MyBigNumber myBigNumber = new MyBigNumber();
        String stn1 = "1234";
        String stn2 = "897";
        String result = myBigNumber.sum(stn1, stn2);
        System.out.println("Sum of " + stn1 + " and " + stn2 + " is: " + result);
    }
}