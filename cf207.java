public class cf207 {
    private static TreeNode insertIntoBST(TreeNode root, int val) {
        checkAndInsertUtil(root, val);

        return root;
    }

//    private static void traverseAndInsertInBST(TreeNode curr, TreeNode parent, TreeNode ans, int insertValue) {
//
//        if(curr.data < insertValue) { // can be inserted on right or can be a parent
//            if(curr.right!= null && curr.right.data<insertValue) { // should be a parent with curr as left
//                TreeNode temp = new TreeNode(insertValue);
//                temp.left = curr;
//                if(parent == null) {
//                    ans = temp;
//                    return;
//                }
//                else parent.left = temp;
//            }
//
//            if(curr.right!= null && curr.right.data>insertValue) { // should be inserted on right
//                TreeNode temp = new TreeNode(insertValue);
//                temp.left = curr;
//                if(parent == null) {
//                    ans = temp;
//                    return;
//                }
//                else parent.left = temp;
//            }
//        }
//    }

    static void checkAndInsertUtil(TreeNode curr, int insertValue) {
        if(insertValue<curr.data && curr.left==null) {
            TreeNode temp = new TreeNode(insertValue);
            curr.left = temp;
            return;
        }

        if(insertValue>curr.data && curr.right==null) {
            TreeNode temp = new TreeNode(insertValue);
            curr.right = temp;
            return;
        }

        if(curr.data < insertValue) checkAndInsertUtil(curr.right, insertValue);
        if(curr.data > insertValue) checkAndInsertUtil(curr.left, insertValue);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(-1);

//        printAsciiTree.printPyramidTree(insertIntoBST(t1, 5));
//        printAsciiTree.printPyramidTree(insertIntoBST(t1, -1));
//        printAsciiTree.printPyramidTree(insertIntoBST(t1, -2));
//        printAsciiTree.printPyramidTree(insertIntoBST(t1, 22));
        printAsciiTree.printPyramidTree(insertIntoBST(t2, -2));
        printAsciiTree.printPyramidTree(insertIntoBST(t2, -3));
        printAsciiTree.printPyramidTree(insertIntoBST(t2, 1));
    }
}
