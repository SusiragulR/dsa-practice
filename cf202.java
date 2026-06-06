import java.util.*;

public class cf202 {
    private static ArrayList<Integer> KDistanceNodes(TreeNode root, int target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode targetNode = null;

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode popped = q.poll();
            if(popped.data == target) targetNode = popped;

            if(popped.left != null) {
                parents.put(popped.left, popped);
                q.add(popped.left);
            }
            if(popped.right != null) {
                parents.put(popped.right, popped);
                q.add(popped.right);
            }
        }

        if(targetNode == null) return new ArrayList<>();

        HashMap<TreeNode, Boolean> hasVisited = new HashMap<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int stepCount = 0;
        q2.add(targetNode);

        while( !q2.isEmpty() ) {
            if(stepCount == k) break;

            int currentQsize = q2.size();

            for(int i=0; i<currentQsize; i++) {
                TreeNode popped = q2.poll();
                hasVisited.put(popped, true);
                TreeNode parentOfCurrentPopped = parents.getOrDefault(popped, null);

                // up-ward direction
                if(
                        parentOfCurrentPopped!=null
                        && !hasVisited.getOrDefault(parentOfCurrentPopped, false)
                ){
                    hasVisited.put(parentOfCurrentPopped, true);
                    q2.add(parentOfCurrentPopped);
                }

                //left-ward
                if (
                        popped.left != null
                        && !hasVisited.getOrDefault(popped.left, false)
                ) {
                    hasVisited.put(popped.left, true);
                    q2.add(popped.left);
                }

                //right-ward
                if (
                        popped.right != null
                        && !hasVisited.getOrDefault(popped.right, false)
                ) {
                    hasVisited.put(popped.right, true);
                    q2.add(popped.right);
                }
            }

            stepCount++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q2.isEmpty()) {
            ans.add(q2.poll().data);
        }

        Collections.sort(ans);
        return ans;
    }

//    //fn to go in 3 directions (up, left, right) step by step
//    static ArrayList<Integer> traverseIn3directions(
//            TreeNode targetNode,
//            HashMap<TreeNode,TreeNode> parents,
//            int step,
//            ArrayList<TreeNode> nodesInCurrentStep
//    ){
//
//    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);

        System.out.println(KDistanceNodes(t1, 2, 2));
        System.out.println(KDistanceNodes(t1, 3, 3));
    }
}
