import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class cf252 {

//    public static String findMaximumNum(String s, int k) {
//        StringBuilder sb = new StringBuilder(s);
//        int[] swapCount = new int[]{0};
//        String[] ans = new String[]{s};   // store max as String
//        HashMap<Character, HashSet<Character>> hm = new HashMap<>();
//
//        findMaximumNumInKSwapsUtil(swapCount, sb, k, ans, hm);
//
//        return ans[0];
//    }

//    THIS WORKED BUT AS IT HAS A HASHMAP CHECK, IT CHECKS BASED ON CHARACTERS
//    IN THIS I/P: "224433", K=5, IT ALLOWS (4,3) SWAPPING ONLY ONCE
//
//    private static void findMaximumNumInKSwapsUtil(
//            int[] swapCount,
//            StringBuilder sb,
//            int k,
//            String[] ans,
//            HashMap<Character, HashSet<Character>> hm
//    ) {
//
//        // update maximum (lexicographic comparison works since same length)
//        if (sb.toString().compareTo(ans[0]) > 0) {
//            ans[0] = sb.toString();
//        }
//
//        if (swapCount[0] == k) return;
//
//        int n = sb.length();
//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                // corrected condition
//                if (
//                        (hm.containsKey(sb.charAt(i)) &&
//                                hm.get(sb.charAt(i)).contains(sb.charAt(j))) ||
//
//                                (hm.containsKey(sb.charAt(j)) &&
//                                        hm.get(sb.charAt(j)).contains(sb.charAt(i)))
//                ) continue;
//
//                if (sb.charAt(j) > sb.charAt(i)) {
//
//                    // add to hashmap
//                    checkAndAddInHMap(sb.charAt(i), sb.charAt(j), hm);
//                    checkAndAddInHMap(sb.charAt(j), sb.charAt(i), hm);
//
//                    // swap
//                    char temp = sb.charAt(i);
//                    sb.setCharAt(i, sb.charAt(j));
//                    sb.setCharAt(j, temp);
//
//                    swapCount[0]++;
//
//                    findMaximumNumInKSwapsUtil(swapCount, sb, k, ans, hm);
//
//                    swapCount[0]--;
//
//                    // swap back (backtrack)
//                    temp = sb.charAt(i);
//                    sb.setCharAt(i, sb.charAt(j));
//                    sb.setCharAt(j, temp);
//
//                    // remove from hashmap (correct order)
//                    checkAndRemoveInHMap(sb.charAt(i), sb.charAt(j), hm);
//                    checkAndRemoveInHMap(sb.charAt(j), sb.charAt(i), hm);
//                }
//            }
//        }
//    }

    public static String findMaximumNum(String s, int k) {
        char[] sArr = s.toCharArray();
        String[] max = new String[]{s};

        findMaximumNumInKSwapsUtil(0, k, sArr, max);

        return max[0];
    }

    private static void findMaximumNumInKSwapsUtil(
            int indx,
            int k,
            char[] s,
            String[] max
    ) {
        if(k==0) return;

        int n = s.length;
        int maxDigit = s[indx];

        //find actual max Digit
        for(int i=indx+1; i<n; i++) {
            if(maxDigit < s[i]) maxDigit=s[i];
        }

        //if the num at present index is not max, then we swap
        if(maxDigit != s[indx]) k--;

        for (int i=n-1; i>=indx; i--) {
            if(s[i] == maxDigit) {
                //swap
                char temp = s[indx];
                s[indx] = s[i];
                s[i] = temp;

                String current = new String(s);

                if(current.compareTo(max[0]) > 0) max[0] = current;

                if(indx+1 < n) findMaximumNumInKSwapsUtil(indx+1, k, s, max);

                //backtrack
                char temp1 = s[indx];
                s[indx] = s[i];
                s[i] = temp1;
            }
        }
    }
//    private static void checkAndAddInHMap(
//            char key,
//            char val,
//            HashMap<Character, HashSet<Character>> hm
//    ) {
//        if (!hm.containsKey(key)) {
//            hm.put(key, new HashSet<>());
//        }
//        hm.get(key).add(val);
//    }
//
//    private static void checkAndRemoveInHMap(
//            char key,
//            char val,
//            HashMap<Character, HashSet<Character>> hm
//    ) {
//        if (hm.containsKey(key)) {
//            hm.get(key).remove(val);
//            if (hm.get(key).isEmpty()) {
//                hm.remove(key);
//            }
//        }
//    }

    public static void main(String[] args) {
        String s1 = "1234567";
        int k1 = 4;

        String s2 = "3435335";
        int k2 = 3;

        String s3 = "1034";
        int k3 = 2;

        System.out.println( findMaximumNum(s1, k1) );
        System.out.println( findMaximumNum(s2, k2) );
        System.out.println( findMaximumNum(s3, k3) );
        System.out.println( findMaximumNum("224334", 5) );
    }
}
