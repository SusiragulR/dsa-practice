package DynamicProgramming;

public class DP12MinFallingPathSum {
    //Recursion
    // public int minFallingPathSum(int[][] mat) {
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int minFallingPathSum = Integer.MAX_VALUE;

    //     for(int col=0; col<n; col++) {
    //         minFallingPathSum = Math.min( minFallingPathSum, recursiveMinPathSumUtil(n-1, col, mat) );
    //     }

    //     return minFallingPathSum;
    // }

    // public int recursiveMinPathSumUtil(int row, int col, int[][] mat) {
    //     if(col<0 || col>=mat[0].length) return Integer.MAX_VALUE; //returning max for out of bound case as the aim is to get min falling path sum
    //     if(row == 0) return mat[row][col];

    //     int up = recursiveMinPathSumUtil(row-1, col, mat);
    //     int diagonallyLeft = recursiveMinPathSumUtil(row-1, col-1, mat);
    //     int diagonallyRight = recursiveMinPathSumUtil(row-1, col+1, mat);

    //     return mat[row][col] + Math.min( up, Math.min(diagonallyLeft, diagonallyRight) );
    // }

    //---------------------

    //Memoisation
    // public int minFallingPathSum(int[][] mat) {
    //     int n = mat.length;
    //     int minFallingPathSum = Integer.MAX_VALUE;

    //     int[][] dp = new int[n][n];

    //     for(int[] row: dp) Arrays.fill( row, Integer.MIN_VALUE);

    //     for(int col=0; col<n; col++) {
    //         minFallingPathSum = Math.min( minFallingPathSum, recursiveMinPathSumUtil(n-1, col, mat, dp) );
    //     }

    //     return minFallingPathSum;
    // }

    // public int recursiveMinPathSumUtil(int row, int col, int[][] mat, int[][] dp) {
    //     if(col<0 || col>=mat[0].length) return Integer.MAX_VALUE; //returning max for out of bound case as the aim is to get min falling path sum
    //     if(row == 0) return mat[row][col];

    //     if(dp[row][col]!=Integer.MIN_VALUE) return dp[row][col];

    //     int up = recursiveMinPathSumUtil(row-1, col, mat, dp);
    //     int diagonallyLeft = recursiveMinPathSumUtil(row-1, col-1, mat, dp);
    //     int diagonallyRight = recursiveMinPathSumUtil(row-1, col+1, mat, dp);

    //     dp[row][col] = mat[row][col] + Math.min( up, Math.min(diagonallyLeft, diagonallyRight) );

    //     return dp[row][col];
    // }

    //----------------------

    //Tabulation
    // public int minFallingPathSum(int[][] mat) {
    //     int n = mat.length;
    //     int minFallingPathSum = Integer.MAX_VALUE;

    //     int[][] dp = new int[n][n];

    //     dp[0] = mat[0];

    //     for(int row=1; row<n; row++) {
    //         for(int col=0; col<n; col++) {
    //             int up = prevRow[col];
    //             int diagonallyLeft = (col-1 >= 0) ? dp[row-1][col-1] : Integer.MAX_VALUE;
    //             int diagonallyRight = (col+1 < n) ? dp[row-1][col+1] : Integer.MAX_VALUE;

    //             dp[row][col] = mat[row][col] + Math.min( up, Math.min(diagonallyLeft, diagonallyRight) );

    //             if(row==n-1) minFallingPathSum = Math.min( minFallingPathSum, dp[row][col] );
    //         }
    //     }

    //     if(n==1) {
    //         for(int col=0; col<n; col++) {
    //             minFallingPathSum = Math.min( minFallingPathSum, dp[0][col] );
    //         }
    //     }

    //     return minFallingPathSum;
    // }

    //----------------------
    //Space-reduction
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int minFallingPathSum = Integer.MAX_VALUE;

        int[] prevRow = new int[n];

        prevRow = mat[0];

        for(int row=1; row<n; row++) {
            int[] curr = new int[n];

            for(int col=0; col<n; col++) {
                int up = prevRow[col];
                int diagonallyLeft = (col-1 >= 0) ? prevRow[col-1] : Integer.MAX_VALUE;
                int diagonallyRight = (col+1 < n) ? prevRow[col+1] : Integer.MAX_VALUE;

                curr[col] = mat[row][col] + Math.min( up, Math.min(diagonallyLeft, diagonallyRight) );

                if(row==n-1) minFallingPathSum = Math.min( minFallingPathSum, curr[col] );
            }

            prevRow = curr;
        }

        if(n==1) {
            for(int col=0; col<n; col++) {
                minFallingPathSum = Math.min( minFallingPathSum, mat[0][col] );
            }
        }

        return minFallingPathSum;
    }
}
