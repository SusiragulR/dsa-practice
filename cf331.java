public class cf331 {
    public static int countClosedIslands(int[][] grid, int n, int m) {
        int[][] hasVisited = new int[n][m];
        int count=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1 && hasVisited[i][j]==0){
                    if ( checkWhetherClosedIsland( i, j, grid, hasVisited, n, m) ) count++;
                }
            }
        }

        return count;
    }

    static boolean checkWhetherClosedIsland (
            int i,
            int j,
            int[][] grid,
            int[][] hasVisited,
            int n,
            int m
    ) {
        //System.out.println("i: "+i+" j:"+j);
        if(grid[i][j]==0) return true; //in case of water ->true
        if( i==n-1 || i==0 || j==m-1 || j==0 ) return false; //land lying in matrix border -> false

        hasVisited[i][j] = 1;

        boolean up = hasVisited[i-1][j] == 1 || checkWhetherClosedIsland(i - 1, j, grid, hasVisited, n, m);
        boolean down = hasVisited[i+1][j] == 1 || checkWhetherClosedIsland( i+1, j, grid, hasVisited, n, m);
        boolean left = hasVisited[i][j-1] == 1 || checkWhetherClosedIsland( i, j-1, grid, hasVisited, n, m);
        boolean right = hasVisited[i][j+1] == 1 || checkWhetherClosedIsland( i, j+1, grid, hasVisited, n, m);

        return up && down && left && right;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}
        };

        int[][] grid2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] grid3 = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println( countClosedIslands( grid1, 5, 8 ) );
        System.out.println( countClosedIslands( grid2, 3, 3 ) );
        System.out.println( countClosedIslands( grid3, 5, 8 ) );
    }
}
