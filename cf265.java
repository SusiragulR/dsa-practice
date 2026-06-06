import java.util.ArrayList;

public class cf265 {
    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // Undirected graph
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] colours = new int[v];

        return recursiveMColourCheck(0, colours, m, adj, v);
    }

//    static boolean recursiveMColourCheck (int node, int[] colours, int m, ArrayList<ArrayList<Integer>> adj) {
//        for (int clr = 1; clr <= m; clr++) {
//            colours[node] = clr;
//            for (int neighbour: adj.get(node)) {
//                if(isColourCriteriaPassed(node, colours, adj)) {
//                    if( colours[neighbour]==0 && recursiveMColourCheck( neighbour, colours, m, adj) ) return true;
//                }
//            }
//            colours[node] = 0;
//        }
//
//        return false;
//    }
//
// THE ABOVE CODE HAS THE FOLLOWING ISSUES:
//
// ❌ Issue 1: Incorrect recursion strategy
// The algorithm uses DFS on neighbors (node → neighbour → neighbour),
// but graph coloring requires assigning colors sequentially to all nodes (0 → v-1).
//  You’re doing:
//    node → neighbor → neighbor → ...
//  But correct approach should be:
//    node0 → node1 → node2 → ... → nodeN
//  👉 i.e., process nodes sequentially, not via adjacency traversal.

// ❌ Issue 2: Premature success return
// The function returns true as soon as one neighbor recursion succeeds,
// without ensuring all nodes are properly colored.

// ❌ Issue 3: No global completion check
// There is no condition to verify that all vertices have been assigned valid colors
// before returning true.

// ❌ Issue 4: Redundant / incorrect neighbor recursion
// Recursively calling all neighbors leads to repeated and unnecessary traversals,
// and does not correctly explore all color assignments.

// ❌ Issue 5: Backtracking is incomplete
// The algorithm does not properly backtrack across different nodes,
// only partially resetting colors, which may lead to incorrect results.

// ❌ Issue 6: Missing ordered traversal of vertices
// Graph coloring should process nodes in a fixed order (e.g., 0 to v-1),
// but current logic depends on adjacency, which is incorrect.

// ❌ Issue 7: Potential infinite recursion (partially fixed)
// Earlier version could revisit already-colored nodes causing infinite loops.
// Even with the fix (colours[neighbour] == 0), overall logic is still flawed.

// ❌ Issue 8: Constraint check placed incorrectly
// isColourCriteriaPassed is checked inside neighbor loop,
// but it should be validated once per color assignment before recursion.

// ❌ Issue 9: Does not explore full solution space
// The algorithm does not systematically try all possible color assignments
// for all nodes, leading to incorrect true/false results.

// ❌ Issue 10: Not aligned with standard m-coloring backtracking approach
// Standard solution assigns color → validate → recurse to next node → backtrack,
// which is not followed here.

    boolean recursiveMColourCheck (int node, int[] colours, int m, ArrayList<ArrayList<Integer>> adj, int v) {
        if (node == v) return true; // all nodes colored

        for (int clr = 1; clr <= m; clr++) {
            colours[node] = clr;

            if (isColourCriteriaPassed(node, colours, adj)) {
                if (recursiveMColourCheck(node + 1, colours, m, adj, v)) return true;
            }

            colours[node] = 0;
        }

        return false;
    }

    static boolean isColourCriteriaPassed (int node, int[] colours, ArrayList<ArrayList<Integer>> adj) {
        for (int nei: adj.get(node)) if(colours[nei]==colours[node]) return false;
        return true;
    }

    public static void main(String[] args) {
        int v1 = 10;
        int[][] edges1 = {
                {0,1}, {0,2}, {0,3},
                {1,2}, {1,4},
                {2,3}, {2,5},
                {3,6},
                {4,5}, {4,7},
                {5,6}, {5,8},
                {6,9},
                {7,8}, {8,9},
                {1,3}, {2,4}, {3,5}
        };
        int m1 = 3;  // Try with 3 colors

        int v2 = 6;
        int[][] edges2 = {
                {0,1},{0,2},{0,3},{0,4},{0,5},
                {1,2},{1,3},{1,4},{1,5},
                {2,3},{2,4},{2,5},
                {3,4},{3,5},
                {4,5}
        };
        int m2 = 5; // Should return false (needs 6 colors)

        int v3 = 12;
        int[][] edges3 = {
                // Component 1 (cycle)
                {0,1}, {1,2}, {2,3}, {3,0},

                // Component 2 (clique of 4)
                {4,5}, {4,6}, {4,7},
                {5,6}, {5,7},
                {6,7},

                // Component 3 (chain)
                {8,9}, {9,10}, {10,11},

                // cross tricky edges
                {2,5}, {3,6}
        };
        int m3 = 3;

        cf265 soln = new cf265();

        System.out.println( soln.graphColoring(v1, edges1, m1) );
        System.out.println( soln.graphColoring(v2, edges2, m2) );
        System.out.println( soln.graphColoring(v3, edges3, m3) );
    }
}
