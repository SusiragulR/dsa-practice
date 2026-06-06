public class cf14secondLargest {
    public static int secondLargestOf(int[] arr){
        int i=0,max=arr[0],secmax=-1000;

        while(i<arr.length){
            if(arr[i]>max){
                secmax=max;
                max=arr[i];
            } else if (arr[i]>secmax) {
                secmax=arr[i];
            }
            i++;
        }

        return secmax;
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{5,9,6,0,2};

        System.out.println(secondLargestOf(myArr));
    }
}
