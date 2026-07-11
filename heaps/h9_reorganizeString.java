package heaps;

import java.util.PriorityQueue;

public class h9_reorganizeString {
    class Solution {
        public String reorganizeString(String s) {
            // HashMap<Character, Integer> freq = new HashMap<>();

            int[] freq = new int[26];

            int l = s.length();

            for(int i=0; i<l; i++) {
                // freq.put( s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1 );
                freq[s.charAt(i)-'a']++;
            }

            // PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a,b) -> freq.get(b) - freq.get(a) );
            PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a, b) -> freq[b-'a'] - freq[a-'a'] );

            // for(char c: freq.keySet()) {
            //     maxHeap.add(c);
            // }

            for(char c='a'; c<='z'; c++) {
                if(freq[c-'a'] > 0) maxHeap.add(c);
            }

            StringBuilder sb = new StringBuilder();

            while(!maxHeap.isEmpty()) {
                char peak = maxHeap.poll();

                if(sb.isEmpty() || peak!=sb.charAt(sb.length()-1)) {
                    sb.append( peak );
                    // freq.put(peak, freq.get(peak)-1);
                    freq[peak-'a']--;
                    // if(freq.get(peak)>0) maxHeap.add(peak);
                    if(freq[peak-'a']>0) maxHeap.add(peak);
                }
                else if(peak==sb.charAt(sb.length()-1) && maxHeap.isEmpty()) return "";
                else {
                    char temp = maxHeap.poll();
                    sb.append(temp);
                    // freq.put(temp, freq.get(temp)-1);
                    freq[temp-'a']--;
                    // if(freq.get(temp)>0) maxHeap.add(temp);
                    if(freq[temp-'a']>0) maxHeap.add(temp);
                    maxHeap.add(peak);
                }
            }

            return sb.toString();
        }
    }
}
