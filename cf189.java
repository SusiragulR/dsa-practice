public class cf189 {
    private static int diameter(TreeNode root) {
        int[] dm = new int[1];

        calculateDiameter(root, dm);

        return dm[0];
    }

    private static int calculateDiameter(TreeNode t, int[] dm) {
        //System.out.println("t:-> "+t.data+" dm: "+dm[0]);
        if(t.left==null && t.right==null) return 0;

        int lh = t.left!=null ? (1 + calculateDiameter(t.left, dm)) : 0;
        int rh = t.right!=null ? (1 + calculateDiameter(t.right, dm)) : 0;

        dm[0] = Math.max(dm[0], lh+rh);

        //System.out.println("dm: ("+t.data+")-> :" + dm[0]);
        //System.out.println("=+".repeat(30));
        return Math.max(lh, rh);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(8);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(7);
        t1.right = new TreeNode(6);
        t1.right.right = new TreeNode(9);

        System.out.println(diameter(t1));
    }
}
