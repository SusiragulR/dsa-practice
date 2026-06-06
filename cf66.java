public class cf66 {
    static int givePeakIndexBiotonic(int[] arr){
        int low=1, high=arr.length-2;

        while (low<=high){
            int mid= low+(high-low)/2;

            if(arr[mid]>=arr[mid-1] && arr[mid]>arr[mid+1]) return mid;

            if(arr[low]<=arr[mid] && arr[mid]<=arr[mid+1]) low=mid+1;

            if(arr[high]<=arr[mid] && arr[mid]<=arr[mid-1]) high=mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sample= new int[]{1,2,3,4,5,6,7,8,9,10,10,8,7,7,6};
        int[] sample2 = new int[]{1,1,2,3,4,5,6,7,8,9,10,10};

        System.out.println(givePeakIndexBiotonic(sample2));
    }
}
