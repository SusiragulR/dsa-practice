public class cf44 {
    static int minRow(int n, int m, int[][] a) {
        int minCountRow=1;
        int minCount=m;
        for(int i=0;i<n;i++){
            int countOf1=0;

            for(int j=0;j<m;j++){
                if(a[i][j]==1) countOf1++;
            }

            if(countOf1<minCount){
                minCount=countOf1;
                minCountRow=i;
            }
        }

        return minCountRow+1;
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{1,0,1,0},{1,1,1,0},{1,1,0,0},{1,1,1,1}};

        System.out.println(minRow(4,4,sample));
    }
}
