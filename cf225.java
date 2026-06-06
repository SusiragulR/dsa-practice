import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cf225 {

    public static ArrayList<Integer> serialize(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                ans.add(-1);
                continue;
            }

            ans.add(curr.data);
            q.add(curr.left);
            q.add(curr.right);
        }

        // optional cleanup: remove trailing -1s
        int i = ans.size() - 1;
        while (i >= 0 && ans.get(i) == -1) {
            ans.remove(i--);
        }

        return ans;
    }

    public static TreeNode deSerialize(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0 || arr.get(0) == -1) return null;

        TreeNode root = new TreeNode(arr.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int idx = 1;

        while (!q.isEmpty() && idx<arr.size()) {
            TreeNode curr = q.poll();

            // left child
            if (idx<arr.size() && arr.get(idx) != -1) {
                curr.left = new TreeNode(arr.get(idx));
                q.add(curr.left);
            }
            idx++;

            // right child
            if (idx<arr.size() && arr.get(idx) != -1) {
                curr.right = new TreeNode(arr.get(idx));
                q.add(curr.right);
            }
            idx++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = sampleTreeBuilder.buildNaturalNumberTree();

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(4);
        t2.left.left = new TreeNode(3);
        t2.left.left.left = new TreeNode(2);
        t2.left.left.left.left = new TreeNode(1);
        t2.left.left.left.left.left = new TreeNode(0);
        t2.right = new TreeNode(6);
        t2.right.right = new TreeNode(7);
        t2.right.right.right = new TreeNode(8);
        t2.right.right.right.right = new TreeNode(9);

//        printAsciiTree.printPyramidTree(t1);
        System.out.println(serialize(t2));
        printAsciiTree.printPyramidTree( deSerialize(serialize(t2)) );
    }
}
