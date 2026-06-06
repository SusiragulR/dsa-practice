import java.util.*;

public class printAsciiTree {
    public static void printPyramidTree(TreeNode root) {
        if (root == null) return;

        int height = getHeight(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (level < height) {
            int size = q.size();

            // leading spaces for centering
            int leadingSpaces = (int) Math.pow(2, height - level - 1) - 1;
            printSpaces(leadingSpaces * 2);

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    System.out.print(curr.data);
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    System.out.print("N ");
                    q.add(null);
                    q.add(null);
                }

                // space between nodes
                int betweenSpaces = (int) Math.pow(2, height - level) - 1;
                printSpaces(betweenSpaces * 2);
            }

            System.out.println();
            level++;
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

}
