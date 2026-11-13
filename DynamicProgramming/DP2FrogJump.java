package DynamicProgramming;

public class DP2FrogJump {
// Recursion
// 	int minCost(int[] height) {
// 	    return getMinCost(height.length-1, height);
// 	}

// 	int getMinCost(int indx, int[] height) {
// 		if (indx == 0)
// 			return 0;

// 		// jump single step
// 		int jumpSingleStep = getMinCost(indx-1, height) + Math.abs(height[indx] - height[indx-1]);

// 		//jump double step
// 		int jumpDoubleSteps = indx<=1 ? Integer.MAX_VALUE :
// 		                getMinCost(indx-2, height) + Math.abs(height[indx] - height[indx-2]);

// 		return Math.min(jumpSingleStep, jumpDoubleSteps);
// 	}

// -------------------------------------

// Memoisation
// 	int minCost(int[] height) {
// 	    int[] dp = new int[height.length];
// 	    Arrays.fill(dp, -1);

// 	    return getMinCost(height.length-1, height, dp);
// 	}

// 	int getMinCost(int indx, int[] height, int[] dp) {
// 		if (indx == 0)
// 			return 0;

// 		if(dp[indx]!=-1) return dp[indx];

// 		// jump single step
// 		int jumpSingleStep =
// 		    getMinCost(indx-1, height, dp) + Math.abs(height[indx]-height[indx-1]);

// 		//jump double step
// 		int jumpDoubleSteps =
// 		    indx<=1 ? Integer.MAX_VALUE :
// 		            ( getMinCost(indx-2, height, dp) + Math.abs(height[indx]-height[indx-2]) );

// 		dp[indx] = Math.min(jumpSingleStep, jumpDoubleSteps);

// 		return dp[indx];
// 	}

// ---------------------------------------

// Tabulation
// 	int minCost(int[] height) {
// 	    int l = height.length;

// 	    int[] dp = new int[l];
// 	    Arrays.fill(dp, -1);

// 	    dp[0] = 0;

// 	    for( int indx=1; indx<l; indx++) {
// 	        // jump single step
//     		int jumpSingleStep =
//     		    dp[indx-1] + Math.abs(height[indx]-height[indx-1]);

//     		//jump double step
//     		int jumpDoubleSteps =
//     		    indx<=1 ? Integer.MAX_VALUE :
//     		        dp[indx-2] + Math.abs(height[indx]-height[indx-2]);

//     		dp[indx] = Math.min(jumpSingleStep, jumpDoubleSteps);
// 	    }

// 	    return dp[l-1];
// 	}

// ---------------------------------------

// Space reduction
    int minCost(int[] height) {
        int l = height.length;

        int prev = 0;
        int second = Integer.MAX_VALUE;

        for( int indx=1; indx<l; indx++) {
            // jump single step
            int jumpSingleStep =
                    prev + Math.abs(height[indx]-height[indx-1]);

            //jump double step
            int jumpDoubleSteps =
                    indx<=1 ? Integer.MAX_VALUE :
                            second + Math.abs(height[indx]-height[indx-2]);

            second = prev;
            prev = Math.min(jumpSingleStep, jumpDoubleSteps);
        }

        return prev;
    }
}
