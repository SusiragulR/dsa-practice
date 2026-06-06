import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cf221 {
    private static TreeNode buildTree(int inorder[], int preorder[]) {
        TreeNode root = new TreeNode(-1);

        List<Integer> preOrderList = new ArrayList<>();
        for (int x : preorder) preOrderList.add(x);

        List<Integer> inOrderList = new ArrayList<>();
        for (int x : inorder) inOrderList.add(x);

        buildTreeUsingTraversalLists(inOrderList, preOrderList, root);

        return root;
    }

    private static void buildTreeUsingTraversalLists(List<Integer> inOrder, List<Integer> preOrder, TreeNode t){
        if(inOrder.isEmpty() || preOrder.isEmpty()) return;

        int currRoot = preOrder.get(0);
        t.data = currRoot;

        int indexOfRootInInorder = inOrder.indexOf(currRoot);
        preOrder.removeFirst();

        if(!inOrder.subList(0, indexOfRootInInorder).isEmpty()) {
            TreeNode left = new TreeNode(-1);
            t.left = left;
            buildTreeUsingTraversalLists(inOrder.subList(0, indexOfRootInInorder), preOrder, left);
        }
        if(!inOrder.subList(indexOfRootInInorder+1, inOrder.size()).isEmpty()) {
            TreeNode right = new TreeNode(-1);
            t.right = right;
            buildTreeUsingTraversalLists(inOrder.subList(indexOfRootInInorder + 1, inOrder.size()), preOrder, right);
        }
    }

    public static void main(String[] args) {
        int[] io1 = new int[]{4, 2, 8, 5, 10, 9, 1, 3, 6, 7};
        int[] preO1 = new int[]{1, 2, 4, 5, 8, 9, 10, 3, 6, 7};

        int[] io2 = new int[]{4, 2, 1};
        int[] preO2 = new int[]{1, 2, 4};

        int[] io3 = new int[]{1, 2, 3};
        int[] preO3 = new int[]{1, 2, 3};

//        TreeNode ans1 = buildTree(io1, preO1);
//        TreeNode ans2 = buildTree(io2, preO2);
        TreeNode ans3 = buildTree(io3, preO3);

//        printAsciiTree.printPyramidTree(ans1);
//        printAsciiTree.printPyramidTree(ans2);
        printAsciiTree.printPyramidTree(ans3);
    }
}
