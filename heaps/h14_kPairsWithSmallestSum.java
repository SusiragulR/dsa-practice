package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class h14_kPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> a[0] - b[0] );

        int l1 = nums1.length;
        int l2 = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        //push min(l1,k) elements from nums1 paired with first ele of nums2 to pq
        //the pq will have an array of length 3 (sum, nums1-index, nums2-index)
        int minL = Math.min(l1, k);
        for(int i=0; i<minL; i++) {
            pq.add( new int[]{nums1[i]+nums2[0], i, 0} );
        }

        //we need k pairs. so, removes k elements from pq. Add the pair to pq and
        //insert if next pair with a nums2 index exists for the popped nums1 index
        while( k-- > 0 && !pq.isEmpty() ) {
            int[] popped = pq.poll();
            int i = popped[1];
            int j = popped[2];

            ans.add( Arrays.asList( nums1[i], nums2[j] ) );

            if(j+1 < l2) {
                pq.add( new int[]{
                        nums1[i] + nums2[j+1],
                        i,
                        j+1
                });
            }
        }

        return ans;
    }
}
