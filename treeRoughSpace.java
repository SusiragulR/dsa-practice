import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class treeRoughSpace {

    static ArrayList<Integer> ansOfPreOrderRecursive = new ArrayList<>();
    static ArrayList<Integer> ansOfPostOrderRecursive = new ArrayList<>();
    static ArrayList<Integer> ansOfInOrderRecursive = new ArrayList<>();
    static void preOrderRecursiveTraversal(TreeNode t) {
        if(t == null) return;

        ansOfPreOrderRecursive.add(t.data);
        preOrderRecursiveTraversal(t.left);
        preOrderRecursiveTraversal(t.right);
    }
    static void postOrderRecursiveTraversal(TreeNode t) {
        if(t == null) return;

        postOrderRecursiveTraversal(t.left);
        postOrderRecursiveTraversal(t.right);
        ansOfPostOrderRecursive.add(t.data);
    }
    static void inOrderRecursiveTraversal(TreeNode t) {
        if(t == null) return;

        inOrderRecursiveTraversal(t.left);
        ansOfInOrderRecursive.add(t.data);
        inOrderRecursiveTraversal(t.right);
    }

    static ArrayList<Integer> preOrderUsingStack(TreeNode t) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        stk.push(t);
        while (!stk.empty()) {
            TreeNode popped = stk.pop();
            ans.add(popped.data);
            if(popped.right != null) stk.push(popped.right);
            if(popped.left != null) stk.push(popped.left);
        }

        return ans;
    }



    public static void main(String[] args) {
        TreeNode t1 = sampleTreeBuilder.buildNaturalNumberTree();
/*
                                   1
                     ┌─────────────┴─────────────┐
                    2                             3
              ┌──────┴──────┐              ┌──────┴──────┐
             4               5             6               7
          ┌──┴──┐        ┌──┴──┐       ┌──┴──┐        ┌──┴──┐
         8     9        10     11     12     13       14     15
        ┌┴┐   ┌┴┐      ┌┴┐    ┌┴┐    ┌┴┐    ┌┴┐      ┌┴┐    ┌┴┐
       16 17 18 19    20 21  22 23  24 25  26 27    28 29  30 31

*/

        preOrderRecursiveTraversal(t1);
        postOrderRecursiveTraversal(t1);
        inOrderRecursiveTraversal(t1);
        System.out.println(ansOfPreOrderRecursive);
        System.out.println("Preorder Using Stk: ");
        System.out.println(preOrderUsingStack(t1));
        System.out.println("*".repeat(50));
        System.out.println(ansOfPostOrderRecursive);
        System.out.println("*".repeat(50));
        System.out.println(ansOfInOrderRecursive);
        System.out.println("*".repeat(50));
    }
}
