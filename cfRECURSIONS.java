import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class cfRECURSIONS {
    static void printTillN(int i){
        if(i==1) {
            System.out.println(1);
            return;
        }
        printTillN(i-1);
        System.out.println(i);
    }

    static long factorial(int N){
        if(N==0) return 1;
        if(N==1) return 1;
        return (N * factorial(N-1)) ;
    }

    static int nthFibonacci(int n){
        if(n==1) return 1;
        if(n==2) return 1;
        return( nthFibonacci(n-1) + nthFibonacci(n-2) );
    }

    static long powerOf(int i,int n){
        if(n==0) return 1;
        if(n==1) return i;
        return (i*powerOf(i,n-1));
    }

    static int giveIndexOf(int[] arr,int target){
        int low=0,high=arr.length-1;
        int mid = (low+high)/2;

        while (high>=low) {
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        int[] sample = new int[]{3,4,6,7,9,12,16,17};
        System.out.println(giveIndexOf(sample,17));
    }
}
