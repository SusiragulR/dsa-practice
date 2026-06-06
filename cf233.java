import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cf233 {
    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        findTargetSumCombs( arr, 0, target, ls, ans );

        return ans;
    }

    public static void findTargetSumCombs(
            int[] arr,
            int index,
            int target,
            List<Integer> ls,
            List<List<Integer>> ans
    ) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i]==arr[i - 1]) continue;

            if (arr[i] > target) break;

            ls.add(arr[i]);
            findTargetSumCombs(arr, i + 1, target - arr[i], ls, ans);
            ls.remove(ls.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10,1,2,7,6,1,5};
        int target1 = 8;

        int[] arr2 = new int[]{2,5,2,1,2};
        int target2 = 5;

        System.out.println( combinationSum2(arr2, target2) );
    }
}
