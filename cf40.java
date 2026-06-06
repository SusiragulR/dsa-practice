public class cf40 {
    static void nextPermutation(int[] nums){
        int bp = -1;

        for(int i=nums.length-2; i>=0; i--){
            if( nums[i] < nums[i+1] ) {
                bp = i;
                break;
            }
        }

        if( bp != -1 ) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[bp]) {
                    int temp = nums[i];
                    nums[i] = nums[bp];
                    nums[bp] = temp;

                    break;
                }
            }

            reversFrom(nums, bp + 1, nums.length - 1);
        }

        else reversFrom(nums, 0, nums.length - 1);
    }
    //TC:O(2.5N) ~ O(3N)
    //SC:O(1)

    static void reversFrom(int[] arr, int from, int to){
        while( from < to ){
            int temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;

            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,3,2};

        nextPermutation(sample);

        for(int i: sample) System.out.print(i+" ");
    }
}
