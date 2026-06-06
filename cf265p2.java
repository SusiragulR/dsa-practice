import java.util.*;

public class cf265p2 {
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int src, int target) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] j: edges){
            adj.get(j[0]).add(j[1]);
            adj.get(j[1]).add(j[0]);
        }

        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        parent[src] = src;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (parent[it] == -1) {
                    parent[it] = node;
                    q.add(it);
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();

        int current = target;

        if (parent[target] == -1) return path; // no path exists from source -> target

        while (current != parent[current]) {
            path.add(current);
            current = parent[current];
        }
        path.add(src);

        Collections.reverse(path);

        return path;
    }
}
