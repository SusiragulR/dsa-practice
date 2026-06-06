import java.util.ArrayList;
import java.util.List;

public class cf86mergeSort {
    static void merge(char[] arr,int low,int mid,int high){
        int left=low, right=mid+1;
        ArrayList<Character> temp = new ArrayList<>();

        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while (right<=high){
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    static void mergeSort(char[] arr,int low,int high){
        if(low==high) return;

        int mid = low+(high-low)/2;

        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);

        merge(arr,low,mid,high);
    }

    public static void main(String[] args) {
        int[] sample = new int[]{0,11,2,-1000000,5,33,6,8,9,71,17,13,-13,10000};
        char[] sample2 = new char[]{'d','g','y','e','v','j','b','q','c','r','g','a','o','p','i','n'};

        mergeSort(sample2,0, sample2.length-1);

        for (char i: sample2) System.out.print(i+" ");
    }
}
