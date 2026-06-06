public class cf329 {
    public static int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] hasVisited = new int[n][m];
        int count=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]=='L' && hasVisited[i][j]==0){
                    count++;
                    markLandsAsVisited( i, j, grid, hasVisited, n, m);
                }
            }
        }

        return count;
    }

    static void markLandsAsVisited (
            int i,
            int j,
            char[][] grid,
            int[][] hasVisited,
            int n,
            int m
    ) {
        for(int x=-1; x<=1; x++) {
            if(i+x>=0 && i+x<n) {
                for(int y=-1; y<=1; y++) {
                    if(j+y>=0 && j+y<m && hasVisited[i+x][j+y]==0 && grid[i+x][j+y]=='L') {
                        hasVisited[i+x][j+y] = 1;
                        markLandsAsVisited( i+x, j+y, grid, hasVisited, n, m);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][]{
                {'W', 'L'},
                {'L', 'W'},
                {'L', 'L'},
                {'L', 'W'}
        };

        System.out.println( countIslands( grid1 ) );
    }
}
