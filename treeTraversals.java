import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class treeTraversals {
    // DFS
    private static void traverseUsingDFSInOrder (TreeNode t) { // In-order
        if(t == null) return;

        traverseUsingDFSInOrder(t.left);
        System.out.print(t.data+ " ");
        traverseUsingDFSInOrder(t.right);
    }

    private static void traverseUsingDFSPreOrder (TreeNode t) { // In-order
        if(t == null) return;

        System.out.print(t.data+ " ");
        traverseUsingDFSPreOrder(t.left);
        traverseUsingDFSPreOrder(t.right);
    }

    private static void traverseUsingDFSPostOrder (TreeNode t) { // In-order
        if(t == null) return;

        traverseUsingDFSPostOrder(t.left);
        traverseUsingDFSPostOrder(t.right);
        System.out.print(t.data+ " ");
    }

//    private static void traverseUsingBFSLevelOrder (ArrayList<TreeNode> l) { // Level-order
//        if(l.isEmpty()) return;
//
//        ArrayList<TreeNode> nextL = new ArrayList<>();
//
//        for(TreeNode t: l){
//            if(t == null) continue;
//
//            System.out.print(t.data + " ");
//            nextL.add(t.left);
//            nextL.add(t.right);
//        }
//
//        traverseUsingBFSLevelOrder(nextL);
//    }

    public static void traverseUsingBFSLevelOrder (TreeNode t) { // Level-order
        if(t == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);

        while (!q.isEmpty()) {
            TreeNode polled = q.remove();
            System.out.print(polled.data + " ");
            if(polled.left != null) q.add(polled.left);
            if(polled.right != null) q.add(polled.right);
        }
        System.out.println();
    }

//    private static void boundaryTraversal (TreeNode t) {
//        if(t == null) return;
//
//        Stack<TreeNode> leftStack = new Stack<>();
//        Stack<TreeNode> subTreeStack = new Stack<>();
//        TreeNode node = t;
//
//        while (node != null){
//            System.out.print(node.data + " ");
//            leftStack.add(node);
//            node = node.left;
//        }
//
//        while ( !leftStack.empty() ) {
//            subTreeStack.clear();
//
//            TreeNode curr = leftStack.pop().right;
//            if(curr == null) continue;
//            subTreeStack.add(curr);
//
//            // Need to perform pre-order traversal and print leaf nodes alone
//            while ( !subTreeStack.empty() ){
//                TreeNode popped = subTreeStack.pop();
//                if(popped.left==null && popped.right==null) System.out.print(popped.data + " ");
//                if(popped.right!=null) subTreeStack.push(popped.right);
//                if(popped.left!=null) subTreeStack.push(popped.left);
//            }
//        }
//
//        TreeNode tr = t.right;
//        while (tr.right!=null){
//            leftStack.add(tr);
//            tr = tr.right;
//        }
//
//        while (!leftStack.empty()) System.out.print(leftStack.pop().data + " ");
//    }
//  THE ABOVE CODE HAS DEFECTS FOR I/P t2

//  THE APT SOLUTION REQUIRED:
//
//  1) Root (once)
//  2) Left boundary (excluding leaf nodes)
//  3) All leaf nodes (left → right)
//  4) Right boundary (excluding leaf nodes, printed bottom → top)

    private static void boundaryTraversal(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");

        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    /* Left boundary excluding leaves */
    private static void printLeftBoundary(TreeNode node) {
        while (node != null) {
            if (!(node.left == null && node.right == null)) {
                System.out.print(node.data + " ");
            }
            node = (node.left != null) ? node.left : node.right;
        }
    }

    /* Leaf nodes */
    private static void printLeaves(TreeNode node) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    /* Right boundary excluding leaves, printed bottom-up */
    private static void printRightBoundary(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        while (node != null) {
            if (!(node.left == null && node.right == null)) {
                stack.push(node);
            }
            node = (node.right != null) ? node.right : node.left;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    public static void main(String[] args) {
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
        TreeNode t1 = sampleTreeBuilder.buildNaturalNumberTree();

/*
            1
          /   \
         2     3
              /
             4
            /
           5
*/
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.right.left = new TreeNode(4);
        t2.right.left.left = new TreeNode(5);

//        System.out.println("In order");
//        traverseUsingDFSInOrder(t1);
//        System.out.println();
//        System.out.println("=".repeat(25));
//        System.out.println("Pre order");
//        traverseUsingDFSPreOrder(t1);
//        System.out.println();
//        System.out.println("=".repeat(25));
//        System.out.println("Post order");
//        traverseUsingDFSPostOrder(t1);
//        System.out.println();
//        System.out.println("=".repeat(25));
//        System.out.println("Level order");
//        traverseUsingBFSLevelOrder(t1);
        System.out.println();
        System.out.println("=".repeat(25));
        System.out.println("Boundary Traversal t1: ");
        boundaryTraversal(t1);
        System.out.println();
        System.out.println("=".repeat(25));
        System.out.println("Boundary Traversal t2: ");
        boundaryTraversal(t2);
    }
}
