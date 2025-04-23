package TymexQuestion2Chalenge2;

public class MissingNumberFinder {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int sumExpected = (n + 1) * (n + 2) / 2;
        int sumActual = 0;
        for (int num : arr) {
            sumActual += num;
        }

        return sumExpected - sumActual;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 6, 4};
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);
    }
}
