package DynamicProgramming;

public class DP8UniquePaths {
    //Recursion
    // public int uniquePaths(int m, int n) {
    //     return recursiveUtilForUniquePaths( 0, 0, m, n );
    // }

    // public static int recursiveUtilForUniquePaths(int i, int j, int m, int n) {
    //     if(i==m-1 && j==n-1) return 1;

    //     if(i<0 || i>=m || j<0 || j>=n) return 0;

    //     int right = recursiveUtilForUniquePaths( i, j+1, m, n );
    //     int down = recursiveUtilForUniquePaths( i+1, j, m, n );

    //     return right + down;
    // }

    //--------------------

    //Memoisation
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];

    //     for(int i=0; i<m; i++) {
    //         Arrays.fill( dp[i], -1 );
    //     }

    //     return recursiveUtilForUniquePaths( 0, 0, m, n, dp );
    // }

    // public static int recursiveUtilForUniquePaths(int i, int j, int m, int n, int[][] dp) {
    //     if(i==m-1 && j==n-1) return 1;

    //     if(i<0 || i>=m || j<0 || j>=n) return 0;

    //     int right = (j+1<n && dp[i][j+1]!=-1) ? dp[i][j+1] : recursiveUtilForUniquePaths( i, j+1, m, n, dp );
    //     int down = (i+1<m && dp[i+1][j]!=-1) ? dp[i+1][j] : recursiveUtilForUniquePaths( i+1, j, m, n, dp );

    //     dp[i][j] = right + down;
    //     return dp[i][j];
    // }

    //----------------------

    //Tabulation
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];

    //     dp[m-1][n-1] = 1;

    //     for(int i=m-1; i>=0; i--) {
    //         for(int j=n-1; j>=0; j--) {
    //             if(i==m-1 && j==n-1) dp[m-1][n-1]=1;

    //             else {
    //                 int right = 0;
    //                 int down = 0;

    //                 if(j+1<n) right = dp[i][j+1];
    //                 if(i+1<m) down = dp[i+1][j];

    //                 dp[i][j] = down + right;
    //             }
    //         }
    //     }

    //     return dp[0][0];
    // }

    //-----------------

    //Space reduction
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for(int i=m-1; i>=0; i--) {
            int[] temp = new int[n];

            for(int j=n-1; j>=0; j--) {
                if(i==m-1 && j==n-1) {
                    temp[j] = 1;
                }

                else {
                    int right = 0;
                    int down = 0;

                    if(j+1 < n) right = temp[j+1];
                    if(j < n) down = prevRow[j];

                    temp[j] = down + right;
                }
            }

            prevRow = temp.clone();
        }

        return prevRow[0];
    }
}
