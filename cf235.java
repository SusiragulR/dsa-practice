import java.util.ArrayList;

public class cf235 {
        public static ArrayList<String> ratInMaze(int[][] maze) {
            int n = maze[0].length;
            ArrayList<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            maze[0][0] = 0;
            ratInMazeUtil(0, 0, n, maze, ans, sb);

            return ans;
        }

        public static void ratInMazeUtil(
                int i,
                int j,
                int n,
                int[][] maze,
                ArrayList<String> ans,
                StringBuilder sb
        ) {
            System.out.println("Sb---> " + sb);
            for (int[] m: maze){
                System.out.println();
                for (int m2: m) System.out.print(m2+", ");
            }
            System.out.println();
            System.out.println("*".repeat(30));

            if (i == n - 1 && j == n - 1) {
                ans.add(sb.toString());
                return;
            }

            maze[i][j] = 0; // mark visited

            // up
            if (isValidMatIndexPair(i - 1, j, n) && maze[i - 1][j] == 1) {
                sb.append('U');
                ratInMazeUtil(i - 1, j, n, maze, ans, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            // down
            if (isValidMatIndexPair(i + 1, j, n) && maze[i + 1][j] == 1) {
                sb.append('D');
                ratInMazeUtil(i + 1, j, n, maze, ans, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            // left
            if (isValidMatIndexPair(i, j - 1, n) && maze[i][j - 1] == 1) {
                sb.append('L');
                ratInMazeUtil(i, j - 1, n, maze, ans, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            // right
            if (isValidMatIndexPair(i, j + 1, n) && maze[i][j + 1] == 1) {
                sb.append('R');
                ratInMazeUtil(i, j + 1, n, maze, ans, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

            maze[i][j] = 1;
        }

        public static boolean isValidMatIndexPair(int x, int y, int n) {
            return  x >= 0 &&
                    y >= 0 &&
                    x <= n - 1 &&
                    y <= n - 1;
        }

        public static void main(String[] args) {
            int[][] maze1 = new int[][]{
                    {1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}
            };

            int[][] maze2 = new int[][]{
                    {1, 1, 1, 1, 1},
                    {1, 1, 0, 1, 1},
                    {1, 1, 1, 0, 1},
                    {0, 1, 1, 1, 1},
                    {0, 0, 0, 1, 1}
            };

            System.out.println( ratInMaze(maze2) );
        }
}
