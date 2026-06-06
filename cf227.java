import java.util.HashMap;

public class cf227 {

//    UNOPTIMISED VERSION - (as recursive functions are called more than once for some nodes)
//    Optimised Solution : Store them in a map (DP)

//    public int getMaxSum(TreeNode t) {
//        if(t==null) return 0;
//
//        int leftChildMax = getMaxSum(t.left);
//        int rightChildMax = getMaxSum(t.right);
//
//        int childMaxSum = leftChildMax + rightChildMax;
//
//        int llgChildMax = (t.left==null) ? 0 : getMaxSum(t.left.left);
//        int lrgChildMax = (t.left==null) ? 0 : getMaxSum(t.left.right);
//        int rlgChildMax = (t.right==null) ? 0 : getMaxSum(t.right.left);
//        int rrgChildMax = (t.right==null) ? 0 : getMaxSum(t.right.right);
//
//        int gChildWithCurrentMaxSum = llgChildMax +
//                lrgChildMax +
//                rlgChildMax +
//                rrgChildMax +
//                t.data;
//
//        mp.put(t, Math.max(childMaxSum, gChildWithCurrentMaxSum));
//        return Math.max(childMaxSum, gChildWithCurrentMaxSum);
//    }

    static HashMap<TreeNode, Integer> mp = new HashMap<>();

    public int getMaxSum(TreeNode t) {
        if(t==null) return 0;

        if(mp.containsKey(t)) return mp.get(t);

        int leftChildMax = getMaxSum(t.left);
        int rightChildMax = getMaxSum(t.right);

        int childMaxSum = leftChildMax + rightChildMax;

        int llgChildMax = (t.left==null) ? 0 : getMaxSum(t.left.left);
        int lrgChildMax = (t.left==null) ? 0 : getMaxSum(t.left.right);
        int rlgChildMax = (t.right==null) ? 0 : getMaxSum(t.right.left);
        int rrgChildMax = (t.right==null) ? 0 : getMaxSum(t.right.right);

        int gChildWithCurrentMaxSum = llgChildMax +
                lrgChildMax +
                rlgChildMax +
                rrgChildMax +
                t.data;

        mp.put(t, Math.max(childMaxSum, gChildWithCurrentMaxSum));
        return Math.max(childMaxSum, gChildWithCurrentMaxSum);
    }
}
