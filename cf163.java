import java.util.HashMap;

public class cf163 {
    static int findSmallestSubStringWithDistCharsWithLogs(String s) {
        int len = s.length();
        int smallestWindowSize = len;
        HashMap<Character, Integer> chk = new HashMap<>();

        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(!chk.containsKey(c)) chk.put(c,1);
        }

        int numOfDistChars = chk.size();
        System.out.println("numOfDistChars -> " + numOfDistChars);
        chk.clear();

        int l=0;
        for(int r=0; r<len; r++){
            System.out.println("=".repeat(20));
            System.out.println("r ---> (" + r + ")");
            char c = s.charAt(r);
            if(!chk.containsKey(c)) chk.put(c,1);
            else chk.put(c, chk.get(c)+1);

            System.out.println("(r,l) -> "+r+","+l);
            System.out.println("After adding r char ("+c+") --> "+ chk);

            char cl = s.charAt(l);
            while(r>=l && chk.containsKey(cl) && chk.get(cl)>1){
                System.out.println("while l -> ("+l+")");
                chk.put(cl, chk.get(cl)-1);
                l++;
                cl = s.charAt(l);
                System.out.println("After op:");
                System.out.println("chk -> "+chk);
                System.out.println("l -> "+l);
                System.out.println("cl -> "+cl);
            }

            if(chk.size() == numOfDistChars){
                System.out.println("**** POSSIBLE CASE ****");
                System.out.println("comparing -> " + smallestWindowSize + " & " + (r-l+1));
                smallestWindowSize = Math.min(smallestWindowSize, r-l+1);
                System.out.println("smallestWindowSize -> " + smallestWindowSize);
            }
            System.out.println("=".repeat(20));
        }

        return smallestWindowSize;
    }

    static int findSmallestSubStringWithDistChars(String s) {
        int len = s.length();
        int smallestWindowSize = len;
        HashMap<Character, Integer> chk = new HashMap<>();

        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(!chk.containsKey(c)) chk.put(c,1);
        }

        int numOfDistChars = chk.size();
        chk.clear();

        int l=0;
        for(int r=0; r<len; r++){
            char c = s.charAt(r);
            if(!chk.containsKey(c)) chk.put(c,1);
            else chk.put(c, chk.get(c)+1);

            char cl = s.charAt(l);
            while(r>=l && chk.containsKey(cl) && chk.get(cl)>1){
                chk.put(cl, chk.get(cl)-1);
                l++;
                cl = s.charAt(l);
            }

            if(chk.size() == numOfDistChars){
                smallestWindowSize = Math.min(smallestWindowSize, r-l+1);
            }
        }

        return smallestWindowSize;
    }

    static int findSmallestSubStringWithDistCharsOptimised(String s) {
        int n = s.length();

        // ----------------------------------------------------------
        // Since the problem states: "string contains only lowercase"
        // we use a compact freq array of size 26.
        //
        // To extend for full ASCII:
        //     change to: int[] freq = new int[256];
        //     and use:   freq[s.charAt(i)] instead of (c - 'a')
        // ----------------------------------------------------------
        int[] freq = new int[26];

        // Count distinct lowercase characters in the string.
        // For ASCII: use boolean[256] instead of seen[26].
        boolean[] seen = new boolean[26];
        int required = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a'; // For ASCII: directly use idx as c
            if (!seen[idx]) {
                seen[idx] = true;
                required++;
            }
        }

        int formed = 0;  // how many distinct chars currently present in window
        int l = 0;
        int minLen = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            int idx = c - 'a'; // For ASCII: directly use idx as c
            if (freq[idx] == 0) {
                formed++;
            }
            freq[idx]++;

            // If the window currently contains all distinct characters
            while (l <= r && formed == required) {

                minLen = Math.min(minLen, r - l + 1);

                char cl = s.charAt(l);
                int leftIdx = cl - 'a'; // For ASCII: directly use idx as c

                freq[leftIdx]--;
                if (freq[leftIdx] == 0) {
                    formed--;
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        String s1 = "aabcbcdbca";
        String s2 = "aaab";
        String s3 = "geeksoforgeeks";
        String s4 = "asdfghjklqwertyuiopzxcvbnm";

        System.out.println(findSmallestSubStringWithDistChars(s1));
        System.out.println(findSmallestSubStringWithDistChars(s2));
        System.out.println(findSmallestSubStringWithDistChars(s3));
        System.out.println(findSmallestSubStringWithDistChars(s4));
    }
}
