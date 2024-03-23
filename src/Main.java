public class Main {
    public static void recursiveFunction(int n) {
        int localVariable = n * 2;
        if (n == 0) {
            return;
        }

        System.out.println(n + " " + localVariable);
        recursiveFunction(n - 1);
    }

    public static void main(String[] args) {
        recursiveFunction(3);
    }
}