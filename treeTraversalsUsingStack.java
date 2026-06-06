import java.util.Stack;

class PairOfTreeNodeAndNumber {
    TreeNode t;
    int num;

    PairOfTreeNodeAndNumber(TreeNode givenTreeNode, int givenNum) {
        this.t = givenTreeNode;
        this.num = givenNum;
    }
}

public class treeTraversalsUsingStack {
    static void preOrderUsingStack (TreeNode r) {
        if(r == null) return;

        Stack<TreeNode> stk = new Stack<>();
        stk.push(r);

        while (!stk.empty()) {
            TreeNode n = stk.pop();
            System.out.print(n.data + " ");
            if(n.right != null) stk.push(n.right);
            if(n.left != null) stk.push(n.left);
        }
    }

    static void inOrderUsingStack (TreeNode r) {
        if(r == null) return;

        Stack< PairOfTreeNodeAndNumber > stk = new Stack<>();
        stk.push(new PairOfTreeNodeAndNumber(r, 0));

        while (!stk.empty()) {
            PairOfTreeNodeAndNumber poppedPair = stk.pop();

            if(poppedPair.num == 1) {
                System.out.print(poppedPair.t.data + " ");
                continue;
            }

            if(poppedPair.t.right != null) stk.push(new PairOfTreeNodeAndNumber(poppedPair.t.right, 0));
            stk.push(new PairOfTreeNodeAndNumber(poppedPair.t, 1));
            if(poppedPair.t.left != null) stk.push(new PairOfTreeNodeAndNumber(poppedPair.t.left, 0));
        }
    }

    static void inOrderUsingStackInAProperWay (TreeNode r) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cn = r;
        stk.push(cn);

        while (!stk.empty()) {
            if(cn == null) {
                TreeNode popped = stk.pop();
                System.out.print(popped.data + " ");
                cn = popped.right;
                if(cn != null) stk.push(cn);
            }
            else {
                cn = stk.peek().left;
                if(cn != null) stk.push(cn);
            }
        }
    }

    static void postOrderUsingStack (TreeNode r) {
        if(r == null) return;

        Stack< PairOfTreeNodeAndNumber > stk = new Stack<>();
        stk.push(new PairOfTreeNodeAndNumber(r, 0));

        while (!stk.empty()) {
            PairOfTreeNodeAndNumber poppedPair = stk.pop();

            if(poppedPair.num == 1) {
                System.out.print(poppedPair.t.data + " ");
                continue;
            }

            stk.push(new PairOfTreeNodeAndNumber(poppedPair.t, 1));
            if(poppedPair.t.right != null) stk.push(new PairOfTreeNodeAndNumber(poppedPair.t.right, 0));
            if(poppedPair.t.left != null) stk.push(new PairOfTreeNodeAndNumber(poppedPair.t.left, 0));
        }
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

        TreeNode t2 = new TreeNode(1);

        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        t2.left.left = new TreeNode(4);
        t2.left.right = new TreeNode(5);

        t2.left.right.left = new TreeNode(6);
        t2.left.right.right = new TreeNode(7);
/*
               1
             /   \
            2     3
          /   \
         4     5
              / \
             6   7
*/

        System.out.println();
        
        System.out.println("Pre-Order using stack : ");
        preOrderUsingStack(t1);
        System.out.println();

        System.out.println("*".repeat(25));

        System.out.println("In-Order using stack : ");
        inOrderUsingStack(t2);
        System.out.println();
        inOrderUsingStackInAProperWay(t2);
        System.out.println();

        System.out.println("*".repeat(25));

        System.out.println("Post-Order using stack : ");
        postOrderUsingStack(t1);
        System.out.println();
    }
}
