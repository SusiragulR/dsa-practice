public class cf20cf21 {

        public static int[] rotateArrayByK(int[] arr, int k) {

            if(arr.length==k){
                return arr;
            }

            int l = arr.length;
            k = k % l;
            int[] temp = new int[k];

            for(int i=0;i<k;i++){
                temp[i]=arr[i];
            }

            for(int i=k;i<l;i++){
                arr[i-k]=arr[i];
            }

            for(int i=0;i<k;i++){
                arr[l-k+i]=temp[i];
            }

            return arr;
        }//TC:O(N+k) //SC:O(k)

        static int[] reverse(int[] arr,int start,int end){
            while(start<end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
            return arr;
        }
        static int[] rotateByN(int[] arr,int k){

            int l= arr.length;

            if(l==k) return arr;

            k=k%l;

            reverse(arr,0,k-1);
            reverse(arr, k , l-1);
            reverse(arr,0,l-1);

            return arr;
        }//TC:O(2N) SC:O(1)

        public static void main(String[] args) {
            int[] sample = new int[]{1,2,3,4,5,6};

            //int[] ans = rotateArrayByK(sample,6);
            int[] ans = rotateByN(sample,5);

            for(int i: sample){
                System.out.print(i+" ");
            }
        }
}
