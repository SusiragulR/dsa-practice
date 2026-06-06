public class cf78 {
    static long lessThanEqualTo(int target, int m, int n){
        long sum=0;
        for (int i=1;i<=m;i++){
            sum+=Math.min(target/i,n);
        }

        return sum;
    }

    //6ms SOLUTION*******
    //*******************
    public int findKthNumber(int m, int n, int k) {
        if (m > n) { // let always m<=n so we have less iterations of binary search
            int t = n;
            n = m;
            m = t;
        }
        int left = Math.min(1, (k - 1) / n);
        int right = m * n;
        while (left < right) {
            int mid = (right + left) / 2;
            if (getMaxPosition(m, n, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * Counts the number of cells int table which are less then
     * or equal to 'value'
     */
    private int getMaxPosition(int m, int n, int value) {
        int start = value / n;
        int count = start * n; // we know for sure that every cell in 'upper' square start * n is less then value
        for (int i = start + 1; i <= m; i++) {
            count += value / i; // value/i - the number of cell that is less or equal then value
        }
        return count;
    }
    static int nthSmallestOf(int m, int n, int k){
        int low=1, high=m*n;

        while(low<=high) {
            int mid = low + (high - low) / 2;

            if (lessThanEqualTo(mid, m, n) < k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(nthSmallestOf(2,3,6));
    }
}
