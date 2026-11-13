package DynamicProgramming;

public class DP13CherryPickupII {
    //Recursion
    // public int cherryPickup(int[][] grid) {
    //     return cherryPickUtil(0, 0, grid[0].length-1, grid);
    // }

    // public int cherryPickUtil(int i, int j1, int j2, int[][] grid) {
    //     //out-of-bound
    //     if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) return Integer.MIN_VALUE;

    //     //destination
    //     if( i == grid.length-1 ) {
    //         if(j1==j2) return grid[i][j1];
    //         else return grid[i][j1] + grid[i][j2];
    //     }

    //     int maxi = Integer.MIN_VALUE;

    //     for(int del1=-1; del1<=1; del1++) {
    //         for(int del2=-1; del2<=1; del2++) {
    //             if(j1 == j2) maxi = Math.max(
    //                 maxi,
    //                 grid[i][j1] + cherryPickUtil(i+1, j1+del1, j2+del2, grid)
    //             );

    //             else maxi = Math.max(
    //                 maxi,
    //                 grid[i][j1] + grid[i][j2] + cherryPickUtil(i+1, j1+del1, j2+del2, grid)
    //             );
    //         }
    //     }

    //     return maxi;
    // }

    //-------------------------

    //Memoisation
    // public int cherryPickup(int[][] grid) {
    //     int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

    //     for(int[][] mat: dp) {
    //         for(int[] arr: mat) Arrays.fill(arr, -1);
    //     }

    //     return cherryPickUtil(0, 0, grid[0].length-1, grid, dp);
    // }

    // public int cherryPickUtil(int i, int j1, int j2, int[][] grid, int[][][] dp) {
    //     //out-of-bound
    //     if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) return Integer.MIN_VALUE;

    //     if( dp[i][j1][j2]!=-1 ) return dp[i][j1][j2];

    //     //destination
    //     if( i == grid.length-1 ) {
    //         if(j1==j2) dp[i][j1][j2] = grid[i][j1];
    //         else dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
    //         return dp[i][j1][j2];
    //     }

    //     int maxi = Integer.MIN_VALUE;

    //     for(int del1=-1; del1<=1; del1++) {
    //         for(int del2=-1; del2<=1; del2++) {
    //             if(j1 == j2) maxi = Math.max(
    //                 maxi,
    //                 grid[i][j1] + cherryPickUtil(i+1, j1+del1, j2+del2, grid, dp)
    //             );

    //             else maxi = Math.max(
    //                 maxi,
    //                 grid[i][j1] + grid[i][j2] + cherryPickUtil(i+1, j1+del1, j2+del2, grid, dp)
    //             );
    //         }
    //     }

    //     dp[i][j1][j2] = maxi;
    //     return  dp[i][j1][j2];
    // }

    //-------------------------

    //Tabulation
    // public int cherryPickup(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int[][][] dp = new int[m][n][n];

    //     for(int[][] mat: dp) {
    //         for(int[] arr: mat) Arrays.fill(arr, -1);
    //     }

    //     //base-case to result (bottom - up)
    //     //base case: row == n-1
    //     for(int j1=0; j1<n; j1++) {
    //         for(int j2=0; j2<n; j2++) {
    //             if(j1==j2) dp[j1][j2] = grid[m-1][j1];
    //             else dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
    //         }
    //     }

    //     for(int i=m-2; i>=0; i--) {
    //         for(int j1=0; j1<n; j1++) {
    //             for(int j2=0; j2<n; j2++) {
    //                 int maxi = Integer.MIN_VALUE;

    //                 for(int del1=-1; del1<=1; del1++) {
    //                     for(int del2=-1; del2<=1; del2++) {
    //                         int value = (j1 == j2) ? grid[i][j1] : grid[i][j1]+grid[i][j2];

    //                         if(j1+del1>=0 && j1+del1<n && j2+del2>=0 && j2+del2<n) value += dp[i+1][j1+del1][j2+del2];
    //                         else value += Integer.MIN_VALUE;

    //                         maxi = Math.max( maxi, value );
    //                     }
    //                 }

    //                 dp[i][j1][j2] = maxi;
    //             }
    //         }
    //     }

    //     return dp[0][0][n-1];
    // }

    //-------------------------

    //Space-reduction
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] frontRow = new int[n][n];

        //base-case to result (bottom - up)
        //base case: row == n-1
        for(int j1=0; j1<n; j1++) {
            for(int j2=0; j2<n; j2++) {
                if(j1==j2) frontRow[j1][j2] = grid[m-1][j1];
                else frontRow[j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }

        for(int i=m-2; i>=0; i--) {
            int[][] currRow = new int[n][n];

            for(int j1=0; j1<n; j1++) {
                for(int j2=0; j2<n; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    for(int del1=-1; del1<=1; del1++) {
                        for(int del2=-1; del2<=1; del2++) {
                            int value = (j1 == j2) ? grid[i][j1] : grid[i][j1]+grid[i][j2];

                            if(j1+del1>=0 && j1+del1<n && j2+del2>=0 && j2+del2<n) value += frontRow[j1+del1][j2+del2];
                            else value += Integer.MIN_VALUE;

                            maxi = Math.max( maxi, value );
                        }
                    }

                    currRow[j1][j2] = maxi;
                }
            }

            frontRow = currRow;
        }

        return frontRow[0][n-1];
    }
}
