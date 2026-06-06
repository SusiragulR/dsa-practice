public class cf84selectionSort {
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i=0; i<=n-2; i++){
            int minIndex = i;
            for(int j=i+1; j<=n-1; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{13,16,5,24,2,1,-9,0,8};

        selectionSort(arr1);

        for (int j : arr1) {
            System.out.print(j + " ");
        }
    }
}
