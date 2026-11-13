package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DP11Triangle {
    //Recursion
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     return minPathSumUtil( 0, 0, triangle );
    // }

    // public int minPathSumUtil(int i, int row, List<List<Integer>> triangle) {
    //     if(row == triangle.size()-1) return triangle.get(row).get(i);

    //     int below = minPathSumUtil( i, row+1, triangle );
    //     int diagonallyBelow = minPathSumUtil( i+1, row+1, triangle );

    //     return triangle.get(row).get(i) + Math.min( below, diagonallyBelow );
    // }

    //---------------

    //Memoisation
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     List<List<int[]>> dp = new ArrayList<>();

    //     for(int i=0; i<triangle.size(); i++) {
    //         dp.add( new ArrayList<>() );
    //         for(int j=0; j<i+1; j++) {
    //             dp.get(i).add(new int[2]);
    //         }
    //     }

    //     return minPathSumUtil( 0, 0, triangle, dp );
    // }

    // public int minPathSumUtil(int i, int row, List<List<Integer>> triangle, List<List<int[]>> dp) {
    //     if(row == triangle.size()-1) {
    //         dp.get(row).get(i)[0] = triangle.get(row).get(i);
    //         dp.get(row).get(i)[1] = 1;
    //         return dp.get(row).get(i)[0];
    //     }

    //     if(dp.get(row).get(i)[1] == 1) return dp.get(row).get(i)[0];

    //     int below = minPathSumUtil( i, row+1, triangle, dp );
    //     int diagonallyBelow = minPathSumUtil( i+1, row+1, triangle, dp );

    //     dp.get(row).get(i)[0] = triangle.get(row).get(i) + Math.min( below, diagonallyBelow );
    //     dp.get(row).get(i)[1] = 1;

    //     return dp.get(row).get(i)[0];
    // }

    //------------------

    //Tabulation
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     List<List<Integer>> dp = new ArrayList<>();

    //     for(int i=0; i<n; i++) {
    //         dp.add( new ArrayList<>() );
    //     }

    //     for(int row=n-1; row>=0; row--) {
    //         for(int i=0; i<row+1; i++) {
    //             if(row == n-1) dp.get(row).add( triangle.get(row).get(i) );

    //             else {
    //                 dp.get(row).add(
    //                     triangle.get(row).get(i) +
    //                     Math.min( dp.get(row+1).get(i) , dp.get(row+1).get(i+1) )
    //                 );
    //             }
    //         }

    //     }

    //     return dp.get(0).get(0);
    // }

    //-----------------

    //Space-reduction
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> prevRow = new ArrayList<>();

        for(int row=n-1; row>=0; row--) {
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<row+1; i++) {
                if(row == n-1) temp.add( triangle.get(row).get(i) );

                else {
                    temp.add(
                            triangle.get(row).get(i) +
                                    Math.min( prevRow.get(i) , prevRow.get(i+1) )
                    );
                }
            }

            prevRow = temp;
        }

        return prevRow.get(0);
    }
}
