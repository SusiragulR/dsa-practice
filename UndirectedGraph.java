import java.util.*;

public class UndirectedGraph {
    private int V; // number of vertices
    private List<List<Integer>> adj;

    public UndirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public List<Integer> getNeighbors(int u) {
        return adj.get(u);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}
