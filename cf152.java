import java.util.PriorityQueue;

public class cf152 {
    public static int minCost(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i: arr) q.offer((long) i);

        long minPossibleCost = 0;

        while(q.size() > 1) {
            long smallest1 = q.poll();
            long smallest2 = q.poll();

            long combined = smallest1 + smallest2;

            minPossibleCost += combined;

            q.offer(combined);
        }

        return (int)minPossibleCost;
    }
}
