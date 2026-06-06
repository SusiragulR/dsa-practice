public class cf165 {
    static boolean isWindowHavingAllReqdChars(int[] freqS, int[] freqP) {
        for(int i=0; i<26; i++) {
            if(freqP[i]>0 && freqP[i]>freqS[i]) return false;
        }

        return true;
    }

    static String smallestWindowWithAllCharsInOtherStringIncludingDuplicates(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        int[] freqOfS = new int[26];
        int[] freqOfP = new int[26];

        for (int i=0; i<lenP; i++) {
            char c = p.charAt(i);
            int idx = c - 'a';
            freqOfP[idx] = freqOfP[idx] + 1;
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int ansLeftIndx = -1, ansRightIndx = -1;

        for (int r = 0; r < lenS; r++) {
            int idx = s.charAt(r) - 'a';
            freqOfS[idx]++;

            while (l <= r && isWindowHavingAllReqdChars(freqOfS, freqOfP)) {
                if(minLen > (r-l+1)) {
                    minLen = r-l+1;
                    ansLeftIndx = l;
                    ansRightIndx = r;
                }
                int leftIdx = s.charAt(l) - 'a';
                freqOfS[leftIdx]--;
                l++;
            }
        }

        if(ansLeftIndx == -1 && ansRightIndx == -1) return "";

        return s.substring(ansLeftIndx, ansRightIndx+1);
    }

    public static void main(String[] args) {
        String s1 = "timetopractice";
        String p1 = "toc";

        String s2 = "zoomlazapzo";
        String p2 = "oza";

        String s3 = "zoom";
        String p3 = "zooe";

        String s4 = "aabcbcdbca";
        String p4 = "abc";

        System.out.println(smallestWindowWithAllCharsInOtherStringIncludingDuplicates(s1, p1));
        System.out.println(smallestWindowWithAllCharsInOtherStringIncludingDuplicates(s2, p2));
        System.out.println(smallestWindowWithAllCharsInOtherStringIncludingDuplicates(s3, p3));
        System.out.println(smallestWindowWithAllCharsInOtherStringIncludingDuplicates(s4, p4));
    }
}
