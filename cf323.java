import java.util.ArrayList;

public class cf323 {
    public static boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add( new ArrayList<>() );

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        for (int i=0; i<V; i++) {
            if(!visited[i] && isCycleUtilDFS(i, visited, adj)) return true;
        }

        return false;
    }

    static boolean isCycleUtilDFS(
            int curr,
            boolean[] visited,
            ArrayList<ArrayList<Integer>> adj
    ) {
        //System.out.println(curr+" -> p:"+parent);
        if(visited[curr]) return true;

        visited[curr] = true;

        for (int neighbour: adj.get(curr)) {
            if(
                    isCycleUtilDFS(neighbour, visited, adj)
            ) return true;
        }

        visited[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V1 = 25;
        int[][] edges1 = {
                // Component 1: Diamond (0-4)
                {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4},

                // Component 2: Chain (5-9)
                {5, 6}, {6, 7}, {7, 8}, {8, 9},

                // Component 3: Bifurcating Tree (10-15)
                {10, 11}, {10, 12}, {11, 13}, {12, 14}, {14, 15},

                // Component 4: Converging Star (16-20)
                {16, 20}, {17, 20}, {18, 20}, {19, 20},

                // Component 5: Small Path (21-23)
                {21, 22}, {22, 23}

                // Component 6: Vertex 24 (Isolated)
        };

        int V2 = 5; // Vertices 0, 1, 2, 3, 4
        int[][] edges2 = {
                {0, 1},
                {4, 3},
                {0, 2},
                {3, 4}, // <--- Cycle with {4, 3}
                {1, 0}, // <--- Cycle with {0, 1}
                {1, 3},
                {2, 0}, // <--- Cycle with {0, 2}
                {2, 3}
        };

        System.out.println( isCycle( V2, edges2 ) );
    }
}
