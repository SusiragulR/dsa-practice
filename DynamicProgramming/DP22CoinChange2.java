package DynamicProgramming;

public class DP22CoinChange2 {
    //Recursive
    // public int change(int amount, int[] coins) {
    //     return numOfWaysRecursive(coins.length-1, amount, coins);
    // }

    // public int numOfWaysRecursive(int index, int amount, int[] coins) {
    //     if(index == 0) return ( amount%coins[0] == 0 ) ? 1 : 0;

    //     int notPick = numOfWaysRecursive(index-1, amount, coins);
    //     int pick = 0;
    //     if(amount >= coins[index]) pick = numOfWaysRecursive(index, amount-coins[index], coins);

    //     return pick + notPick;
    // }

    //-------------------

    //memoisation
    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length][amount+1];
    //     for(int[] arr: dp) Arrays.fill(arr, -1);

    //     return numOfWaysRecursive(coins.length-1, amount, coins, dp);
    // }

    // public int numOfWaysRecursive(int index, int amount, int[] coins, int[][] dp) {
    //     if(index == 0) return ( amount%coins[0] == 0 ) ? 1 : 0;

    //     if(dp[index][amount] != -1) return dp[index][amount];

    //     int notPick = numOfWaysRecursive(index-1, amount, coins, dp);
    //     int pick = 0;
    //     if(amount >= coins[index]) pick = numOfWaysRecursive(index, amount-coins[index], coins, dp);

    //     dp[index][amount] = pick + notPick;
    //     return dp[index][amount];
    // }

    //-------------------

    //tabulation
    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length][amount+1];

    //     //base cases:
    //     for(int tempAmount=0; tempAmount<=amount; tempAmount++) {
    //         dp[0][tempAmount] = tempAmount%coins[0]==0 ? 1 : 0;
    //     }

    //     for(int index=1; index<coins.length; index++) {
    //         for(int target=0; target<=amount; target++) {
    //             int notPick = dp[index-1][target];
    //             int pick = 0;
    //             if(target >= coins[index]) pick = dp[ index ][ target-coins[index] ];

    //             dp[index][target] = pick + notPick;
    //         }
    //     }

    //     return dp[coins.length-1][amount];
    // }

    //--------------------

    //space-reduction (single row technique learnt)
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];

        //base cases:
        for(int tempAmount=0; tempAmount<=amount; tempAmount++) {
            prev[tempAmount] = tempAmount%coins[0]==0 ? 1 : 0;
        }

        for(int index=1; index<coins.length; index++) {
            for(int target=0; target<=amount; target++) {
                int notPick = prev[target];
                int pick = 0;
                if(target >= coins[index]) pick = prev[ target-coins[index] ];

                prev[target] = pick + notPick;
            }
        }

        return prev[amount];
    }
}
