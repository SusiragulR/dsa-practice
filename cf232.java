import java.util.ArrayList;
import java.util.Arrays;

public class cf232 {
    public static ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();

        findTargetSumCombs( arr, 0, target, ls, ans );

        return ans;
    }

    public static void findTargetSumCombs(
            int[] arr,
            int index,
            int target,
            ArrayList<Integer> ls,
            ArrayList<ArrayList<Integer>> ans
    ){
        //base case
        if(index==arr.length || target<0) return;

        if(target==0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        //pick
        if(arr[index]<=target) {
            ls.add(arr[index]);
            findTargetSumCombs( arr, index, target-arr[index], ls, ans);
            ls.removeLast();
        }

        //not-pick
        findTargetSumCombs( arr, index+1, target, ls, ans);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int target1 = 40;

        System.out.println( targetSumComb(arr1, target1) );
    }
}
