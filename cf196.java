public class cf196 {
    static void mirrorTree(TreeNode t) {
        if(t==null) return;

        mirrorTree(t.left);
        mirrorTree(t.right);

//        if(t.left == null) {
//            t.left = t.right;
//            t.right = null;
//        } else if(t.right == null) {
//            t.right = t.left;
//            t.left = null;
//        }
        TreeNode temp = t.left;
        t.left = t.right;
        t.right = temp;
    }

    public static void main(String[] args) {
/*
            1
          /   \
         2     3
              / \
             4   5
*/
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(5);

/*
            1
          /   \
         2     3
        /
       4
        \
         5
*/
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(5);

/*
                          19
                ┌─────────┴─────────┐
                6                   23
          ┌─────┴─────┐        ┌────┘
          3           9        21
       ┌──┴──┐     ┌──┴──┐
       2     5     8    11
        \         /
         4       7
*/
        TreeNode t3 = new TreeNode(19);
        t3.left = new TreeNode(6);
        t3.right = new TreeNode(23);
        t3.left.left = new TreeNode(3);
        t3.left.right = new TreeNode(9);
        t3.right.left = new TreeNode(21);
        t3.left.left.left = new TreeNode(2);
        t3.left.left.right = new TreeNode(5);
        t3.left.right.left = new TreeNode(8);
        t3.left.right.right = new TreeNode(11);
        t3.left.left.left.right = new TreeNode(4);
        t3.left.right.left.left = new TreeNode(7);

        System.out.println("+".repeat(30));
        System.out.println("Level order (t1): ");
        treeTraversals.traverseUsingBFSLevelOrder(t1);
        mirrorTree(t1);
        System.out.println("Mirror (t1): ");
        treeTraversals.traverseUsingBFSLevelOrder(t1);

        System.out.println("+".repeat(30));
        System.out.println("Level order (t2): ");
        treeTraversals.traverseUsingBFSLevelOrder(t2);
        mirrorTree(t2);
        System.out.println("Mirror (t2): ");
        treeTraversals.traverseUsingBFSLevelOrder(t2);

        System.out.println("+".repeat(30));
        System.out.println("Level order (t3): ");
        treeTraversals.traverseUsingBFSLevelOrder(t3);
        mirrorTree(t3);
        System.out.println("Mirror (t3): ");
        treeTraversals.traverseUsingBFSLevelOrder(t3);

        System.out.println("+".repeat(30));
    }
}
