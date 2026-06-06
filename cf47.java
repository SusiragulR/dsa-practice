import java.util.HashSet;
import java.util.Set;

public class cf47 {
    static void setZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int x:row){
            for (int j=0;j<c;j++){
                mat[x][j]=0;
            }
        }

        for(int y:col){
            for (int i=0;i<r;i++){
                mat[i][y]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{1,1,1,1},{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        setZeroes(sample);

        for(int i=0;i<sample.length;i++){
            for(int j=0;j<sample[0].length;j++){
                System.out.print(sample[i][j]+" ");
            }
            System.out.println();
        }
    }
}
