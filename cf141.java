import java.util.Stack;

public class cf141 {
    static int getCelebrity(int[][] mat){

        Stack<Integer> possible = new Stack<>();

        for (int i=0; i<mat.length; i++){
            boolean isPossible = true;

            for (int j=0; j<mat.length; j++){
                if (j!=i && mat[j][i] == 0) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                boolean isCeleb = true;
                for (int c=0; c<mat.length; c++){
                    if(mat[i][c]==1) isCeleb = false;
                }

                if(isCeleb) return i;
            }
        }

//        while (!possible.empty()){
//            boolean isCeleb = true;
//            int i = possible.pop();
//
//            for (int j=0; j<mat.length; j++){
//                if( mat[i][j] == 1 ) isCeleb = false;
//            }
//
//            if(isCeleb) return i;
//        }

        return -1;
    }//O(N^2 + N) SC:O(1)


    //OPTIMAL APPROACH
    static int giveCeleb(int[][] mat){
        int up=0, down=mat.length-1;

        while (up<down){
            if( mat[up][down]==0 && mat[down][up]==0 ) {
                up++;
                down--;
            }
            else if( mat[up][down]==1 && mat[down][up]==1 ) {
                up++;
                down--;
            }
            else if(mat[up][down]==1) up++;
            else down--;
        }

        if(down<up) return -1;

        else{
            for (int i=0; i<mat.length; i++){
                if(i==up) continue;
                if(mat[i][up]==0 || mat[up][i]==1) return -1; //check whether column is 0 or row is 1
            }
            return up;
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]
                {{0 ,0 ,1},
                {0 ,0 ,1},
                {0 ,0 ,0}};

        System.out.println(giveCeleb(mat));
    }
}
