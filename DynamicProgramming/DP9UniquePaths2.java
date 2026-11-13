package DynamicProgramming;

public class DP9UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prevRow = new int[n];

        for(int i=m-1; i>=0; i--) {
            int[] temp = new int[n];

            for(int j=n-1; j>=0; j--) {
                if(obstacleGrid[i][j]==1) temp[j]=0;

                else if(i==m-1 && j==n-1) {
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
