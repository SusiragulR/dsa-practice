public class cf190 {
    public boolean isIdentical(TreeNode r1, TreeNode r2) {
        if(r1==null && r2!=null) return false;
        if(r1!=null && r2==null) return false;
        if(r1==null && r2==null) return true;
        if(r1.data != r2.data) return false;

        return (r1.data==r2.data && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right));
    }
}
