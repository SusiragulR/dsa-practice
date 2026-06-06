import java.util.ArrayList;

public class cf325 {
    static class Pair {
        int node;
        int weight;

        Pair(int x, int w) {
            this.node = x;
            this.weight = w;
        }
    }

    public static int isNegativeWeightCycle(int n, int[][] edges) {
        boolean[] visited = new boolean[n];

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add( new ArrayList<>() );

        for (int[] edge: edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        for (int i=0; i<n; i++) {
            if(!visited[i] && isCycleUtilDFS(i, 0, visited, adj)) return 1;
        }

        return 0;
    }

    static boolean isCycleUtilDFS(
            int curr,
            int weightSum,
            boolean[] visited,
            ArrayList<ArrayList<Pair>> adj
    ) {
        //System.out.println(curr);
        if(weightSum<0 && visited[curr]) return true;

        visited[curr] = true;

        for (Pair neighbour: adj.get(curr)) {
            //System.out.println(curr+" nNode:"+neighbour.node+" nEdgeWeight"+neighbour.weight);
            if(
                isCycleUtilDFS(neighbour.node, weightSum+ neighbour.weight, visited, adj)
            ) return true;
        }

        visited[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] edges1 = {
                {0, 1, - 1},
                {1, 2, - 2},
                {2, 0, - 3}
        };

        System.out.println( isNegativeWeightCycle(n1, edges1) );
    }
}
