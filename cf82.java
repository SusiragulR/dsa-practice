public class cf82 {
    static long divSumOf(int[] arr,int n){
        long sum=0;
        int low=0, high=arr.length-1;

        while(low<=high){
            if(low==high) {
                sum += Math.ceilDiv(arr[low], n);
                low++;
            }
            else {
                sum += Math.ceilDiv(arr[low],n);
                low++;
                sum += Math.ceilDiv(arr[high],n);
                high--;
            }
        }

        return sum;
    }

    static int minNum(int[] nums,int threshold){
        int min=nums[0], max=nums[0];
        for (int i: nums){
            if(i<min) min=i;
            if(i>max) max=i;
        }

        int low=min, high=max;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(divSumOf(nums,mid)>threshold) low=mid+1;
            else high=mid-1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,2,5,9}; //t=6 o/p:5
        int[] sample2 = new int[]{44,22,33,11,1}; //t=5 o/p:44
        int[] sample3 = new int[]{1,2,5,9}; //t=6 o/p:5

        System.out.println(minNum(sample,6));
    }
}
