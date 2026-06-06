public class cf74 {
    static int splitArray(int[] arr , int N, int K) {
        // K=numOfArrays
        long max=arr[0], summation=0;

        for(int i=0;i<N;i++){
            if(arr[i]>max) max=arr[i];
            summation+=arr[i];
        }

        long low=max, high=summation;

        while(low<=high){
            long mid = low+(high-low)/2;

            if(numOfArrays(arr,mid)<=K) high=mid-1;
            else low=mid+1;
        }

        return (int)low;
    }

    static int numOfArrays(int[] arr,long maxPossibleSum){
        int lastSum=arr[0], numOfSubarrays=1;
        for(int i=1;i<arr.length;i++){
            if(lastSum+arr[i] <= maxPossibleSum) lastSum+=arr[i];
            else{
                numOfSubarrays++;
                lastSum=arr[i];
            }
        }
        return numOfSubarrays;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1, 2, 3, 4}; //k=3
        int[] sample2 = new int[]{1 ,1, 2}; //k=2

        System.out.println(splitArray(sample2,3,2));
    }
}
