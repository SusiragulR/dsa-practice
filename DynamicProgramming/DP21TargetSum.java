package DynamicProgramming;

public class DP21TargetSum {
    //Recursive
    // public int findTargetSumWays(int[] nums, int target) {
    //     int totalSum = 0;

    //     for(int i: nums) totalSum += i;

    //     if( (totalSum+target)%2 != 0 ) return 0;

    //     return recursiveNumOfWays(nums.length-1, (totalSum+target)/2, nums);
    // }

    // public int recursiveNumOfWays(int index, int target, int[] nums) {
    //     //base
    //     if(index == 0) {
    //         if(target==0) {
    //             return nums[0]==0 ? 2 : 1;
    //         }
    //         return target==nums[0] ? 1 :  0;
    //     }

    //     //recursive
    //     int notPick = recursiveNumOfWays(index-1, target, nums);
    //     int pick = 0;
    //     if(target >= nums[index]) pick = recursiveNumOfWays(index-1, target-nums[index], nums);

    //     return notPick + pick;
    // }

    //-----------------------

    //Memoisation
    // public record Pair(int index, int target) {}

    // public int findTargetSumWays(int[] nums, int target) {
    //     int totalSum = 0;
    //     for(int i: nums) totalSum += i;

    //     if( (totalSum+target)%2 != 0 ) return 0;

    //     HashMap<Pair,Integer> dp = new HashMap<>();

    //     return recursiveNumOfWays(nums.length-1, (totalSum+target)/2, nums, dp);
    // }

    // public int recursiveNumOfWays(int index, int target, int[] nums, HashMap<Pair,Integer> dp) {
    //     //base
    //     if(index == 0) {
    //         if(target==0) {
    //             return nums[0]==0 ? 2 : 1;
    //         }
    //         return target==nums[0] ? 1 :  0;
    //     }

    //     Pair indexTarget = new Pair(index,target);
    //     if( dp.containsKey(indexTarget) ) return dp.get(indexTarget);

    //     //recursive
    //     int notPick = recursiveNumOfWays(index-1, target, nums, dp);
    //     int pick = 0;
    //     if(target >= nums[index]) pick = recursiveNumOfWays(index-1, target-nums[index], nums, dp);

    //     dp.put(indexTarget, notPick+pick);
    //     return notPick+pick;
    // }

    // ABOVE HASHMAP METHIOD NOT NEEDED:
    /*
     * WHY A HASHMAP WAS NEEDED ORIGINALLY:
     * Without checking if (totalSum + target < 0), a large negative target
     * results in a negative subset sum (e.g., -1000).
     * - A standard array would crash with an ArrayIndexOutOfBoundsException.
     * - A HashMap happily accepted negative values in the Pair key as a workaround.
     *
     * Once we add the guard check `totalSum + target < 0`, the target is
     * guaranteed to be between 0 and S, allowing us to drop the HashMap
     * and use a fast 2D array or 1D space-optimized array safely.
     */

    //Proper memoisation using matrix:
    // public int findTargetSumWays(int[] nums, int target) {
    //     int totalSum = 0;

    //     for(int i: nums) totalSum += i;
    //     if(
    //         (totalSum+target) < 0 ||
    //         (totalSum+target)%2 != 0
    //     ) return 0;

    //     int s = (totalSum+target)/2;

    //     int[][] dp = new int[nums.length][s+1];
    //     for(int[] arr: dp) Arrays.fill(arr, -1);

    //     return recursiveNumOfWays(nums.length-1, s, nums, dp);
    // }

    // public int recursiveNumOfWays(int index, int target, int[] nums, int[][] dp) {
    //     //base
    //     if(index == 0) {
    //         if(target==0) {
    //             return nums[0]==0 ? 2 : 1;
    //         }
    //         return target==nums[0] ? 1 :  0;
    //     }

    //     if(dp[index][target] != -1) return dp[index][target];

    //     //recursive
    //     int notPick = recursiveNumOfWays(index-1, target, nums, dp);
    //     int pick = 0;
    //     if(target >= nums[index]) pick = recursiveNumOfWays(index-1, target-nums[index], nums, dp);

    //     dp[index][target] = notPick + pick;
    //     return dp[index][target];
    // }

    //----------------------

    //Tabulation
    // public int findTargetSumWays(int[] nums, int target) {
    //     int totalSum = 0;

    //     for(int i: nums) totalSum += i;
    //     if(
    //         (totalSum+target) < 0 ||
    //         (totalSum+target)%2 != 0
    //     ) return 0;

    //     int s = (totalSum+target)/2;

    //     int[][] dp = new int[nums.length][s+1];

    //     //base cases:
    //     //index=0 and target=0 case:
    //     dp[0][0] = nums[0]==0 ? 2 : 1;
    //     //index=0 and nums[0]!=0 case:
    //     if(nums[0]!=0 && nums[0]<=s) dp[ 0 ][ nums[0] ] = 1;

    //     for(int index=1; index<nums.length; index++) {
    //         for(int targetNum=0; targetNum<=s; targetNum++) {
    //             int notPick = dp[index-1][targetNum];
    //             int pick = 0;
    //             if(targetNum >= nums[index]) pick = dp[ index-1 ][ targetNum-nums[index] ];

    //             dp[index][targetNum] = notPick + pick;
    //         }
    //     }

    //     return dp[nums.length-1][s];
    // }

    //-----------------------

    //Space-reduction (optimised with the one row technique learnt)
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for(int i: nums) totalSum += i;
        if(
                (totalSum+target) < 0 ||
                        (totalSum+target)%2 != 0
        ) return 0;

        int s = (totalSum+target)/2;

        int[] prev = new int[s+1];

        //base cases:
        //index=0 and target=0 case:
        prev[0] = nums[0]==0 ? 2 : 1;
        //index=0 and nums[0]!=0 case:
        if(nums[0]!=0 && nums[0]<=s) prev[ nums[0] ] = 1;

        for(int index=1; index<nums.length; index++) {
            for(int targetNum=s; targetNum>=0; targetNum--) {
                int notPick = prev[targetNum];
                int pick = 0;
                if(targetNum >= nums[index]) pick = prev[ targetNum-nums[index] ];

                prev[targetNum] = notPick + pick;
            }
        }

        return prev[s];
    }
}
