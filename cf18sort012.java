import java.lang.reflect.Array;

public class cf18sort012 {
    public static int[] sort012Of(int[] arr){
        //Using 3 pointers: low,mid,high
        int low=0,mid=0,high=arr.length-1,temp;

        while (mid<=high){
            if(arr[mid]==0){
                temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            } else {
                temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
        return arr;
    }//TC:O(N) SC:O(1)

    static void sortNumsByTwoForLoops(int[] arr) {
        int i = 0;
        int n = arr.length;

        if (n <= 1) return;

        // 1st pass: move all 0s to the left
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // 2nd pass: move all 1s to the left (just after the 0s)
        for (int j = i; j < n; j++) {
            if (arr[j] == 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    }

    static void sortNumsOf(int[] arr){
        int last0Index=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                last0Index=i;
                continue;
            }

            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==0){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                    last0Index=i;
                    break;
                }
            }
        }


        for(int i=last0Index+1;i<arr.length;i++){
            if(arr[i]==1) continue;

            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==1) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                    break;
                }
            }
        }
    }//TC:O(2*(N^2)) SC:O(1)

    public static void main(String[] args) {
        int[] sample = new int[]{0,1,2,0,0,2,0,1,0,2,1,2,1,0,2,2};
        int[] sample2 = new int[]{0,0};

        int[] ans = sort012Of(sample);
        for (int j : sample) {
            System.out.print(j + " ");
        }

        System.out.println();

        sortNumsOf(sample2);
        for(int i: sample2) System.out.print(i+" ");
    }
}
