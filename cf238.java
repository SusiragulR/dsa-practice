import java.util.ArrayList;
import java.util.Arrays;

public class cf238 {
    public static ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> present = new ArrayList<>();

        Arrays.sort(arr);

        //subsetsUtil(arr, present, 0, true, ans);
        subsetsUtil2(0, arr, present, ans);

        return ans;
    }

    //doesn't give lexicographically sorted ans
    // [[], [2], [2, 2], [2, 2, 2], [1], [1, 2], [1, 2, 2], [1, 2, 2, 2]]
    public static void subsetsUtil(
            int[] arr,
            ArrayList<Integer> present,
            int presentIndx,
            boolean isPrevElementPicked,
            ArrayList<ArrayList<Integer>> ans
    ) {
        //base
        if(presentIndx >= arr.length) {
            ans.add(new ArrayList<Integer>(present));
            return;
        }

        //not picking the element
        subsetsUtil(arr, present, presentIndx+1, false, ans);

        //picking the element
        //if prev element is same and that is not picked, it should not be picked for uniqueness
        //in other words if prev element is same, this element should be picked only if prev element is picked
        boolean isConsiderableForPicking = presentIndx==0 ||
                arr[presentIndx]!=arr[presentIndx-1] ||
                isPrevElementPicked;

        if(
                isConsiderableForPicking
        ) {
            present.add(arr[presentIndx]);
            subsetsUtil(arr, present, presentIndx+1, true, ans);
            present.remove( present.size()-1 );
        }

    }

    //gives lexicographically sorted ans
    // [[], [1], [1, 2], [1, 2, 2], [1, 2, 2, 2], [2], [2, 2], [2, 2, 2]]
    static void subsetsUtil2(
            int start,
            int[] arr,
            ArrayList<Integer> curr,
            ArrayList<ArrayList<Integer>> ans
    ) {
        ans.add(new ArrayList<>(curr));

        for (int i = start; i < arr.length; i++) {
            // skip duplicates
            if (i > start && arr[i] == arr[i - 1]) continue;

            curr.add(arr[i]);
            subsetsUtil2(i + 1, arr, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr1 =  new int[]{2, 1, 2};
        int[] arr2 =  new int[]{2, 1, 2, 2};

        System.out.println(subsets(arr2));
    }
}
