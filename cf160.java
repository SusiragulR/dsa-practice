import java.util.ArrayList;
import java.util.Arrays;

public class cf160 {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int l=0, r=0;
        int n = arr.length;

        long sum = arr[0];

        if(sum == target) return new ArrayList<>(Arrays.asList(1,1));

        while(l<=r && r<n) {
            if(sum == target) return new ArrayList<>(Arrays.asList(l+1,r+1));

            else if(l==r && sum > (long)target) {
                l++;
                r++;
                if(l<n) sum = (long)arr[l];
            }

            else if(sum < (long)target) {
                r++;
                if(r<n) sum += (long)arr[r];
            }

            else if(sum > (long)target) {
                sum -= (long)arr[l];
                l++;
            }
        }

        return new ArrayList<>(Arrays.asList(-1));
    }

    static ArrayList<Integer> subarraySumWithCleanCode(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        long sum = 0;

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (l <= r && sum > target) {
                sum -= arr[l];
                l++;
            }

            if (sum == target) {
                return new ArrayList<>(Arrays.asList(l + 1, r + 1));
            }
        }

        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 7, 5};
        int target1 = 12; //ans = [2, 4]

        int[] arr2 = new int[]{1, 2, 3, 7, 5, 1};
        int target2 = 19; //ans = [1, 6]

        int[] arr3 = new int[]{0, 1, 0};
        int target3 = 1; //ans = [1, 2]

        int[] arr4 = new int[]{3, 1, 1};
        int target4 = 1; //ans = [2, 2]

        int[] arr5 = new int[]{9, 8, 7, 6, 5, 1, 1};
        int target5 = 7; //ans = [3, 3]

        System.out.println(subarraySumWithCleanCode(arr1, target1));
        System.out.println(subarraySumWithCleanCode(arr2, target2));
        System.out.println(subarraySumWithCleanCode(arr3, target3));
        System.out.println(subarraySumWithCleanCode(arr4, target4));
        System.out.println(subarraySumWithCleanCode(arr5, target5));
    }
}
