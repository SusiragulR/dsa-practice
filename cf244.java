public class cf244 {
    public void solveSudoku(int[][] mat) {
        solveSudokuUtil(mat);
    }

//    private static boolean solveSudokuUtil(int[][] mat) {
//        boolean isEmptyCellPresent = false;
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                //System.out.println("i: "+i+" j: "+j);
//                //if it's available & the digit u try is a valid call recursion
//                if(mat[i][j]==0){
//                    isEmptyCellPresent = true;
//                    boolean isAnyValidEntryPossible = false;
//                    for (int k = 1; k <= 9; k++) {
//                        if( isValidPlace(i, j, k, mat) ){
//                            isAnyValidEntryPossible = true;
//                            mat[i][j]=k;
//                            boolean lastResult = solveSudokuUtil(mat);
//                            if( !lastResult ) mat[i][j]=0;
//                            return lastResult;
//                        }
//                    }
//
//                    if(!isAnyValidEntryPossible) return false;
//                }
//            }
//        }
//
//        return !isEmptyCellPresent;
//    }

    private static boolean solveSudokuUtil(int[][] mat) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (mat[i][j] == 0) {

                    for (int k = 1; k <= 9; k++) {

                        if (isValidPlace(i, j, k, mat)) {
                            mat[i][j] = k;

                            if (solveSudokuUtil(mat)) return true;

                            mat[i][j] = 0; // backtrack
                        }
                    }

                    return false; // no valid number fits here
                }
            }
        }

        return true; // no empty cells → solved
    }


    private static boolean isValidPlace(int i, int j, int val, int[][] mat) {
        for(int x=0; x<9; x++) {
            if(mat[x][j] == val) return false;
            if(mat[i][x] == val) return false;
        }

        int iMin = (i / 3) * 3;
        int iMax = iMin + 2;

        int jMin = (j / 3) * 3;
        int jMax = jMin + 2;

        for(int x=iMin; x<=iMax; x++){
            for (int y=jMin; y<=jMax; y++){
                if(mat[x][y]==val) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{
                {3, 0, 6, 5, 7, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 8, 6, 3, 0, 0}
        };

        cf244 solution = new cf244();
        solution.solveSudoku(mat1);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
