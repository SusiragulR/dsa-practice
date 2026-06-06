import java.util.Arrays;

public class cf73 {
    static long minTime(int[] arr,int n,int k){
        //k=numOfPainters
        long summation=0, max=arr[0];

        for(int i: arr) {
            if(i>max) max=i;
            summation += i;
        }

        long low = max;
        long high = summation;

        while (low<=high){
            long mid = low+(high-low)/2;

            if( numOfPainters(arr,mid)>k ) low=mid+1;
            else high=mid-1;
        }

        return low;
    }

    static int numOfPainters(int[] arr,long maxLenOfBoard){
        int numOfPainters=1, lastAssignedBoardLen=arr[0];
        for (int i=1;i<arr.length;i++) {
            if (lastAssignedBoardLen + arr[i] <= maxLenOfBoard) {
                lastAssignedBoardLen += arr[i];
            }
            else {
                numOfPainters++;
                lastAssignedBoardLen = arr[i];
            }
        }

        return numOfPainters;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{5,10,30,20,15}; //k=3
        int[] sample2 = new int[]{10,20,30,40}; //k=2
        int[] sample3 = new int[]{22 ,8 ,1 ,11 ,3 ,15}; //k=3

        System.out.println(minTime(sample3,6,3));
        System.out.println(numOfPainters(sample3,22));
    }
}
