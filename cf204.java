import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class cf204 {
    private static int findMinDist(TreeNode root, int a, int b) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode targetNode = null;
        TreeNode nodeToBeFound = null;

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode popped = q.poll();
            if(popped.data == a) targetNode = popped;
            if(popped.data == b) nodeToBeFound = popped;

            if(popped.left != null) {
                parents.put(popped.left, popped);
                q.add(popped.left);
            }
            if(popped.right != null) {
                parents.put(popped.right, popped);
                q.add(popped.right);
            }
        }

        if(targetNode==null || nodeToBeFound==null) return 0;

//        System.out.println("targetNode: "+targetNode.data);
//        System.out.println("nodeToBeFound: "+nodeToBeFound.data);
//        System.out.print("[ ");
//        for (TreeNode i : parents.keySet()){
//            System.out.print("{"+i.data+","+parents.get(i).data+"}, ");
//        }
//        System.out.print(" ]");
//        System.out.println();

        HashMap<TreeNode, Boolean> hasVisited = new HashMap<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        int stepCount = 0;
        q2.add(targetNode);

        boolean hasReachedBreakCase = false;

        while( !q2.isEmpty() ) {
//            System.out.println("stepCount : "+stepCount);
//            System.out.print("queue : ");
//            for (TreeNode i : q2) {
//                System.out.print(i.data+" ");
//            }
//            System.out.println();
//            System.out.println("_________");

            int currentQsize = q2.size();

            for(int i=0; i<currentQsize; i++) {
                TreeNode popped = q2.poll();

                if(popped.data == b) {
                    hasReachedBreakCase = true;
                    break;
                }

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

            if(hasReachedBreakCase) break;
            stepCount++;
        }

        return stepCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);

        root.left = new TreeNode(6);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(14);
        root.right.right = null;

        root.left.left.left = null;
        root.left.left.right = null;

        root.left.right.left = new TreeNode(7);
        root.left.right.right = null;

        root.left.right.left.left = new TreeNode(13);
        root.left.right.left.right = null;

/*
                           11
            ┌───────────────┴───────────────┐
            6                               15
    ┌───────┴───────┐               ┌───────┴───────┐
    4               8               14              N
            ┌───────┴───────┐
            7               N
    ┌───────┴───────┐
    13              N
*/

        System.out.println(findMinDist(root, 4, 11));
        System.out.println(findMinDist(root, 4, 15));
        System.out.println(findMinDist(root, 4, 7));
        System.out.println(findMinDist(root, 4, 8));
        System.out.println(findMinDist(root, 14, 7));
        System.out.println(findMinDist(root, 13, 7));
    }
}
