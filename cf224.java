import java.util.HashMap;

public class cf224 {
    private static TreeNode createTree(int[] parent) {
        int l = parent.length;
        HashMap<Integer, TreeNode> mp = new HashMap<>();
        TreeNode root = null;

        for (int i=l-1; i>=0; i--) {
            TreeNode t =  mp.containsKey(i) ? mp.get(i) : new TreeNode(i);

            int parentIndex = parent[i];

            if(parentIndex == -1) root = t;

            if( mp.containsKey(parentIndex) ){
                TreeNode parentNode = mp.get(parentIndex);
                parentNode.right = parentNode.left;
                parentNode.left = t;
            } else {
                TreeNode parentNode = new TreeNode(parentIndex);
                mp.put(parentIndex, parentNode);
                parentNode.left = t;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] par1 = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int[] par2 = new int[]{2, 0, -1};

        printAsciiTree.printPyramidTree(createTree(par1));
    }
}
