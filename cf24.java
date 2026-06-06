import java.lang.reflect.Array;
import java.util.Arrays;

public class cf24 {
    static boolean hasArrayTwoCandidates(int arr[], int x) {
        Arrays.sort(arr);

        int left=0,right=arr.length-1;

        while(left<right){
            int sum = arr[left] + arr[right];

            if(sum==x){
                return true;
            }
            if(sum<x){
                left++;
            }else{
                right--;
            }
        }

        return false;
    }//TC:O( N + NlogN ->sorting ) SC:O(1)

    public static void main(String[] args) {
        int[] sample= new int[]{2,3,2,3,5};

        System.out.println(hasArrayTwoCandidates(sample,9));
    }
}
