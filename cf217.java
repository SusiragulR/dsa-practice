import java.util.ArrayList;

public class cf217 {
    private static ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode[] predSuc = new TreeNode[]{null, null};

        getPredSuc(root, key, predSuc);

        ans.add(predSuc[0]);
        ans.add(predSuc[1]);
        return ans;
    }

    private static void getPredSuc(TreeNode t, int k, TreeNode[] predSuc){
        if(t==null) return;

        if(t.data>=k){
            getPredSuc(t.left, k, predSuc);
            if(t.data!=k) predSuc[1] = (predSuc[1]==null) ? t :
                    (predSuc[1].data-k > t.data-k) ? t : predSuc[1];
        }

        if(t.data<=k){
            getPredSuc(t.right, k, predSuc);
            if(t.data!=k) predSuc[0] = (predSuc[0]==null) ? t :
                    (k-predSuc[0].data > k-t.data) ? t : predSuc[0];
        }
    }
 
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(9);
        t1.left.left = null;
        t1.left.right = new TreeNode(4);
        t1.right.left = null;
        t1.right.right = new TreeNode(10);
        t1.left.right.left = new TreeNode(3);
        t1.left.right.right = null;

/*
                 8
        ┌────────┴────────┐
        1                 9
        └──────┐          └──────┐
               4                 10
           ┌───┘
           3
*/

        System.out.println("pred: " + findPreSuc(t1, 8).get(0).data);
        System.out.println("succ: " + findPreSuc(t1, 8).get(1).data);
    }
}
