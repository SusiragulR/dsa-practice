package heaps;

import java.util.PriorityQueue;

public class h15_kthSmallestInSortedMatrix {
//    public int kthSmallest(int[][] mat, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0]-b[0] );
//
//        //first push min(n1, k) elements from row 0 into pq
//        //pq will hold arrays as [ele, i, j]
//        int n = mat.length;
//        for( int j=0; j<Math.min(n, k); j++ ) {
//            pq.add( new int[]{ mat[0][j], 0, j } );
//        }
//
//        //for each popped ele,
//        //if it's i=0 and j<k-1, add the ele below it alone into pq (as others are already added into pq)
//        //else add elements right to it and below to it
//        int ans = -1;
//        while(k-- > 0 && !pq.isEmpty() ) {
//            int[] popped = pq.poll();
//            ans = popped[0];
//            int i = popped[1];
//            int j = popped[2];
//
//            //adding below element if row exists
//            if(i+1 < n) {
//                pq.add( new int[]{ mat[i+1][j], i+1, j} );
//            }
//
//            //conditionally adding right element
//            if( !(i==0 && j<k-1) && j+1 < n ) {
//                pq.add( new int[]{ mat[i][j+1], i, j+1} );
//            }
//        }
//
//        return ans;
//    }

// The above solution didn't wor because of these reasons:
// it added duplicate insertions as a same element can be the right neighbour of one element and below neighbour of another element
// This leads to push duplicates
// Another issue: I accessed k inside a while loop which decrements it
// This causes the intention to fail too

    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0] );

        //first push all elements from col 0 into pq
        //pq will hold arrays as [ele, i, j]
        int n = mat.length;
        for( int i=0; i<n; i++ ) {
            pq.add( new int[]{ mat[i][0], i, 0 } );
        }

        //for each popped ele,
        //add element right to it if exists
        int ans = -1;
        while(k-- > 0 && !pq.isEmpty() ) {
            int[] popped = pq.poll();
            ans = popped[0];
            int i = popped[1];
            int j = popped[2];

            if(j+1 < n) {
                pq.add( new int[]{ mat[i][j+1], i, j+1 } );
            }
        }

        return ans;
    }
}
