import java.util.Arrays;

public class cf72 {
    static int noOfStudents(int[] arr,long allowedNumOfPages){
        int lastAllocatedPageCount = arr[0], allocatedStudents=1;
        for(int i=1;i<arr.length;i++){
            if(lastAllocatedPageCount+arr[i] <= allowedNumOfPages) lastAllocatedPageCount+=arr[i];
            else{
                allocatedStudents++;
                lastAllocatedPageCount=arr[i];
            }
        }

        return allocatedStudents;
    }

    //BINARY SEARCH FROM:: low:(MAX OF THE ARRAY) -----> high:(SUMMATION OF THE ARRAY)
    static long minOfMaxPossibblePages(int[] arr, int numOfBooks, int numOfStudents){
        long summation = 0, max=arr[0];
        for(int i : arr){
            if(i>max) max=i;
            summation+=i;
        }

        long low=max, high=summation;

        while(low<=high){
            long mid = low+(high-low)/2;

            if(noOfStudents(arr,mid)<=numOfStudents) high=mid-1;
            else low=mid+1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{12 ,34 ,67 ,90};
        int[] sample2 = new int[]{15 ,10 ,19 ,10 ,5 ,18 ,7};
        int[] sample3 = new int[]{13 ,31 ,37 ,45 ,46 ,54 ,55 ,63 ,73 ,84 ,85};

        System.out.println(minOfMaxPossibblePages(sample3,11,9));
    }
}
