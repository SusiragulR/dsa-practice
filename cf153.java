import java.util.PriorityQueue;

public class cf153 {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // push first k+1 elements into pq
        for(int i=0; i<=k; i++) q.offer(arr[i]);

        
    }
}
