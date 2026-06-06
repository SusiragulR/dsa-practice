import java.util.Stack;

public class cf180 {
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

        System.out.println();
        System.out.println("Boundary Traversal t1: ");
        boundaryTraversal(t1);
        System.out.println();
        System.out.println("=".repeat(25));
        System.out.println("Boundary Traversal t2: ");
        boundaryTraversal(t2);
    }
}
