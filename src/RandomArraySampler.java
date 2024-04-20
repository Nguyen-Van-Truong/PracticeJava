import java.util.Random;

public class RandomArraySampler {
    // Method to shuffle the array and select n elements
    public static int[] getRandomElements(int[] arr, int n) {
        if (n > arr.length) {
            throw new IllegalArgumentException("n must be less than or equal to the length of the array");
        }

        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = i + rand.nextInt(arr.length - i);
            // Swap the elements
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }

        // Copy the first n elements to return
        int[] result = new int[n];
        System.arraycopy(arr, 0, result, 0, n);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 3; // Number of elements to select

        int[] randomElements = getRandomElements(arr, n);
        System.out.println("Randomly selected elements:");
        for (int element : randomElements) {
            System.out.print(element + " ");
        }
    }
}
