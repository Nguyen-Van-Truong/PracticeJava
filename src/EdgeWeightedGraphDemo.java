import java.util.LinkedList;
import java.util.Scanner;

// Lớp DirectedEdge đại diện cho mỗi cạnh có trọng số
class DirectedEdge {
    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d -> %d (%.2f)", from, to, weight);
    }
}

// Lớp EdgeWeightedDigraph đại diện cho đồ thị có trọng số
class EdgeWeightedDigraph {
    private final int V; // Số đỉnh
    private int E;       // Số cạnh
    private LinkedList<DirectedEdge>[] adj; // Danh sách kề cho các cạnh

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(DirectedEdge edge) {
        int from = edge.from();
        adj[from].add(edge);
        E++;
    }

    // Lấy các cạnh kề với đỉnh v
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // Hiển thị đồ thị
    public void displayGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (DirectedEdge e : adj(v)) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }
}

public class EdgeWeightedGraphDemo {
    public static void main(String[] args) {
        // Đọc dữ liệu từ tinyEWD.txt (giả lập dữ liệu dưới đây)
        String input = "8\n15\n4 5 0.35\n5 4 0.35\n4 7 0.37\n5 1 0.32\n0 4 0.38\n0 2 0.26\n1 3 0.29\n3 6 0.52\n6 4 0.93";
        Scanner scanner = new Scanner(input);

        // Đọc số đỉnh và cạnh
        int V = scanner.nextInt(); // Số đỉnh
        int E = scanner.nextInt(); // Số cạnh

        // Tạo đồ thị có trọng số
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(V);

        // Đọc các cạnh và thêm vào đồ thị
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            double weight = scanner.nextDouble();
            DirectedEdge edge = new DirectedEdge(from, to, weight);
            graph.addEdge(edge);
        }

        // Hiển thị đồ thị
        System.out.println("Edge-weighted Digraph Representation:");
        graph.displayGraph();
    }
}
