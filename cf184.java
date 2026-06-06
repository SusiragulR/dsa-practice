import java.util.ArrayList;
import java.util.Stack;

public class cf184 {
    public ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> stk = new Stack<>();

        levelTraversalWithStkUpdate(root, 0, ans, stk);

        return ans;
    }
    
    static void levelTraversalWithStkUpdate (TreeNode t, int line, ArrayList<Integer> ans, Stack<Integer> stk) {
        if(t == null) return;

        if(stk.empty() || stk.peek()<line) {
            stk.push(line);
            ans.add(t.data);
        }

        levelTraversalWithStkUpdate(t.left, line+1, ans, stk);
        levelTraversalWithStkUpdate(t.right, line+1, ans, stk);
    }
}
