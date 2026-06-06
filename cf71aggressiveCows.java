import java.util.Arrays;

public class cf71aggressiveCows {
    static int maxOfMinDistance(int[] arr,int n){
        Arrays.sort(arr);

        int low=1, high=arr[arr.length-1];

        while (low<=high){
            int mid = low+(high-low)/2;
            if( canWePlace(arr, n, mid) ) low=mid+1;
            else high = mid-1;
        }

        return high;
    }

    static boolean canWePlace(int[] arr,int n,int minDist){
        int lastCowIndex=arr[0], countOfCowsPlaced=1;

        for(int i=1;i< arr.length;i++){
            if(arr[i]-lastCowIndex >= minDist){
                lastCowIndex=arr[i];
                countOfCowsPlaced++;
            }
        }

        return countOfCowsPlaced>=n;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{10 ,1 ,2 ,7 ,5};
        int[] sample2 = new int[]{1 ,2 ,4 ,8 ,9};
        int[] sample3 = new int[]{35 ,15 ,24 ,13 ,23 ,20 ,26 ,33 ,2};

        System.out.println(maxOfMinDistance(sample3,3));
    }
}
