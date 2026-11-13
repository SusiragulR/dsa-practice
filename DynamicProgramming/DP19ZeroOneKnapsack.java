package DynamicProgramming;

public class DP19ZeroOneKnapsack {
    //Recursion
    // public int knapsack(int W, int val[], int wt[]) {
    //     return recursiveUtil(val.length-1, W, val, wt);
    // }

    // public int recursiveUtil(int index, int capacity, int[] val, int[] wt) {
    //     if(index == 0) {
    //         return (capacity >= wt[0]) ? val[0] : 0;
    //     }

    //     if(capacity <= 0) return 0;

    //     int notPick = recursiveUtil(index-1, capacity, val, wt);

    //     int pick = Integer.MIN_VALUE;
    //     if( capacity >= wt[index] ) pick = val[index] + recursiveUtil(index-1, capacity-wt[index], val, wt);

    //     return Math.max( pick, notPick );
    // }

    //---------------------

    //Memoisation
    // public int knapsack(int W, int val[], int wt[]) {
    //     int[][] dp = new int[val.length][W+1];

    //     for(int[] arr: dp) Arrays.fill(arr, -1);

    //     return recursiveUtil(val.length-1, W, val, wt, dp);
    // }

    // public int recursiveUtil(int index, int capacity, int[] val, int[] wt,  int[][] dp) {
    //     if(index == 0) {
    //         return (capacity >= wt[0]) ? val[0] : 0;
    //     }

    //     if(capacity <= 0) return 0;

    //     if(dp[index][capacity] != -1) return dp[index][capacity];

    //     int notPick = recursiveUtil(index-1, capacity, val, wt, dp);

    //     int pick = Integer.MIN_VALUE;
    //     if( capacity >= wt[index] ) pick = val[index] + recursiveUtil(index-1, capacity-wt[index], val, wt, dp);

    //     dp[index][capacity] = Math.max( pick, notPick );

    //     return dp[index][capacity];
    // }

    //-----------------------

    //Tabulation
    // public int knapsack(int W, int val[], int wt[]) {
    //     int[][] dp = new int[val.length][W+1];

    //     //base cases:
    //     for(int capacity=0; capacity<=W; capacity++) {
    //         dp[0][capacity] = (capacity >= wt[0]) ? val[0] : 0;
    //     }

    //     for(int index=1; index<val.length; index++) {
    //         for(int capacity=0; capacity<=W; capacity++) {
    //             int notPick = dp[index-1][capacity];

    //             int pick = Integer.MIN_VALUE;
    //             if( capacity >= wt[index] ) pick = val[index] + dp[index-1][ capacity-wt[index] ];

    //             dp[index][capacity] = Math.max( pick, notPick );
    //         }
    //     }

    //     return dp[val.length-1][W];
    // }

    //-------------------------

    //Space-reduction
    // public int knapsack(int W, int val[], int wt[]) {
    //     int[] prev = new int[W+1];

    //     //base cases:
    //     for(int capacity=0; capacity<=W; capacity++) {
    //         prev[capacity] = (capacity >= wt[0]) ? val[0] : 0;
    //     }

    //     for(int index=1; index<val.length; index++) {
    //         int[] curr = new int[W+1];

    //         for(int capacity=0; capacity<=W; capacity++) {
    //             int notPick = prev[capacity];

    //             int pick = Integer.MIN_VALUE;
    //             if( capacity >= wt[index] ) pick = val[index] + prev[ capacity-wt[index] ];

    //             curr[capacity] = Math.max( pick, notPick );
    //         }

    //         prev = curr;
    //     }

    //     return prev[W];
    // }

    //even more optimised version of space reduction - learnt
    //when curr is filled wee fill left to right now
    //when we obsrve: each computation in curr needs prev row's left elements
    //(looks for 'capacity-wt[index]' position in prev)
    //if we right to left, we can reuse same prev for this
    public int knapsack(int W, int val[], int wt[]) {
        int[] prev = new int[W+1];

        //base cases:
        for(int capacity=0; capacity<=W; capacity++) {
            prev[capacity] = (capacity >= wt[0]) ? val[0] : 0;
        }

        for(int index=1; index<val.length; index++) {
            for(int capacity=W; capacity>=0; capacity--) {
                int notPick = prev[capacity];

                int pick = Integer.MIN_VALUE;
                if( capacity >= wt[index] ) pick = val[index] + prev[ capacity-wt[index] ];

                prev[capacity] = Math.max( pick, notPick );
            }
        }

        return prev[W];
    }
}
