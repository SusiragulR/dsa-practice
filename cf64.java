public class cf64 {
    static int giveMaxOf(int[] arr){
        int low=0, high=arr.length-1, max=Integer.MIN_VALUE;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]>max) max=arr[mid];

            if(arr[low]==arr[mid] && arr[mid]==arr[high]) {
                low++;
                high--;
                continue;
            }

            if(arr[low]<=arr[mid]) low=mid+1;

            else{
                if(arr[high]>max) max=arr[high];
                high=mid-1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{12,23,33,49,0,2,3,5,7,7,8,8,8,9,9,9,10,11,11,11,11,11,11,11,11};

        System.out.println(giveMaxOf(sample));
    }
}
