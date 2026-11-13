package DynamicProgramming;

public class DP15PartitionEqualSubsetSum {
    // a solution based on prev problem DP14
    public boolean canPartition(int[] arr) {
        int l = arr.length;

        int sum = 0;
        for(int i: arr) sum += i;

        if( sum%2 != 0 ) return false;
        int halfOfSum = sum/2;

        boolean[] prev = new boolean[halfOfSum+1];

        prev[0]=true;
        if(arr[0]<=halfOfSum) prev[arr[0]] = true;

        for(int index=1; index<l; index++) {
            boolean[] curr = new boolean[halfOfSum+1];
            curr[0] = true;

            for(int target=1; target<=halfOfSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[index])
                    take = prev[ target-arr[index] ];

                curr[target] = take || notTake;
            }

            prev = curr;
        }

        return prev[halfOfSum];
    }
}
