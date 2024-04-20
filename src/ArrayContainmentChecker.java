public class ArrayContainmentChecker {
    public static boolean contains(int[] arr1, int[] arr2) {
        if (arr2.length > arr1.length) {
            return false; // arr2 cannot be larger than arr1
        }
        
        for (int i = 0; i <= arr1.length - arr2.length; i++) {
            boolean found = true;
            for (int j = 0; j < arr2.length; j++) {
                System.out.println("i: " + i + ", j: " + j + ", arr1[i + j]: " + arr1[i + j] + ", arr2[j]: " + arr2[j]);
                if (arr1[i + j] != arr2[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4};
        int[] arr3 = {3, 5};

//        System.out.println("Does arr1 contain arr2? " + contains(arr1, arr2)); // Expected: true
        System.out.println("Does arr1 contain arr3? " + contains(arr1, arr3)); // Expected: false
    }
}
