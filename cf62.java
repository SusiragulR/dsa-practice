public class cf62 {
    static int getMinimum(int[] arr){
        int low=0, high=arr.length-1, min=Integer.MAX_VALUE;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]<min) min=arr[mid];

            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }

            //if left-sorted then arr[low] compared with min and then trim left
            if(arr[low]<=arr[mid]) {
                if(arr[low]<min) min=arr[low];
                low = mid + 1;
            }

            //if right-sorted trim right
            else high=mid-1;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,2,1};

        System.out.println(getMinimum(sample));
    }
}
