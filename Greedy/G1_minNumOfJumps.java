package Greedy;

public class G1_minNumOfJumps {
    public int minJumps(int[] arr) {
        int n = arr.length;

        int jumps = 0;
        int l=0, r=0;

        int farthest = 0;

        while(l<=r && r<n-1) {
            for(int i=l; i<=r; i++) {
                farthest = Math.max( i+arr[i], farthest );
            }

            l = r+1;
            r = farthest;

            jumps++;
        }

        return l>r ? -1 : jumps;
    }
}
