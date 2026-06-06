import java.util.*;

public class WeightedDirectedGraph {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + to + ", " + weight + ")";
        }
    }

    private int V;
    private List<List<Edge>> adj;

    public WeightedDirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}
