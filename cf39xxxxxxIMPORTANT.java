public class cf39xxxxxxIMPORTANT {
    static int maxProduct(int[] nums) {
        int prefix=1, suffix=1, ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n-1-i];

            ans = Math.max( ans, prefix );
            ans = Math.max( ans, suffix );
        }

        return ans;
    }//this approach fails for the data
    //int[] nums = new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};

    //STRIVER'S
    public static int maxProductSubArray(int[] arr) {
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    //BEST ALTERNATE APPROACH FOR MAXIMUM PRODUCT OF SUBARRAY
    static long maxProductofSubarray(int[] nums) {
        if (nums.length == 0) return 0;

        long max = nums[0];
        long curMin = nums[0], curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                long temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);

            max = Math.max(max, curMax);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        System.out.println( maxProduct(nums) );
        System.out.println( maxProductSubArray(nums) );
        System.out.println( maxProductofSubarray(nums) );
    }
}
