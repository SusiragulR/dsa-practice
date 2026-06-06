import java.util.*;

public class cf183 {
    static class Pair {
        TreeNode node;
        int vl;

        Pair(TreeNode h, int vline){
            this.node = h;
            this.vl = vline;
        }
    }

//    private static ArrayList<Integer> bottomView(TreeNode root) {
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        HashMap<Integer, Pair> chk = new HashMap<>();
//
//        levelTraversalWithChkUpdate(root, 0, 0, chk);
//
//        int minLine = Integer.MAX_VALUE;
//        int maxLine = Integer.MIN_VALUE;
//
//        for(int i: chk.keySet()){
//            minLine = Math.min(i, minLine);
//            maxLine = Math.max(i, maxLine);
//        }
//
//        for(int i=minLine; i<=maxLine; i++){
//            ans.add(chk.get(i).data);
//        }
//
//        return ans;
//    }
//
//    private static void levelTraversalWithChkUpdate (TreeNode t, int vertLine, int hL, HashMap<Integer, Pair> chk) {
//        if(t == null) return;
//
//        levelTraversalWithChkUpdate(t.right, vertLine+1, hL+1, chk);
//        levelTraversalWithChkUpdate(t.left, vertLine-1, hL+1, chk);
//
//        if( chk.isEmpty() || !chk.containsKey(vertLine) ) {
//            chk.put(vertLine, new Pair(hL, t.data));
//        } else {
//            if( chk.get(vertLine).horzLine < hL ) chk.put(vertLine, new Pair(hL, t.data));
//        }
//
//    }
//
//    ^
//    |
// NOT AN ACTUAL LEVEL-ORDER TRAVERSAL
// HORIZONTAL LINE IS NOT NEEDED IF A PROPER LEVEL ORDER TRAVERSAL IS DONE

    private static ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        HashMap<Integer, Integer> chk = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair popped = q.remove();
            chk.put(popped.vl, popped.node.data);
            if(popped.node.left != null) q.add(new Pair(popped.node.left, popped.vl-1));
            if(popped.node.right != null) q.add(new Pair(popped.node.right, popped.vl+1));
        }

        int minLine = Integer.MAX_VALUE;
        int maxLine = Integer.MIN_VALUE;

        for(int i: chk.keySet()){
            minLine = Math.min(i, minLine);
            maxLine = Math.max(i, maxLine);
        }

        for(int i=minLine; i<=maxLine; i++){
            ans.add(chk.get(i));
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

        System.out.println(bottomView(t1));
    }
}
