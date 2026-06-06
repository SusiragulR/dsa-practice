import java.util.ArrayList;
import java.util.HashMap;

public class cf186 {
    private static ArrayList<Integer> diagonal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        if(root == null) return ans;

        addDiagonalLinesAndRespectiveElements(root, 0, hm);

        for(int i=0; hm.containsKey(i); i++) {
            ans.addAll(hm.get(i));
        }

        return ans;
    }

    private static void addDiagonalLinesAndRespectiveElements(TreeNode t, int diagonal, HashMap<Integer, ArrayList<Integer>> hm) {
        if(t == null) return;

        if(!hm.containsKey(diagonal)) hm.put(diagonal, new ArrayList<>());
        hm.get(diagonal).add(t.data);

        System.out.println("hm -> " + hm);

        addDiagonalLinesAndRespectiveElements(t.left,diagonal+1, hm);
        addDiagonalLinesAndRespectiveElements(t.right, diagonal, hm);
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

        System.out.println(diagonal(t1));
        System.out.println(diagonal(t2));
        System.out.println(diagonal(t3));
    }
}
