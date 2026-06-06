public class cf205 {
    int maxDiff(TreeNode root) {
        int[] maxDiffSoFar = new int[]{Integer.MIN_VALUE};

        getMaxDiff(root, maxDiffSoFar);

        return maxDiffSoFar[0];
    }

    static int getMaxDiff(TreeNode t, int[] maxDiffSoFar){
        //base cases:
        // 1) leaf nodes should return their data
        // 2) null noded should return Int Max

        if(t==null) return Integer.MAX_VALUE;
        if(t.left==null && t.right==null) return t.data;

        //recursively look for min from it's subtree
        int minSoFar = Math.min(
                getMaxDiff(t.left, maxDiffSoFar),
                getMaxDiff(t.right, maxDiffSoFar)
        );

        //update ans
        maxDiffSoFar[0] = Math.max(
                maxDiffSoFar[0],
                t.data - minSoFar
        );

        //return minSoFar
        return Math.min(
                t.data,
                minSoFar
        );
    }
}
