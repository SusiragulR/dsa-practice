import java.util.*;

public class check {
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){
        if(K>N) return -1;

        long sum = 0;

        for(int i=0; i<K; i++) sum+=Arr.get(i);

        long max = sum;
        int start = 0, j = K;

        while(j<N){
            sum-=Arr.get(start);
            start++;

            sum+=Arr.get(j);
            j++;

            max = Math.max(max,sum);
        }

        return max;
    }

    static int shipWithinDays(int[] weights, int target) {
        long low=Long.MIN_VALUE, high=0; //max as low and sum as high

        for(int i=0; i<weights.length; i++){
            if(low < weights[i]) low=weights[i];
            high += weights[i];
        }

        if(target == weights.length) return (int)low;

        while(low <= high){
            long mid = low + (high-low)/2;

            if( numOfDays(weights, mid) <= target ) high = mid-1;
            else low = mid+1;
        }

        return (int)low;
    }

    static int numOfDays(int[] weights,long maxWeight){
        int count=1;
        long sum = weights[0];

        for(int i=1; i<weights.length; i++){
            if( sum+weights[i] <= maxWeight ) sum += weights[i];
            else{
                count++;
                sum = weights[i];
            }
        }

        return count;
    }



    static int[] searchRange(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};

        int low=0, high=nums.length-1, min=Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] <= target) low = mid+1;
            else high = mid-1;
        }

        if(0<=high && high<=nums.length-1) {
            if (nums[high] != target) return new int[]{-1, -1};
        }
        else return new int[]{-1,-1};

        int lastIndex = high;
        low=0;
        high=nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] < target) low = mid+1;
            else high = mid-1;
        }

        return new int[]{low,lastIndex};
    }



    public static void main(String[] args) {
        int[] sample = new int[]{1,2,3,4,10000};
        int[] sample2 = new int[]{-5,-5,-5,-5};

//        ArrayList<Integer> sample2List = new ArrayList<>();
//        sample2List.add(3);
//        sample2List.add(2);
//        sample2List.add(10);
//        sample2List.add(11);
//        sample2List.add(5);
//        sample2List.add(10);
//        sample2List.add(6);
//        sample2List.add(3);
//        System.out.println(maximumSumSubarray(2, sample2List, sample2List.size()));

        System.out.println(shipWithinDays(sample, 2));
    }
}
