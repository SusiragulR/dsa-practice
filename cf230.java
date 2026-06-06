import java.util.ArrayList;
import java.util.Arrays;

public class cf230 {
//    private static ArrayList<String> findPermutation(String s) {
//        String str = "";
//        ArrayList<String> ans = new ArrayList<>();
//        int[] isUsed = new int[s.length()];
//
//        findPermutationsUtil(ans, s, str, isUsed);
//
//        return ans;
//    }
//
//    private static void findPermutationsUtil(ArrayList<String> ans, String ogStr, String str, int[] isUsed) {
//        for (int i=0; i<isUsed.length; i++) {
//            //System.out.println("s-> "+str+" i-> "+i);
//            if(isUsed[i]==0) {
//                isUsed[i]=1;
//                str = str + ogStr.charAt(i);
//                findPermutationsUtil(ans, ogStr, str, isUsed);
//                if(str.length() == isUsed.length) ans.add(str);
//                str = str.substring(0, str.length() - 1);
//                isUsed[i]=0;
//            }
//        }
//    }

//    Using stringBuilder for optimization. That adds and removes character from a string in O(1) complexity

    private static ArrayList<String> findPermutation(String s) {
        ArrayList<String> ans = new ArrayList<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int[] isUsed = new int[arr.length];
        StringBuilder sb = new StringBuilder();

        findPermutationsUtil(ans, arr, sb, isUsed);
        return ans;
    }

    private static void findPermutationsUtil(
            ArrayList<String> ans,
            char[] arr,
            StringBuilder sb,
            int[] isUsed
    ) {
        // base case
        if (sb.length() == arr.length) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (isUsed[i] == 1) continue;

            if (i > 0 && arr[i] == arr[i - 1] && isUsed[i - 1] == 0)
                continue;

            isUsed[i] = 1;
            sb.append(arr[i]);

            findPermutationsUtil(ans, arr, sb, isUsed);

            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "ABC";

        System.out.println(findPermutation(s1));
    }
}
