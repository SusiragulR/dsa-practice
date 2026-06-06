public class TreeNode {
    int data;

    TreeNode left;
    TreeNode right;

    TreeNode(int d) {
        this.data = d;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "\n    { node: { data: " + data +
                ", left: " + (left == null ? "null" : left.data) +
                ", right: " + (right == null ? "null" : right.data) +
                " } }\n";
    }
}
