package DynamicProgramming;

public class DP1ClimbingStairs {

//  Recursion
//    public int countWays(int n) {
//        if(n == 0) return 1;
//        if(n == 1) return 1;
//
//        int singleJump = countWays(n - 1);
//        int doubleJump = countWays(n - 2);
//
//        return singleJump + doubleJump;
//    }

//  Memoisation
//    public int countWays(int n) {
//        int[] dp = new int[n+1];
//
//        countWaysRecursiveUtil(n, dp);
//    }
//
//    public int countWaysRecursiveUtil(int n, int[] dp) {
//        if(n == 0) return 1;
//        if(n == 1) return 1;
//
//        int singleJump = dp[n-1]!=0 ? dp[n-1] : countWays(n - 1);
//        int doubleJump = dp[n-2]!=0 ? dp[n-2] : countWays(n - 2);
//
//        dp[n] = singleJump + doubleJump;
//        return dp[n];
//    }

//  Tabulation
//    public int countWays(int n) {
//        int[] dp = new int[n+1];
//
//        for (int i = 2; i<=n; i++) {
//            dp[n] = dp[n-1] + dp[n-2];
//        }
//
//        return dp[n];
//    }

    // Space reduction
    public int countWays(int n) {
        int prev = 1;
        int secondPrev = 1;

        for (int i = 2; i<=n; i++) {
            int temp = prev + secondPrev;
            prev = secondPrev;
            secondPrev = temp;
        }

        return secondPrev;
    }

    public static void main(String[] args) {
        DP1ClimbingStairs soln = new DP1ClimbingStairs();
        System.out.println( soln.countWays(5) );
    }
}
