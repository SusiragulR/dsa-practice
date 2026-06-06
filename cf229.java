import java.util.Stack;

public class cf229 {
//    static Stack<TreeNode> stk = new Stack<>();
//
//    public static void flatten(TreeNode t) {
//        if(t==null) return;
//
//        TreeNode tl = t.left;
//        TreeNode tr= t.right;
//
//        if(tr!=null) stk.push(tr);
//
//        t.left = null;
//        t.right = (tl==null && !stk.isEmpty()) ? stk.pop() : tl;
//
//        flatten(t.right);
//    }

    public static void flatten(TreeNode t) {
        if(t==null) return;

        bTreeToLL(t);
    }

    public static TreeNode bTreeToLL(TreeNode t) {
        //base cases
        if(t==null) return null;

        // store current riggt
        TreeNode tr = t.right;

        //make the right as left
        if(t.left!=null) t.right = t.left;

        //get last preOrder node from left
        TreeNode lastPreOrderNodeFromLeft = bTreeToLL(t.left);
        if(lastPreOrderNodeFromLeft==null) lastPreOrderNodeFromLeft = t;
        //making left as null
        t.left = null;

        // stored right is null
        if(tr==null) return lastPreOrderNodeFromLeft;

        //else
        lastPreOrderNodeFromLeft.right = tr;
        TreeNode lastPreOrderNodeFromRight = bTreeToLL(tr);

        return (lastPreOrderNodeFromRight!=null) ? lastPreOrderNodeFromRight :
                (lastPreOrderNodeFromLeft!=null) ? lastPreOrderNodeFromLeft : t;
    }
}
