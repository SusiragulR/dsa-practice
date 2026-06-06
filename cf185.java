import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class cf185 {
    private static class Pair {
        TreeNode node;
        int hl;

        Pair(TreeNode h, int hline){
            this.node = h;
            this.hl = hline;
        }
    }
    private static ArrayList<Integer> rightView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> chk = new HashMap<>();
        int maxLine = 0;

        if(root == null) return ans;

        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair popped = q.remove();
            chk.put(popped.hl, popped.node.data);
            maxLine = Math.max(popped.hl, maxLine);
            if(popped.node.left != null) q.add( new Pair(popped.node.left, popped.hl+1) );
            if(popped.node.right != null) q.add( new Pair(popped.node.right, popped.hl+1) );
        }

        for(int i=0; i<=maxLine; i++) {
            ans.add(chk.get(i));
        }

        return ans;
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

        System.out.println(rightView(t1));
        System.out.println(rightView(t2));
    }
}
