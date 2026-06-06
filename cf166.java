public class cf166 {

// TEST CASES FAILED
//    static boolean isWindowHavingNonRepetitiveChars(int[] freq) {
//        for(int i=0; i<26; i++) {
//            if(freq[i] > 1) return false;
//        }
//
//        return true;
//    }
//
//    static int longestUniqueSubstring(String s) {
//        int maxSubStrLength = Integer.MIN_VALUE;
//        int n = s.length();
//
//        int[] freq = new int[26];
//
//        int l=0;
//        for(int r=0; r<n; r++) {
//            char cr = s.charAt(r);
//            freq[cr-'a']++;
//
//            char cl = s.charAt(l);
//
//            while(r>=l && freq[cl-'a']>1){
//                freq[cl-'a']--;
//                l++;
//                cl = s.charAt(l);
//            }
//
//            if(isWindowHavingNonRepetitiveChars(freq)){
//                maxSubStrLength = Math.max(maxSubStrLength , (r-l+1));
//            }
//        }
//
//        return maxSubStrLength;
//    }

    static int longestUniqueSubstringWithClearLogic(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] freq = new int[26];
        int l = 0, maxLen = 0;

        for (int r = 0; r < n; r++) {
            int idxR = s.charAt(r) - 'a';
            freq[idxR]++;

            // Shrink window until character at r becomes unique
            while (freq[idxR] > 1) {
                int idxL = s.charAt(l) - 'a';
                freq[idxL]--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "abdefgabef";
        String s3 = "aaaaa";

        System.out.println(longestUniqueSubstringWithClearLogic(s1));
        System.out.println(longestUniqueSubstringWithClearLogic(s2));
        System.out.println(longestUniqueSubstringWithClearLogic(s3));
    }
}
