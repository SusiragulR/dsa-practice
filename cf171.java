public class cf171 {
//    IMPROPER SOLUTION : Your code produces wrong transitions because:
//When oddCount == k, you immediately increment ansCount.
//Then you shift l through all even numbers.
//But by shifting l inside the same outer iteration, the window no longer represents a continuous segment when the loop continues.
//This breaks the sliding window invariant and skips valid combinations.
//This happens frequently when even numbers appear after the k-th odd.
//
//
//    static int numberOfNiceSubArrays(int[] nums, int k) {
//        int n = nums.length;
//
//        int l=0, oddCount=0, ansCount=0;
//
//        for(int r=0; r<n; r++){
//            if(nums[r]%2 != 0) oddCount++;
//
//            if(oddCount > k) {
//                while(oddCount > k){
//                    if(nums[l]%2 != 0) oddCount--;
//                    l++;
//                }
//            }
//
//            if(oddCount == k) {
//                ansCount++;
//                while(nums[l]%2==0) {
//                    ansCount++;
//                    l++;
//                }
//            }
//            System.out.println("r: "+r+" ansCount: "+ansCount);
//        }
//
//        return ansCount;
//    }

    private static int atMost(int[] nums, int k) {
        int l = 0, count = 0, odd = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r]%2 != 0) odd++;

            while (odd > k) {
                if (nums[l]%2 != 0) odd--;
                l++;
            }

            // all windows that end at r and have ≤ k odds
            count += r - l + 1;
        }

        return count;
    }

    static int numberOfNiceSubArrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,1,1};
        int k1 = 3;

        int[] nums2 = new int[]{2,4,6};
        int k2 = 1;

        int[] nums3 = new int[]{2,2,2,1,2,2,1,2,2,2};
        int k3 = 2;

        System.out.println( numberOfNiceSubArrays(nums1, k1) );
        System.out.println( numberOfNiceSubArrays(nums2, k2) );
        System.out.println( numberOfNiceSubArrays(nums3, k3) );
    }
}
