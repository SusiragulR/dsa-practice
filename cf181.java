import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class cf181 {

    /* =========================================================
       ❌ DOES NOT SATISFY LEVEL ORDER CONDITION
       ---------------------------------------------------------
       Reason:
       - This uses DFS (recursion)
       - Nodes in the same vertical line may be visited
         before upper-level nodes
       - Violates: "print as they appear in level order"
       ========================================================= */
//    private static ArrayList<ArrayList<Integer>> verticalOrderDFS(TreeNode root) {
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        dfs(root, 0, map);
//
//        int minLine = Integer.MAX_VALUE;
//        int maxLine = Integer.MIN_VALUE;
//
//        for (int line : map.keySet()) {
//            minLine = Math.min(minLine, line);
//            maxLine = Math.max(maxLine, line);
//        }
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        for (int i = minLine; i <= maxLine; i++) {
//            ans.add(map.get(i));
//        }
//
//        return ans;
//    }
//
//    private static void dfs(TreeNode node, int line,
//                            HashMap<Integer, ArrayList<Integer>> map) {
//        if (node == null) return;
//
//        map.computeIfAbsent(line, k -> new ArrayList<>())
//                .add(node.data);
//
//        dfs(node.left, line - 1, map);
//        dfs(node.right, line + 1, map);
//    }

    /* =========================================================
       ✅ CORRECT SOLUTION (SATISFIES LEVEL ORDER)
       ---------------------------------------------------------
       Uses BFS (Queue) to preserve level-order traversal
       ========================================================= */
    private static ArrayList<ArrayList<Integer>> verticalOrderBFS(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        class Pair {
            TreeNode node;
            int line;

            Pair(TreeNode n, int l) {
                node = n;
                line = l;
            }
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int minLine = 0, maxLine = 0;

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode curr = p.node;
            int line = p.line;

            map.computeIfAbsent(line, k -> new ArrayList<>())
                    .add(curr.data);

            minLine = Math.min(minLine, line);
            maxLine = Math.max(maxLine, line);

            if (curr.left != null)
                q.add(new Pair(curr.left, line - 1));

            if (curr.right != null)
                q.add(new Pair(curr.right, line + 1));
        }

        for (int i = minLine; i <= maxLine; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    public static void main(String[] args) {

        // Your sample tree
        TreeNode t1 = sampleTreeBuilder.buildNaturalNumberTree();

        // Tree constructed from level order with N as null
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(3);

        t3.left.left = new TreeNode(4);
        t3.left.right = new TreeNode(5);

        t3.right.right = new TreeNode(6);
        t3.right.right.left = new TreeNode(7);
        t3.right.right.right = new TreeNode(8);

        t3.right.right.right.left = new TreeNode(9);
        t3.right.right.right.right = new TreeNode(10);

        t3.right.right.right.right.left = new TreeNode(11);
        t3.right.right.right.right.right = new TreeNode(12);

        t3.right.right.right.right.right.left = new TreeNode(13);

        // ✅ Correct vertical traversal (level order preserved)
        ArrayList<ArrayList<Integer>> ans = verticalOrderBFS(t3);
        System.out.println(ans);
    }
}
