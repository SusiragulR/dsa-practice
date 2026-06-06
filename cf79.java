public class cf79 {

    static int pairsLessThanEqualTo(int[] arr,int target){
        int sum=0;
        for(int i=0;i<= arr.length-2;i++){
            for (int j=i+1;j< arr.length;j++){
                int diff = arr[j]-arr[i];
                if(diff<0) diff*=-1;
                if(diff <= target) sum+=1;
            }
        }
        return sum;
    }

    static int smallestDistancePair(int[] nums, int k) {
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

        for(int i: nums){
            if(i>max) max=i;
            if(i<min) min=i;
        }

        int low=0, high=max-min;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(pairsLessThanEqualTo(nums,mid)<k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,3,1}; //k=1 o/p:0
        int[] sample2 = new int[]{1,1,1}; //k=2 o/p:0
        int[] sample3 = new int[]{1,6,1}; //k=3 o/p:5

        System.out.println(smallestDistancePair(sample3,3));
    }
}
