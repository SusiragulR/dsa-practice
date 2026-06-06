public class matrixSnakePattern {
    public static int[][] printSnakePatternOf(int r,int c,int[][] mat){
        int[][] ans = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i%2!=0) {
                    //[i][column interchanged from last to 0 "reversed"]
                    ans[i][j] = mat[i][c-1-j];
                }else{
                    ans[i][j] = mat[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x=1;
        int mr=5,mc=9;
        int[][] myMat = new int[mr][mc];

        for (int i=0;i<mr;i++){
            for(int j=0;j<mc;j++){
                myMat[i][j]=x;
                x++;
            }
        }

        int[][] myAnsMat = printSnakePatternOf(5,9,myMat);

        for (int i=0;i<mr;i++){
            for(int j=0;j<mc;j++){
                System.out.print(myAnsMat[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
