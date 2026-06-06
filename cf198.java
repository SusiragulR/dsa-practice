import java.util.ArrayList;

public class cf198 {
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        ArrayList<Integer> present = new ArrayList<>();

        addAllRootToLeafPaths(root, present, ans);

        return ans;
    }

    static void addAllRootToLeafPaths(TreeNode t, ArrayList<Integer> present, ArrayList<ArrayList<Integer>> ans){
        present.add(t.data);

        if(t.left==null && t.right==null) {
            ans.add(new ArrayList<>(present));
            present.removeLast();
            return;
        }

        if(t.left!=null) addAllRootToLeafPaths(t.left, present, ans);
        if(t.right!=null) addAllRootToLeafPaths(t.right, present, ans);

        present.removeLast();
    }

    static void addAllRootToLeafPathsCleanerWay(TreeNode t, ArrayList<Integer> present, ArrayList<ArrayList<Integer>> ans){
        if(t==null) return;

        present.add(t.data);

        if(t.left==null && t.right==null) {
            ans.add(new ArrayList<>(present));
        }

        if(t.left!=null) addAllRootToLeafPaths(t.left, present, ans);
        if(t.right!=null) addAllRootToLeafPaths(t.right, present, ans);

        present.removeLast();
    }

    public static void main(String[] args) {
/*
            70
          /   \
         40    30
        / \
      20   10
*/
        TreeNode t1 = new TreeNode(70);
        t1.left = new TreeNode(40);
        t1.right = new TreeNode(30);
        t1.left.left = new TreeNode(20);
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

        System.out.println(Paths(t1));
    }
}
