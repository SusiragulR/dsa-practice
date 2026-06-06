public class cf67 {
    static int[] rowWithMax1(int[][] mat){
        int r= mat.length, c=mat[0].length, presentCountOf1=0, maxCountOf1=0, maxCountRow=0;

        for(int i=0;i<r;i++){
            int low=0, high=c-1;
            while(low<=high){
                if(mat[i][low]==1) {
                    presentCountOf1 = c - low;
                    break;
                }

                int mid = low+(high-low)/2;

                if(mat[i][mid]==0) low=mid+1;
                else high=mid;
            }
            if(presentCountOf1>maxCountOf1) {
                maxCountOf1 = presentCountOf1;
                maxCountRow = i;
            }
        }

        //[maxCountRow,maxCountOf1]
        int[] ans = new int[]{maxCountRow,maxCountOf1};

        return ans;
    }

    public static void main(String[] args) {
        int[][] myMat = new int[][]{{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,1,1},{0,0,1,1,1,1}};

        int[] ans = rowWithMax1(myMat);
        System.out.println(ans[0]+"-->"+ans[1]);
    }
}
