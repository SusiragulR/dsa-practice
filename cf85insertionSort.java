public class cf85insertionSort {
    static void insert(int[] arr,int i)
    {
        while(i>0 && arr[i-1]>arr[i]){
            int temp=arr[i-1];
            arr[i-1]=arr[i];
            arr[i]=temp;
            i--;
        }
    }
    //Function to sort the array using insertion sort algorithm.
    static void insertionSort(int[] arr, int n)
    {
        for(int i=0;i<n;i++){
            insert(arr,i);
        }
    }

    public static void main(String[] args) {
        int[] sample = new int[]{0,11,2,-1000000,5,33,6,8,9,71,17,13,-13,10000};

        insertionSort(sample, sample.length);

        for (int i: sample) System.out.print(i+" ");
    }
}
