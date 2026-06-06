import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cf333 {

// The following solution exceeded time limit and the reason is:
// ❌ ISSUE 1: Graph treated as directed
// Current:
// for(int[] i: edges) adj.get(i[0]).add(i[1]);
// Problem: Bipartite check assumes an undirected graph.
// Fix: Add both directions
// adj.get(i[0]).add(i[1]);
// adj.get(i[1]).add(i[0]);

// ❌ ISSUE 2: Marking visited too early
// Current:
// hasVisited[i] = 1;
// Problem: Marking visited before validating color conflict can hide incorrect states.
// Fix: First check for color conflict, then mark/process the node.

// ❌ ISSUE 3: Re-adding already visited nodes to queue
// Current: No check before adding to queue
// Problem: Same node may be added multiple times → inefficiency + possible incorrect traversal
// Fix:
// if(hasVisited[i] == 0) {
//     q.add(i);
// }

// ⚠️ ISSUE 4: Color initialization for disconnected components
// Current:
// colours[0] = 1;
// Problem: Only first component is initialized; others may remain uncolored (0)
// Fix: Initialize color when starting BFS for each component
// if(colours[i] == 0) colours[i] = 1;

// ⚠️ ISSUE 5: Queue reuse across multiple BFS calls
// Current:
// isBipartiteUtil(q, ...)
// Problem: Shared queue may retain stale data between calls
// Fix: Create a fresh queue inside BFS function
// Queue<Integer> q = new LinkedList<>();

//    class Solution {
//        public boolean isBipartite(int V, int[][] edges) {
//            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//            for(int i=0; i<V; i++) adj.add( new ArrayList<>() );
//            int[] colours = new int[V];
//            int[] hasVisited = new int[V];
//
//            for(int[] i: edges) adj.get( i[0] ).add( i[1] );
//
//            //painting first node with colour 1
//            colours[0] = 1;
//
//            //loop check - bfs
//            Queue<Integer> q = new LinkedList<>();
//
//            for(int i=0; i<V; i++) {
//                if(hasVisited[i]==0) {
//                    if(isBipartiteUtil(q, i, colours, adj, hasVisited) == false) return false;
//                }
//            }
//
//            return true;
//        }
//
//        static boolean isBipartiteUtil (Queue<Integer> q, int x, int[] colours, ArrayList<ArrayList<Integer>> adj, int[] hasVisited) {
//            q.add(x);
//            hasVisited[x] = 1;
//
//            while(!q.isEmpty()) {
//                int selectedNode = q.poll();
//
//                int toBeColouredWith = colours[selectedNode]==1 ? 2 : 1;
//
//                for(int i: adj.get(selectedNode)){
//                    hasVisited[i] = 1;
//                    if(colours[i]!=0 && colours[i]!=toBeColouredWith) return false;
//
//                    colours[i] = toBeColouredWith;
//
//                    q.add(i);
//                }
//            }
//
//            return true;
//        }
//    }

    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Undirected graph
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] colours = new int[V];

        for(int i = 0; i < V; i++) {
            if(colours[i] == 0) {
                if(!bfs(i, colours, adj)) return false;
            }
        }

        return true;
    }



    static boolean bfs(int start, int[] colours, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colours[start] = 1;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei : adj.get(node)) {
                if(colours[nei] == 0) {
                    colours[nei] = 3 - colours[node]; // toggle 1 ↔ 2
                    q.add(nei);
                }
                else if(colours[nei] == colours[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int v1 = 3;
        int[][] edges1 = {
                {0,1},
                {1,2}
        };

        int v2 = 4;
        int[][] edges2 = {
                {0, 3},
                {1, 2},
                {3, 2},
                {0, 2}
        };

        cf333 soln = new cf333();

        System.out.println( soln.isBipartite(v2, edges2) );
    }
}
