public class cf187 {
    private static int height(TreeNode root) {
        return recursiveDepthTraversal(root, 0);
    }

    static int recursiveDepthTraversal (TreeNode t, int h) {
        if(t==null) return h-1;

        return Math.max(
                recursiveDepthTraversal (t.left, h+1),
                recursiveDepthTraversal (t.right, h+1)
        );
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(12);
        t1.left = new TreeNode(8);
        t1.right = new TreeNode(18);
        t1.left.left = new TreeNode(5);
        t1.left.right = new TreeNode(11);

        System.out.println(height(t1));
    }
}
