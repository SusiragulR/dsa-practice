package DynamicProgramming;

public class DP10MinPathSumInGridImportant {
    //Recursion - storing minSum in a external variable
    // public int minPathSum(int[][] grid) {
    //     int[] minSoFar = new int[]{Integer.MAX_VALUE};

    //     recursivePathSumUtil(grid.length-1, grid[0].length-1, 0, grid, minSoFar);

    //     return minSoFar[0];
    // }

    // public static void recursivePathSumUtil(int i, int j, int sum, int[][] grid, int[] minSoFar) {
    //     if(i==0 && j==0) {
    //         minSoFar[0] = Math.min( sum+grid[0][0], minSoFar[0] );
    //         return;
    //     }

    //     if(i<0 || j<0) return;

    //     sum += grid[i][j];

    //     recursivePathSumUtil(i-1, j, sum, grid, minSoFar); //up
    //     recursivePathSumUtil(i, j-1, sum, grid, minSoFar); //left
    // }

    //Recursion - just returning minimum path sum so far
    // public int minPathSum(int[][] grid) {
    //     return recursivePathSumUtil(grid.length-1, grid[0].length-1, grid);
    // }

    // public static int recursivePathSumUtil(int i, int j, int[][] grid) {
    //     if(i==0 && j==0) {
    //         return grid[0][0];
    //     }

    //     int up = 0;
    //     int left = 0;

    //     if(i-1>=0) up = recursivePathSumUtil(i-1, j, grid); //up
    //     if(j-1>=0) left = recursivePathSumUtil(i, j-1, grid); //left

    //     if(i-1>=0 && j-1>=0) return grid[i][j] + Math.min( up, left );
    //     else if(i-1>=0 && j-1<0) return grid[i][j] + up;
    //     else if(i-1<0 && j-1>=0) return grid[i][j] + left;
    //     else return grid[i][j];
    // }

    //--------------------

    //Memoization
    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][] dp = new int[m][n];

    //     for(int i=0; i<m; i++) {
    //         Arrays.fill(dp[i], -1);
    //     }

    //     return recursivePathSumUtil(grid.length-1, grid[0].length-1, grid, dp);
    // }

    // public static int recursivePathSumUtil(int i, int j, int[][] grid, int[][] dp) {
    //     if(i==0 && j==0) {
    //         return grid[0][0];
    //     }

    //     if( i>=0 && j>=0 && dp[i][j]!=-1 ) return dp[i][j];

    //     int up = 0;
    //     int left = 0;

    //     if(i-1>=0) up = recursivePathSumUtil(i-1, j, grid, dp); //up
    //     if(j-1>=0) left = recursivePathSumUtil(i, j-1, grid, dp); //left

    //     if(i-1>=0 && j-1>=0) dp[i][j] = grid[i][j] + Math.min( up, left );
    //     else if(i-1>=0 && j-1<0) dp[i][j] = grid[i][j] + up;
    //     else if(i-1<0 && j-1>=0) dp[i][j] = grid[i][j] + left;
    //     else dp[i][j] = grid[i][j];

    //     return dp[i][j];
    // }

    //---------------------

    //Tabulation
    // public int minPathSum(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int[][] dp = new int[m][n];

    //     for(int i=0; i<m; i++) {
    //         for(int j=0; j<n; j++) {
    //             int up = 0;
    //             int left = 0;

    //             if(i!=0) up = dp[i-1][j];
    //             if(j!=0) left = dp[i][j-1];

    //             if(i!=0 && j!=0) dp[i][j] = grid[i][j] + Math.min( up, left );
    //             else if(i-1>=0 && j-1<0) dp[i][j] = grid[i][j] + up;
    //             else if(i-1<0 && j-1>=0) dp[i][j] = grid[i][j] + left;
    //             else dp[i][j] = grid[i][j];
    //         }
    //     }

    //     return dp[m-1][n-1];
    // }

    //----------------------

    //Space-reduction
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prevRow = new int[n];

        for(int i=0; i<m; i++) {
            int[] temp = new int[n];

            for(int j=0; j<n; j++) {
                int up = 0;
                int left = 0;

                if(i!=0) up = prevRow[j];
                if(j!=0) left = temp[j-1];

                if(i!=0 && j!=0) temp[j] = grid[i][j] + Math.min( up, left );
                else if(i-1>=0 && j-1<0) temp[j] = grid[i][j] + up;
                else if(i-1<0 && j-1>=0) temp[j] = grid[i][j] + left;
                else temp[j] = grid[i][j];
            }

            prevRow = temp;
        }

        return prevRow[n-1];
    }
}
