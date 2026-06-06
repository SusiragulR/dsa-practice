public class kadanesAlgo {
    static long maxSum(int[] arr){
        long sum = 0, ans = Long.MIN_VALUE;

        for (int i=0; i<arr.length; i++){
            sum+=arr[i];

            ans = Math.max( sum, ans );

            if(sum < 0) sum = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{-2,-3,4,-1,-2,1,5,-3};
        int[] sample2 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] sample3 = new int[]{5,4,-1,7,8};

        System.out.println(maxSum(sample3));
    }
}
