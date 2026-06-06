import java.util.ArrayList;
import java.util.HashSet;

public class cf330 {
    public static int countDistinctIslands(int[][] grid) {
        int n = grid. length;
        int m = grid[0].length;
        int[][] hasVisited = new int[n][m];
        HashSet<ArrayList<String>> ansSet = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1 && hasVisited[i][j]==0){
                    ArrayList<String> list = new ArrayList<>();
                    markLandsInSet( i, j, i, j, grid, hasVisited, n, m, list);
                    ansSet.add(list);
                }
            }
        }

        return ansSet.size();
    }

    static void markLandsInSet (
            int i,
            int j,
            int basei,
            int basej,
            int[][] grid,
            int[][] hasVisited,
            int n,
            int m,
            ArrayList<String> list
    ) {
        //System.out.println("i:"+i+", j:"+j+", bi:"+basei+", bj:"+basej);
        if(grid[i][j]==0) return; //in case of water
        if( i<0 || i>=n || j<0 || j>=m ) return; //out of index

        hasVisited[i][j] = 1;
        list.add(i - basei + "," + (j - basej));

        if(isValidIndex(i-1, j, n, m) && grid[i-1][j]==1 && hasVisited[i-1][j]==0) markLandsInSet(i - 1, j, basei, basej, grid, hasVisited, n, m, list);
        if(isValidIndex(i, j+1, n, m) && grid[i][j+1]==1 && hasVisited[i][j+1]==0) markLandsInSet( i, j+1, basei, basej, grid, hasVisited, n, m, list);
        if(isValidIndex(i+1, j, n, m) && grid[i+1][j]==1 && hasVisited[i+1][j]==0) markLandsInSet( i+1, j, basei, basej, grid, hasVisited, n, m, list);
        if(isValidIndex(i, j-1, n, m) && grid[i][j-1]==1 && hasVisited[i][j-1]==0) markLandsInSet( i, j-1, basei, basej, grid, hasVisited, n, m, list);
    }

    static boolean isValidIndex (int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {0, 1},
                {1, 0},
                {1, 1},
                {1, 0}
        };

        int[][] grid2 = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        int[][] grid3 = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        System.out.println( countDistinctIslands( grid3 ) );
    }
}
