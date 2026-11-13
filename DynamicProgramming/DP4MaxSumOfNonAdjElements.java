package DynamicProgramming;

// MAX SUM OF NON-ADJACENT ELEMENTS
// HOUSE ROBBER PBLM

import java.util.Arrays;

public class DP4MaxSumOfNonAdjElements {
    //Recursion
//    public static int rob(int[] nums) {
//        return robUtil(nums.length-1,  nums);
//    }
//
//    private static int robUtil(int i, int[] nums) {
//        if(i==0) return nums[0];
//        if(i<0) return 0;
//
//        int picked = nums[i];
//        if(i>1) picked += robUtil(i-2, nums); //condn to avoid reaching -ve indices
//
//        int not_picked = robUtil(i-1, nums); //if not picked it's prev element can be picked
//
//        return Math.max(picked, not_picked);
//    }

    //---------------------------

    //Memoisation
//    public static int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//
//        return robUtil(nums.length-1,  nums, dp);
//    }
//
//    private static int robUtil(int i, int[] nums, int[] dp) {
//        if(i==0) return nums[0];
//        if(i<0) return 0;
//
//        int picked = nums[i];
//        if(i>1) picked += dp[i-2]!=-1 ? dp[i-2] : robUtil(i-2, nums, dp); //condn to avoid reaching -ve indices
//
//        int not_picked = dp[i-1]!=-1 ? dp[i-1] : robUtil(i-1, nums, dp); //if not picked it's prev element can be picked
//
//        return Math.max(picked, not_picked);
//    }

    //-------------------------

    //Tabulation
//    public static int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//
//        dp[0] = nums[0];
//
//        for (int i = 1; i<nums.length; i++) {
//            int picked = nums[i];
//            if(i>1) picked += dp[i-2]; //condn to avoid reaching -ve indices
//
//            int not_picked = dp[i-1]; //if not picked it's prev element can be picked
//
//            dp[i] = Math.max(picked, not_picked);
//        }
//
//        return dp[nums.length-1];
//    }

    //--------------------------

    //Space-reduction
    public static int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i<nums.length; i++) {
            int picked = nums[i] + prev2; //if picked, second prev has to be picked. prev will be adjacent
            int not_picked = prev; //if not picked it's prev element can be picked

            int curr = Math.max(picked, not_picked);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println( rob(nums) );
    }
}
