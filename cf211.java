public class cf211 {
    private static boolean isBST(TreeNode t) {
        return isBSTChecker(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTChecker(TreeNode t, int min, int max) {
        if(t==null) return true;

        if(t.data<=min || t.data>=max) return false;

        return isBSTChecker(t.left, min, t.data) &&
                isBSTChecker(t.right, t.data, max);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(20);
        t1.left.left = null;
        t1.left.right = null;
        t1.right.left = new TreeNode(9);
        t1.right.right = new TreeNode(25);

/*
                10
        ┌────────┴────────┐
        5                 20
                       ┌───┴───┐
                       9      25
*/

        System.out.println(isBST(t1));
    }
}
