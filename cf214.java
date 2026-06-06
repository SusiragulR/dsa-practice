public class cf214 {

    static class sizeAndCheckPair {
        int s;
        boolean isBST;

        sizeAndCheckPair(int size, boolean isValidBST){
            this.s = size;
            this.isBST = isValidBST;
        }
    }
    private static int largestBst(TreeNode root) {
        int[] maxSizeBT = new int[]{1};

        isBSTChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE, maxSizeBT);

        return maxSizeBT[0];
    }

    static sizeAndCheckPair isBSTChecker(TreeNode t, int min, int max, int[] maxSizeBT) {
        if(t==null) return new sizeAndCheckPair(0, true);

        sizeAndCheckPair left = isBSTChecker(t.left, min, t.data, maxSizeBT);
        sizeAndCheckPair right = isBSTChecker(t.right, t.data, max, maxSizeBT);

        boolean isSubTreeBST = left.isBST && right.isBST && (t.data<=min || t.data>=max);

        maxSizeBT[0] = isSubTreeBST ? Math.max(left.s+right.s+1, maxSizeBT[0]) : maxSizeBT[0];

        return new sizeAndCheckPair(left.s+right.s+1, isSubTreeBST);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(20);
        // left subtree
        t1.left = new TreeNode(15);
        t1.left.left = new TreeNode(14);
        t1.left.right = new TreeNode(18);
        t1.left.left.right = new TreeNode(17);
        t1.left.right.left = new TreeNode(16);
        t1.left.right.right = new TreeNode(19);
        // right subtree
        t1.right = new TreeNode(40);
        t1.right.left = new TreeNode(30);
        t1.right.right = new TreeNode(60);
        t1.right.right.left = new TreeNode(50);

/*
                                20
                ┌────────────────┴────────────────┐
               15                                 40
        ┌────────┴────────┐               ┌────────┴────────┐
       14                 18             30                 60
         └──────┐      ┌───┴───┐                        ┌───┘
                17     16      19                       50
*/

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(4);
        t2.left.left = new TreeNode(5);
        t2.left.left.left = new TreeNode(6);
        t2.left.left.left.left = new TreeNode(7);

//                            1
//                           /
//                          4
//                         /
//                        5
//                       /
//                      6
//                     /
//                    7

        TreeNode t4 = new TreeNode(6);
        t4.left = new TreeNode(6);
        t4.right = new TreeNode(2);
        t4.left.left = null;
        t4.left.right = new TreeNode(2);
        t4.right.left = new TreeNode(1);
        t4.right.right = new TreeNode(3);

/*
                 6
        ┌────────┴────────┐
        6                 2
        └──────┐      ┌───┴───┐
               2      1       3
*/


        System.out.println(largestBst(t1));
        System.out.println(largestBst(t2));
        System.out.println(largestBst(t4));
    }
}
