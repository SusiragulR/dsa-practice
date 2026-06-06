public class cf68 {
    //ROW-WISE AND COLUMN-WISE SORTED
    static boolean search(int mat[][], int n, int m, int x)
    {
        for(int i=0;i<n;i++){
            int low=0, high=m-1;
            while(low<=high){
                int mid=low+(high-low)/2;

                if(mat[i][mid]==x) return true;

                if(mat[i][mid]<x) low=mid+1;
                else high=mid-1;
            }
        }

        return false;
    }//TC:O(N logN) SC:O(1)

//  *** OPTIMAL APPROACH (to be checked) *** for ROW-WISE AND COLUMN-WISE SORTED
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int p1 = 0;
        int p2 = n - 1;
        // set start point
        while(p1 < m && p2 >= 0){
            int curr = matrix[p1][p2];
            if(curr < target){
                p1++;
            }else if ( curr > target){
                p2--;
            }else{
                return true;
            }
        }
        return false;
    }

//    *** OPTIMAL APPROACH ***
//    (IF ENTIRE MATRIX IS SORTED) -> (row's 1st element > previous row's last element)
//    shall be virtually converted as a 1D array
//    nxm matrix as ( 0 -> (nxm)-1 ) array
//    where rows and columns are,
//    r=n/m
//    c=n%m
    static boolean searchRowColumnSorted(int[][] mat,int n,int m,int x){
        int low=0, high=n*m-1;
        while(low<=high){
            int mid = low+(high-low)/2;

            int r=mid/m, c=mid%m;

            if(mat[r][c] == x) return true;
            else if(mat[r][c] > x)  high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] myMat = new int[][]{ {3, 30, 38},{39, 43, 60},{61, 65, 69} };

        System.out.println(searchRowColumnSorted(myMat,3,3,60));
    }
}
