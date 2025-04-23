package WishdomInterview.InterviewQuestion3;

import java.util.*;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Map<Integer, Bag<DirectedEdge>> adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new HashMap<>();
        for (int v = 0; v < V; v++) {
            adj.put(v, new Bag<>());
        }
    }

    public void addEdge(DirectedEdge edge) {
        int from = edge.from();
        adj.get(from).add(edge);
        E++;
    }

    public Collection<? extends DirectedEdge> adj(int v) {
        return adj.get(v);
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            list.addAll(adj(v));
        }
        return list;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V; v++) {
            sb.append("Dinh ").append(v).append(": ");
            for (DirectedEdge e : adj(v)) {
                sb.append(e).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
