import java.util.Arrays;

public class cf253 {
    public static boolean isKPartitionPossible(int[] arr, int k) {
        int n = arr.length;
        int totalSum = 0;

        for(int num: arr) totalSum+=num;

        if(totalSum%k != 0) return false;

        int target = totalSum/k;

        Arrays.sort(arr);

        //descending ordr for better pruning
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        if (arr[0] > target) return false;

        boolean[] isUsed = new boolean[n];

        return isKPartitionPossibleUtil( arr, isUsed, k, 0, 0, target);
    }

    private static boolean isKPartitionPossibleUtil (
            int[] arr,
            boolean[] isUsed,
            int k,
            int start,
            int currentSum,
            int target
    ) {
        if( k==1 ) return true;

        if( currentSum==target ) return isKPartitionPossibleUtil(arr, isUsed, k-1, 0, 0, target);

        for (int i=start; i<arr.length; i++) {
            if( isUsed[i] ) continue;

            if( currentSum+arr[i] > target ) continue;

            isUsed[i]=true;

            if( isKPartitionPossibleUtil(arr, isUsed, k, start+1, currentSum+arr[i], target) ) return true;

            isUsed[i]=false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 4, 5, 6};
        int k1 = 3;
        System.out.println(isKPartitionPossible(arr1, k1)); // true

        int[] arr2 = {2, 1, 5, 5, 6};
        int k2 = 3;
        System.out.println(isKPartitionPossible(arr2, k2)); // false
    }
}
