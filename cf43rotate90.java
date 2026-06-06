import java.util.Objects;

public class cf43rotate90 {
    static int[][] rotate90(int[][] mat,int n){
        int[][] copy = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j]=mat[j][n-1-i];
            }
        }

        mat=copy;

        return mat;
    }
    //this is ok if it returns mat

    //to change in place,
    //we shall transpose it
    //and then reverse each row

    //TRANSPOSE AND INTERCHANGE METHOD
    static void transposeInterchange(int[][] mat,int n){
        //transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        //interchange rows
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = temp;
            }
        }
    }

    static void rotate90ByCircularAssignment(int[][] mat, int n, String mode){
        int threshold = (int)Math.ceil((((double)n / 2) - 1));
        //System.out.println("threshold ==> "+threshold);
        for(int i=0; i<n; i++){
            for(int j=n-1-i; j>=i; j--){
                if(i==j){
                    if(i==threshold) {
                        System.out.println("Reached ["+i+"]["+j+"]");
                        return;
                    }
                    else continue;
                }

                System.out.println("processing:["+i+"]["+j+"]");

                //circular assignment
                if(Objects.equals(mode, "clock-wise")){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][n-1-i];
                    mat[j][n-1-i] = mat[n-1-i][n-1-j];
                    mat[n-1-i][n-1-j] = mat[n-1-j][i];
                    mat[n-1-j][i] = temp;
                }

                if(Objects.equals(mode, "anti-clock-wise")){
                    int temp = mat[i][j];
                    mat[i][j] = mat[n-1-j][i];
                    mat[n-1-j][i] = mat[n-1-i][n-1-j];
                    mat[n-1-i][n-1-j] = mat[j][n-1-i];
                    mat[j][n-1-i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
        int[][] sample1 = new int[][]{{0,1},{2,3}};
        int[][] sample2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] sample3 = new int[][]{{1}};

//        int[][] rotated = rotate90(sample,3);
//
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(rotated[i][j]+" ");
//            }
//            System.out.println();
//        }

//        transposeInterchange(sample,3);
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(sample[i][j]+" ");
//            }
//            System.out.println();
//        }

//        rotate90ByCircularAssignment(sample,3, "clock-wise");
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(sample[i][j]+" ");
//            }
//            System.out.println();
//        }

//        System.out.println();
//        System.out.println();
//
//        rotate90ByCircularAssignment(sample2,4, "clock-wise");
//        for(int i=0;i<4;i++){
//            for(int j=0;j<4;j++){
//                System.out.print(sample2[i][j]+" ");
//            }
//            System.out.println();
//        }

//        System.out.println();
//        System.out.println();
//
//        rotate90ByCircularAssignment(sample1,2, "clock-wise");
//        for(int i=0;i<2;i++){
//            for(int j=0;j<2;j++){
//                System.out.print(sample1[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println();
        System.out.println();

        rotate90ByCircularAssignment(sample3,1, "clock-wise");
        for(int i=0;i<1;i++){
            for(int j=0;j<1;j++){
                System.out.print(sample1[i][j]+" ");
            }
            System.out.println();
        }
    }
}
