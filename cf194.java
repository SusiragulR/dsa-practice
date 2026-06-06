public class cf194 {
//    private static boolean isSumTree(TreeNode t) {
//        if(t==null) return true;
//        if(t.left==null && t.right==null) return true;
//
//        return isSumTree(t.left) && isSumTree(t.right) && (t.data == sumOfSubtree(t.left) + sumOfSubtree(t.right));
//    }
//
//    private static int sumOfSubtree(TreeNode t) {
//        if(t==null) return 0;
//
//        return t.data + sumOfSubtree(t.left) + sumOfSubtree(t.right);
//    }

    private static boolean isSumTree(TreeNode t) {
        return sumOfSubtree(t) != -1;
    }

    private static int sumOfSubtree(TreeNode t) { //should return sum if sumTree else -1
        if(t==null) return 0;
        if(t.left==null && t.right==null) return t.data;

        int leftSum = sumOfSubtree(t.left);
        int rightSum = sumOfSubtree(t.right);

        if(leftSum==-1 || rightSum==-1) return -1;
        if(t.data != leftSum + rightSum) return -1;

        return t.data + sumOfSubtree(t.left) + sumOfSubtree(t.right);
    }

    public static void main(String[] args) {
/*
            70
          /   \
         20    30
        / \
      10   10
*/
        TreeNode t1 = new TreeNode(70);
        t1.left = new TreeNode(20);
        t1.right = new TreeNode(30);
        t1.left.left = new TreeNode(10);
        t1.left.right = new TreeNode(10);

/*
            10
          /    \
         5      2
               / \
              1   1
             /
            1
*/
        TreeNode t2 = new TreeNode(10);
        t2.left = new TreeNode(5);
        t2.right = new TreeNode(2);
        t2.right.left = new TreeNode(1);
        t2.right.right = new TreeNode(1);
        t2.right.left.left = new TreeNode(1);

        System.out.println(isSumTree(t1));
        System.out.println(isSumTree(t2));
    }
}
