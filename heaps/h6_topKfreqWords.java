package heaps;

import java.util.*;

public class h6_topKfreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> stringFreq = new HashMap<>();

        for(String i: words) {
            if(stringFreq.containsKey(i)) {
                stringFreq.put( i, stringFreq.get(i)+1 );
            } else {
                stringFreq.put( i, 1 );
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqA = stringFreq.get(a);
            int freqB = stringFreq.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // Min-Heap behavior for frequencies
            }

            // If frequencies are equal, alphabetically LATER string goes to the root
            // so that it gets polled/evicted first when size > k
            return b.compareTo(a);
        });

        for(String i: stringFreq.keySet()) {
            minHeap.add(i);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=k-1; i>=0; i--) {
            ans.add( minHeap.poll() );
        }

        Collections.reverse( ans );

        return ans;
    }
}
