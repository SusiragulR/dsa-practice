package Greedy;

public class G13_jumpGame {
    public boolean canReach(int[] arr) {
        int n = arr.length;
        int reachedMax = 0;

        for(int i=0; i<n; i++) {
            if(i > reachedMax) return false;

            reachedMax = Math.max( reachedMax, i+arr[i] );

            if(reachedMax >= n-1) return true;
        }

        return true;
    }
}
