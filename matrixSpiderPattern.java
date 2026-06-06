public class matrixSpiderPattern {
    static int i=0,j=0;
    static void spiderPatternOf(int r,int c,int[][] arr){
        System.out.println(arr[0][0]);
        printSpider(i,j,r,arr);
    }

    static void printSpider(int i,int j,int n,int[][] arr){
        while(j<n-1){
            j++;
            System.out.println(i+"-"+j);
            System.out.println(arr[i][j]);
        }
        while(i<n-1){
            i++;
            System.out.println(i+"-"+j);
            System.out.println(arr[i][j]);
        }
        while (j>0){
            j--;
            System.out.println(i+"-"+j);
            System.out.println(arr[i][j]);
        }
        while (i>1){
            i--;
            System.out.println(i+"-"+j);
            System.out.println(arr[i][j]);
        }
        n--;
        if(n>=0){
            printSpider(i,j,n,arr);
        }
    }

    public static void main(String[] args) {
        int x=1;
        int mr=3,mc=3;
        int[][] myMat = new int[mr][mc];

        for (int i=0;i<mr;i++){
            for(int j=0;j<mc;j++){
                myMat[i][j]=x;
                x++;
            }
        }

        spiderPatternOf(3,3,myMat);
    }
}
