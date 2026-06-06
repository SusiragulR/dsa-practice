import java.util.ArrayList;

public class cf324 {
    // detect cycle in an undirected graph
    public static boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add( new ArrayList<>() );

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i=0; i<V; i++) {
            if(!visited[i] && isCycleUtilDFS(i, -1, visited, adj)) return true;
        }

        return false;
    }

    static boolean isCycleUtilDFS(
            int curr,
            int parent,
            boolean[] visited,
            ArrayList<ArrayList<Integer>> adj
    ) {
        //System.out.println(curr+" -> p:"+parent);
        if(visited[curr]) return true;

        visited[curr] = true;

        for (int neighbour: adj.get(curr)) {
            if(
                parent!=neighbour &&
                isCycleUtilDFS(neighbour, curr, visited, adj)
            ) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int V1 = 21;
        int[][] edges1 = {
                // Component 1 (Star)
                {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
                // Component 2 (Path)
                {6, 7}, {7, 8}, {8, 9},
                // Component 3 (Small Tree)
                {10, 11}, {10, 12}, {11, 13}, {11, 14},
                // Component 4 (Path)
                {15, 16}, {16, 17},
                // Component 5 (Edge)
                {18, 19}
                // Component 6 (Vertex 20) has no entries here!
        };

        System.out.println( isCycle( V1, edges1 ) );
    }
}
