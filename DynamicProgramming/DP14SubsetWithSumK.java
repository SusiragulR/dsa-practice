package DynamicProgramming;

public class DP14SubsetWithSumK {
    //Recursion
//     static boolean isSubsetSum(int arr[], int sum) {
// 		return recursiveUtil( arr.length-1, sum, arr );
// 	}

// 	static boolean recursiveUtil (int index, int target, int[] arr) {
// 		// base
// 		if (target == 0)
// 			return true;
// 		if (index == 0)
// 			return arr[0] == target;

// 		// recursive
// 		boolean notTake = recursiveUtil(index - 1, target, arr);
// 		boolean take = false;
// 		if (target >= arr[index])
// 			take = recursiveUtil(index - 1, target - arr[index], arr);


// 		return take || notTake;
// 	}

    //----------------------

    //Memoisation
// 	static boolean isSubsetSum(int arr[], int sum) {
// 	    int[][] dp = new int[arr.length][sum+1];

// 	    for(int[] temp: dp) Arrays.fill( temp, -1 );

// 		return recursiveUtil( arr.length-1, sum, arr, dp );
// 	}

// 	static boolean recursiveUtil (int index, int target, int[] arr, int[][] dp) {
// 		// base
// 		if (target == 0) {
// 		    dp[index][target] = 1;
// 			return true;
// 		}

// 		if (index == 0) {
// 		    dp[index][target] = arr[0] == target ? 1 : 0;
// 			return arr[0] == target;
// 		}

// 		if(dp[index][target] != -1) return dp[index][target]==1;

// 		// recursive
// 		boolean notTake = recursiveUtil(index - 1, target, arr, dp);
// 		boolean take = false;
// 		if (target >= arr[index])
// 			take = recursiveUtil(index - 1, target - arr[index], arr, dp);

// 		dp[index][target] = (take || notTake) ? 1 : 0;
// 		return take || notTake;
// 	}

    //--------------------------

    //Tabulation
// 	static boolean isSubsetSum(int arr[], int sum) {
// 	    int l = arr.length;

// 	    boolean[][] dp = new boolean[l][sum+1];

// 	    for(int i=0; i<l; i++) dp[i][0]=true;
// 	    if(arr[0]<=sum) dp[0][arr[0]] = true;

// 		for(int index=1; index<l; index++) {
// 		    for(int target=1; target<=sum; target++) {
// 		        boolean notTake = dp[index-1][target];
// 		        boolean take = false;
//         		if (target >= arr[index])
//         			take = dp[index-1][ target-arr[index] ];

//         		dp[index][target] = take || notTake;
// 		    }
// 		}

// 		return dp[l-1][sum];
// 	}

    //----------------------------

    //space-reduction
    static boolean isSubsetSum(int arr[], int sum) {
        int l = arr.length;

        boolean[] prev = new boolean[sum+1];

        prev[0]=true;
        if(arr[0]<=sum) prev[arr[0]] = true;

        for(int index=1; index<l; index++) {
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;

            for(int target=1; target<=sum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[index])
                    take = prev[ target-arr[index] ];

                curr[target] = take || notTake;
            }

            prev = curr;
        }

        return prev[sum];
    }
}
