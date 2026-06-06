public class cf210 {
    private static int kthLargest(TreeNode root, int k) {
        int[] count = new int[]{0};

        TreeNode ans = getKthLargestUsingReverseInorderTraversal(root, k , count);

        return ans == null ? 0 : ans.data;
    }

    private static TreeNode getKthLargestUsingReverseInorderTraversal(TreeNode t, int k, int[] count) {
        if(t==null) return null;


        TreeNode right = getKthLargestUsingReverseInorderTraversal(t.right, k, count);
        count[0]++;

        System.out.println("Node: " + t.data + " -> " + count[0]);

        if(count[0] == k) return t;

        if(right!=null) return right;
        return getKthLargestUsingReverseInorderTraversal(t.left, k, count);
    }

//    static int getTheCountOfSmallerNodesUsingInorderTraversal(TreeNode t, int k, int nodeCount, int[] ans) {
//        if(t==null) return 0;
//
//        int leftCount = getTheCountOfSmallerNodesUsingInorderTraversal(t.left, k, nodeCount, ans);
//        int countOfNodesSoFar = 1 + leftCount + nodeCount;
//        System.out.println("Node: " + t.data + " -> " + countOfNodesSoFar);
//
//        if(countOfNodesSoFar==k) ans[0] = t.data;
//
//        int rightCount = getTheCountOfSmallerNodesUsingInorderTraversal(t.right, k, countOfNodesSoFar, ans);
//
//        return countOfNodesSoFar + rightCount;
//    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(9);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(9);
        t2.left.left = null;
        t2.left.right = null;
        t2.right.left = null;
        t2.right.right = new TreeNode(10);
        t2.right.right.left = null;
        t2.right.right.right = new TreeNode(11);
        t2.right.right.right.left = null;
        t2.right.right.right.right = new TreeNode(12);

/*
                 4
        ┌────────┴────────┐
        2                 9
                          └────────┐
                                   10
                                    └────────┐
                                             11
                                              └────────┐
                                                       12
*/

        TreeNode t3 = new TreeNode(46);
        t3.left = new TreeNode(44);
        t3.right = new TreeNode(77);
        t3.left.left = new TreeNode(25);
        t3.left.right = null;
        t3.right.left = new TreeNode(71);
        t3.right.right = new TreeNode(107);
        t3.left.left.left = new TreeNode(10);
        t3.left.left.right = null;
        t3.right.left.left = new TreeNode(54);
        t3.right.left.right = null;
        t3.right.right.left = new TreeNode(91);
        t3.right.right.right = null;
        t3.left.left.left.left = new TreeNode(5);
        t3.left.left.left.right = null;
        t3.right.left.left.left = null;
        t3.right.left.left.right = new TreeNode(61);
        t3.right.right.left.left = new TreeNode(92);
        t3.right.right.left.right = null;

/*      46 44 77 25 N 71 107 10 N 54 N 91 N 5 N N 61 N 92 N N N N N N

                                        46
                        ┌───────────────┴───────────────┐
                       44                               77
                ┌───────┴───────┐               ┌───────┴───────┐
               25               N              71               107
            ┌───┴───┐                       ┌───┴───┐       ┌───┴───┐
           10       N                      54       N      91       N
        ┌───┴───┐                       ┌───┴───┐       ┌───┴───┐
        5       N                       N       61      N       92

*/


//        System.out.println(kthLargest(t1, 3));
        System.out.println(kthLargest(t3, 6));
    }
}
