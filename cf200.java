public class cf200 {
    private static int findMaxSum(TreeNode t) {
        int[] ms = new int[]{Integer.MIN_VALUE};

        findAndStoreMaxSum(t, ms);

        return ms[0];
    }

    private static int findAndStoreMaxSum(TreeNode t, int[] ms) {
        if(t==null) return 0;

        int ls = findAndStoreMaxSum(t.left, ms);
        int rs = findAndStoreMaxSum(t.right, ms);

        ls = ls<0 ? 0 : ls;
        rs = rs<0 ? 0 : rs;

        ms[0] = Math.max(ms[0], ls+rs+t.data);

        return Math.max(ls,rs) + t.data;
    }

    public static void main(String[] args) {
//                  10
//                /    \
//               2      10
//             /   \      \
//           20     1     -25
//                         / \
//                        3   4

        // root
        TreeNode root = new TreeNode(10);

        // left subtree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);

        // right subtree
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(findMaxSum(root));
    }
}
