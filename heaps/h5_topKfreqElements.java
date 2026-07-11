package heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class h5_topKfreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> numFreq = new HashMap<>();

        for(int i: nums) {
            if(numFreq.containsKey(i)) {
                numFreq.put( i, numFreq.get(i)+1 );
            } else {
                numFreq.put( i, 1 );
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> numFreq.get(a) - numFreq.get(b));

        for(int i: numFreq.keySet()) {
            minHeap.add(i);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
