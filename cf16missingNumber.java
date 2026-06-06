public class cf16missingNumber {
    static int missingNumber(int n, int[] arr) {
        int i=0,sum=0,missing=0;
        while(i<n-1){
            sum+=arr[i];
            i++;
        }

        missing=((n*(n+1)/2)-sum);
        return missing;
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{1,2,3,4,6,7};

        System.out.println(missingNumber(7, myArr));
    }
}
