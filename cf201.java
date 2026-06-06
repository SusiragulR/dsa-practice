import java.util.ArrayList;
import java.util.HashMap;

public class cf201 {
//    private static int countAllPaths(TreeNode root, int target) {
//        int[] kSumCount = new int[]{0};
//        ArrayList<Integer> path = new ArrayList<>();
//
//        countPathWithSum(root, path, kSumCount, target);
//
//        return kSumCount[0];
//    }
//
//    private static void countPathWithSum (TreeNode t, ArrayList<Integer> path, int[] kSumCount, int target) {
//        if(t==null) return;
//
//        System.out.println("node:("+t.data+")");
//        path.add(t.data);
//        System.out.println("node:("+t.data+") -> added ele: "+path);
//
//        countPathWithSum(t.left, path, kSumCount, target);
//        countPathWithSum(t.right, path, kSumCount, target);
//
//        int pathLastIndex=path.size()-1, sum=0;
//        for(int i=pathLastIndex; i>=0; i--){
//            sum += path.get(i);
//            if(sum == target) kSumCount[0]++;
//        }
//        System.out.println("node:("+t.data+") -> ksumCount: "+kSumCount[0]);
//
//        path.removeLast();
//        System.out.println("node:("+t.data+") -> removed ele: "+path);
//    }


    // Optimal solution
    private static int countAllPaths(TreeNode root, int target) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        return countPathWithSum(root, 0, target, prefixMap);
    }

    private static int countPathWithSum (TreeNode t, int currSum, int target, HashMap<Integer, Integer> prefixMap) {
        if (t == null) return 0;

        currSum += t.data;

        int count = prefixMap.getOrDefault(currSum - target, 0);

        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

        count += countPathWithSum(t.left, currSum, target, prefixMap);
        count += countPathWithSum(t.right, currSum, target, prefixMap);

        prefixMap.put(currSum, prefixMap.get(currSum) - 1);
        if (prefixMap.get(currSum) == 0)
            prefixMap.remove(currSum);

        return count;
    }

    public static void main(String[] args) {
/*
                        8
                   ┌────┴────┐
                   4         5
               ┌───┴───┐     └───┐
               3       2         2
           ┌───┴───┐   └───┐
           3      -2       1

 */

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.left = null;
        root.left.right.right = new TreeNode(1);

        System.out.println(countAllPaths(root, 7));
    }
}
