import java.util.LinkedList;
import java.util.Queue;

public class cf148 {

// HAS ISSUES - EXPLAINED BELOW
//    public static int startStation(int[] gas, int[] cost) {
//        int currentSum = 0, n=gas.length;
//        Queue<Integer> q = new LinkedList<>();
//
//        for(int i=0; i<(2*n); i++){
//            int index = i%n;
//            q.add(index);
//            currentSum += (gas[index] - cost[index]);
//            if (currentSum < 0) {
//                while(!q.isEmpty() && currentSum<0) {
//                    int popped = q.remove();
//                    currentSum -= (gas[popped] - cost[popped]);
//                }
//            } else {
//                if(q.size() == n) return q.peek();
//            }
//        }
//
//        return -1;
//    }

    public static int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int currentSum = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;

            // ➕ Add current station to the queue window
            q.add(idx);
            currentSum += (gas[idx] - cost[idx]);

            /*
             * 🛑 ISSUE 3 EXPLANATION:
             * -----------------------
             * In your original code, you checked for q.size() == n only inside:
             *
             *      if (currentSum >= 0) { ... }
             *
             * 😕 Problem:
             * After adding an element, currentSum might be < 0 temporarily.
             * But after removing invalid stations (cleanup), currentSum may
             * become >= 0 again AND the queue may reach full size n.
             *
             * ❗ But your check never ran after cleanup, so you might MISS the solution.
             *
             * ✔ FIX: We run cleanup first, then check size.
             */

            // 🧹 Clean up invalid starting stations while currentSum is negative
            while (!q.isEmpty() && currentSum < 0) {
                int popped = q.remove();
                currentSum -= (gas[popped] - cost[popped]);
            }

            /*
             * ⭐ ISSUE 1 EXPLANATION:
             * -----------------------
             * Your original code checked:
             *
             *      if (currentSum >= 0) {
             *          if (q.size() == n) return q.peek();
             *      }
             *
             * ❌ Problem:
             * You were ONLY checking q.size() == n when currentSum >= 0
             * BEFORE cleanup.
             *
             * ❗ But the queue might reach size n AFTER cleanup!
             *
             * For example:
             *  - You add some stations → queue grows
             *  - currentSum < 0 → cleanup removes a few
             *  - currentSum becomes >= 0 again
             *  - queue is EXACTLY size n now (valid full window)
             *
             * Your original placement of the check missed this exact moment.
             *
             * ✔ FIX:
             * The check must be placed AFTER cleanup so we always
             * catch the moment when queue reaches size = n.
             */

            // ✔ Check if the queue holds a full circular window of size n
            if (q.size() == n) {
                return q.peek();  // 🎉 Found valid start
            }
        }

        return -1;  // ❌ No valid station
    }

    public static void main(String[] args) {
        int[] gas1 = new int[]{4, 5, 7, 4};
        int[] cost1 = new int[]{6, 6, 3, 5};
        int[] gas2 = new int[]{3, 9};
        int[] cost2 = new int[]{7, 6};
        int[] gas3 = new int[]{};
        int[] cost3 = new int[]{};

        System.out.println(startStation(gas1, cost1));
        System.out.println(startStation(gas2, cost2));
        System.out.println(startStation(gas3, cost3));
    }
}
