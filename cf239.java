import java.util.ArrayList;

public class cf239 {
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[][] mat = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> present = new ArrayList<>();

        nQueenUtil(mat, n, 0, present, ans);

        return ans;
    }

    public static void nQueenUtil(
            int[][] mat,
            int n,
            int row,
            ArrayList<Integer> present,
            ArrayList<ArrayList<Integer>> ans
    ) {
        for (int j = 0; j < n; j++) {
            //System.out.println("i->"+row+" j->"+j);
            //System.out.println("isAnyQueenPresentDiagonally -> "+isAnyQueenPresentDiagonally(row, j, mat));
            if (mat[row][j]!=1 && !isAnyQueenInColumn(row, j, mat) && !isAnyQueenPresentDiagonally(row, j, mat)) {
                //System.out.println("case passed: i->"+row+" j->"+j);
                mat[row][j] = 1;
                present.add(j+1);
                if(row+1 < n) nQueenUtil(mat, n, row+1, present, ans);
                if(present.size() == n) ans.add(new ArrayList<>(present));
                present.removeLast();
                mat[row][j] = 0;
            }
        }

    }

    public static boolean isAnyQueenPresentDiagonally(int row, int col, int[][] mat) {
        int n = mat.length;

        // upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) return true;
        }

        // upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (mat[i][j] == 1) return true;
        }

        return false;
    }

    public static boolean isAnyQueenInColumn(int row, int col, int[][] mat) {
        for (int i = 0; i < row; i++) {
            if (mat[i][col] == 1) return true;
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println(nQueen(4));
    }
}
