public class cf45 {
    static void rotateByK(int[][] mat,int k){
        int m = mat.length;
        int n = mat[0].length;

        k=k%n;



        for(int i=0;i<m;i++){
            for(int j=0;j<n-1;j++){
                mat[i][j]=mat[i][j+1];
            }
        }
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        rotateByK(sample,1);

        for (int i=0;i< sample.length;i++){
            for(int j=0;j<sample[0].length;j++){
                System.out.print(sample[i][j]+" ");
            }
            System.out.println();
        }
    }
}
