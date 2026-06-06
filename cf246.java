public class cf246 {
    public static boolean isWordExist(char[][] mat, String word) {
        int r = mat.length;
        int c = mat[0].length;

        int[][] isUsed = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if (mat[i][j] == word.charAt(0)) return hasWordInThisIndex(i, j, mat, isUsed, 0, word);
            }
        }

        return false;
    }

    private static boolean hasWordInThisIndex (
            int i,
            int j,
            char[][] mat,
            int[][] isUsed,
            int wordIndex,
            String word
    ) {
        if( mat[i][j] != word.charAt(wordIndex) ) return false;
        if( isUsed[i][j] == 1 ) return false;

        // If last character matched → success
        if (wordIndex == word.length() - 1) {
            return true;
        }

        isUsed[i][j] = 1;

        boolean up = (i-1 >= 0) ? hasWordInThisIndex(i-1, j, mat, isUsed, wordIndex+1, word) : false;
        boolean down = (i+1 < mat.length) ? hasWordInThisIndex(i+1, j, mat, isUsed, wordIndex+1, word) : false;
        boolean left = (j-1 >= 0) ? hasWordInThisIndex(i, j-1, mat, isUsed, wordIndex+1, word) : false;
        boolean right = (j+1 < mat[0].length) ? hasWordInThisIndex(i, j+1, mat, isUsed, wordIndex+1, word) : false;

        isUsed[i][j] = 0;

        //boolean atLeastOneValidPositionIsPresent = (i-1 >= 0) || (i+1 < mat.length) || (j-1 >= 0) || (j+1 < mat[0].length);
        //return !atLeastOneValidPositionIsPresent || (up || down || left || right);
        return (up || down || left || right);
    }

    public static void main(String[] args) {
        char[][] mat1 = new char[][]{{'A'}};

        System.out.println( isWordExist(mat1, "AB") );
    }
}
