public class cf83bubbleSort {
    static void bubbleSort(int[] arr,int n){
        for (int i=n-2;i>=0;i--) {
            for (int j = 0; j <= i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sample = new int[]{0,11,2,5,33,6,8,9,71,17,13,13};

        bubbleSort(sample, sample.length);

        for (int i: sample) System.out.print(i+" ");
    }
}
