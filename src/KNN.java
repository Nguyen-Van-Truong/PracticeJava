import java.util.*;

public class KNN {
    // Hàm tính khoảng cách Euclidean
    public static double euclideanDistance(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }

    // Hàm tìm k hàng xóm gần nhất
    public static String classify(double[][] trainData, int k, double[] testPoint) {
        int numFeatures = trainData[0].length - 1;
        PriorityQueue<double[]> heap = new PriorityQueue<>(Comparator.comparingDouble(a -> -euclideanDistance(Arrays.copyOf(a, numFeatures), testPoint)));

        // Thêm vào heap và giữ kích thước là k
        for (double[] instance : trainData) {
            heap.add(instance);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Đếm số lần xuất hiện của mỗi lớp trong k hàng xóm
        Map<String, Integer> count = new HashMap<>();
        while (!heap.isEmpty()) {
            double[] neighbor = heap.poll();
            String label = String.valueOf(neighbor[numFeatures]);
            count.put(label, count.getOrDefault(label, 0) + 1);
        }

        // Tìm lớp xuất hiện nhiều nhất
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        double[][] trainData = {
            {1.0, 2.0, 0.0},  // Điểm dữ liệu 1
            {1.5, 2.5, 0.0},  // Điểm dữ liệu 2
            {2.0, 3.0, 1.0},  // Điểm dữ liệu 3
            {5.0, 5.0, 1.0}   // Điểm dữ liệu 4
        };
        double[] testPoint = {1.0, 2.0};  // Điểm kiểm thử
        int k = 3;  // Số lượng hàng xóm
        System.out.println("Predicted Class: " + classify(trainData, k, testPoint));
    }
}
