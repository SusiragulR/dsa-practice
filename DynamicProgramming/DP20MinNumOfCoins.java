package DynamicProgramming;

public class DP20MinNumOfCoins {
    //Recursion
    // public int coinChange(int[] coins, int amount) {
    //     int ans = recursiveUtil(coins.length-1, amount, coins);
    //     return ans >= (int)1e9 ? -1 : ans;
    // }

    // public int recursiveUtil(int index, int amount, int[] coins) {
    //     if(amount==0) return 0;

    //     if(index == 0) {
    //         if(
    //             amount>=coins[0] &&
    //             amount%coins[0] == 0
    //         ) return amount/coins[0];

    //         else return (int)1e9;
    //     }

    //     int notPick = recursiveUtil(index-1, amount, coins);

    //     int pick = (int)1e9;
    //     if(amount >= coins[index]) {
    //         int res = recursiveUtil(index, amount-coins[index], coins);
    //         if(res != (int)1e9) pick = 1 + res;
    //     }

    //     return Math.min( pick, notPick );
    // }

    //-----------------------

    //Memoisation
    // public int coinChange(int[] coins, int amount) {
    //     int[][] dp = new int[coins.length][amount+1];

    //     for(int[] arr: dp) Arrays.fill(arr, -1);

    //     int ans = recursiveUtil(coins.length-1, amount, coins, dp);

    //     return ans >= (int)1e9 ? -1 : ans;
    // }

    // public int recursiveUtil(int index, int amount, int[] coins, int[][] dp) {
    //     if(amount==0) return 0;

    //     if(index == 0) {
    //         if(
    //             amount>=coins[0] &&
    //             amount%coins[0] == 0
    //         ) return amount/coins[0];

    //         else return (int) 1e9;
    //     }

    //     if(dp[index][amount] != -1) return dp[index][amount];

    //     int notPick = recursiveUtil(index-1, amount, coins, dp);

    //     int pick = (int) 1e9;
    //     if(amount >= coins[index]) {
    //         int res = recursiveUtil(index, amount-coins[index], coins, dp);
    //         if(res != (int) 1e9) pick = 1 + res;
    //     }

    //     dp[index][amount] = Math.min( pick, notPick );
    //     return dp[index][amount];
    // }

    //----------------------

    //Tabulation
    // public int coinChange(int[] coins, int totalAmount) {
    //     int[][] dp = new int[coins.length][totalAmount+1];

    //     //base cases:
    //     for(int amount=0; amount<=totalAmount; amount++) {
    //         dp[0][amount] = (amount%coins[0] == 0) ? amount/coins[0] : (int)1e9;
    //     }

    //     for(int index=1; index<coins.length; index++) {
    //         for(int amount=0; amount<=totalAmount; amount++) {
    //             int notPick = dp[index-1][amount];

    //             int pick = (int) 1e9;
    //             if(amount >= coins[index]) {
    //                 int res = dp[index][amount-coins[index]];
    //                 if(res != (int) 1e9) pick = 1 + res;
    //             }

    //             dp[index][amount] = Math.min( pick, notPick );
    //         }
    //     }

    //     return dp[coins.length-1][totalAmount] >= (int)1e9 ? -1 : dp[coins.length-1][totalAmount];
    // }

    //----------------------

    //Space-reduction (optimised to just use prev[] as did in knapsck)
    public int coinChange(int[] coins, int totalAmount) {
        int[] prev = new int[totalAmount+1];

        //base cases:
        for(int amount=0; amount<=totalAmount; amount++) {
            prev[amount] = (amount%coins[0] == 0) ? amount/coins[0] : (int)1e9;
        }

        for(int index=1; index<coins.length; index++) {
            for(int amount=0; amount<=totalAmount; amount++) {
                int notPick = prev[amount];

                int pick = (int) 1e9;
                if(amount >= coins[index]) {
                    int res = prev[amount-coins[index]];
                    if(res != (int) 1e9) pick = 1 + res;
                }

                prev[amount] = Math.min( pick, notPick );
            }
        }

        return prev[totalAmount] >= (int)1e9 ? -1 : prev[totalAmount];
    }
}
