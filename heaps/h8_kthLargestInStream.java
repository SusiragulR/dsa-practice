package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class h8_kthLargestInStream {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        int l = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<l; i++) {
            minHeap.add( arr[i] );

            if(minHeap.size() > k) minHeap.poll();

            if(minHeap.size() < k) {
                ans.add(-1);
            } else {
                ans.add(minHeap.peek());
            }
        }

        return ans;
    }
}
