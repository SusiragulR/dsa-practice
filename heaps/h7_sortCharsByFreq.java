package heaps;

import java.util.HashMap;
import java.util.PriorityQueue;

public class h7_sortCharsByFreq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        int l = s.length();

        for(int i=0; i<l; i++) {
            if(freqMap.containsKey(s.charAt(i))) {
                freqMap.put( s.charAt(i), freqMap.get(s.charAt(i))+1 );
            } else {
                freqMap.put( s.charAt(i), 1 );
            }
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a, b) -> freqMap.get(b) - freqMap.get(a) );

        for(char c: freqMap.keySet()){
            maxHeap.add( c );
        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int f = freqMap.get(c);
            for(int i=0; i<f; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
