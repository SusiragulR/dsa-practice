package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class h3_kLargestInArray {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int i: arr) {
            minHeap.add(i);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while( !minHeap.isEmpty() ){
            ans.add( minHeap.poll() );
        }

        Collections.reverse( ans );

        return ans;
    }
}
