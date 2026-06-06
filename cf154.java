public class cf154 {
    public static int maxSubarraySum(int[] arr, int k) {
        long maxSum = 0, sum = 0;
        int l = arr.length;
        for(int i=0; i<k; i++) sum += arr[i];

        if(sum > maxSum) maxSum = sum;

        for(int i=k; i<l; i++) {
            int removingIndex = i-k;
            sum -= arr[removingIndex];
            sum += arr[i];

            if(sum > maxSum) maxSum = sum;
        }

        return (int)maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}; // k=4 ans=39

        System.out.println(maxSubarraySum(arr1, 4));
    }
}
