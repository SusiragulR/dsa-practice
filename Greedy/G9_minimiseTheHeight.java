package Greedy;

import java.util.Arrays;

public class G9_minimiseTheHeight {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        if(n==1) return 0;

        Arrays.sort(arr);

        int ans = arr[arr.length-1] - arr[0];

        for(int i=0; i<n-1; i++) {
            //imagine splitting the array at position 'i'
            //till position i, k will be added to value
            //from i+1 to end, k will be deducted
            //we initialised 'ans' as present largest - smallest

            //this way, at each split min will be - min of arr[0]+k and arr[i+1]-k
            //max will be - max of arr[i]+k and arr[n-1]-k
            int smallest = Math.min(arr[0]+k, arr[i+1]-k);
            int largest = Math.max(arr[i]+k, arr[n-1]-k);

            //each splits diff (largest - smallest) should be compared and updated with ans
            ans = Math.min( ans, largest-smallest );
        }

        return ans;
    }
}
