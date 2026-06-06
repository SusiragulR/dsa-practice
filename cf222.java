import java.util.ArrayList;
import java.util.List;

public class cf222 {
    private static TreeNode buildTree(int inorder[], int postorder[]) {
        TreeNode root = new TreeNode(-1);

        List<Integer> postOrderList = new ArrayList<>();
        for (int x : postorder) postOrderList.add(x);

        List<Integer> inOrderList = new ArrayList<>();
        for (int x : inorder) inOrderList.add(x);

        buildTreeUsingTraversalLists(inOrderList, postOrderList, root);

        return root;
    }

    private static void buildTreeUsingTraversalLists(List<Integer> inOrder, List<Integer> postOrder, TreeNode t){
        if(inOrder.isEmpty() || postOrder.isEmpty()) return;

        int currRoot = postOrder.getLast();
        t.data = currRoot;

        int indexOfRootInInorder = inOrder.indexOf(currRoot);
        postOrder.removeLast();

        if(!inOrder.subList(indexOfRootInInorder+1, inOrder.size()).isEmpty()) {
            TreeNode right = new TreeNode(-1);
            t.right = right;
            buildTreeUsingTraversalLists(inOrder.subList(indexOfRootInInorder + 1, inOrder.size()), postOrder, right);
        }
        if(!inOrder.subList(0, indexOfRootInInorder).isEmpty()) {
            TreeNode left = new TreeNode(-1);
            t.left = left;
            buildTreeUsingTraversalLists(inOrder.subList(0, indexOfRootInInorder), postOrder, left);
        }
    }

    public static void main(String[] args) {
        int[] io1 = new int[]{4, 2, 8, 5, 10, 9, 1, 3, 6, 7};
        int[] postO1 = new int[]{4, 8, 10, 9, 5, 2, 7, 6, 3, 1};

        int[] io2 = new int[]{4, 2, 1}; //leftSkewTree
        int[] postO2 = new int[]{4, 2, 1};

        int[] io3 = new int[]{1, 2, 3}; //rightSkewTree
        int[] postO3 = new int[]{3, 2, 1};

        TreeNode ans1 = buildTree(io1, postO1);
        TreeNode ans2 = buildTree(io2, postO2);
        TreeNode ans3 = buildTree(io3, postO3);

        printAsciiTree.printPyramidTree(ans1);
//        printAsciiTree.printPyramidTree(ans2);
//        printAsciiTree.printPyramidTree(ans3);
    }
}
