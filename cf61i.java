public class cf61i {
    static int searchSortedRotatedArray(int[] arr,int target){
        //APPROACH FOR NON-REPETITIVE ELEMENTS (UNIQUE ELEMENTS)
        int low=0, high=arr.length-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]==target) return mid;

            else if (arr[low]<=arr[mid]) {
                if(arr[low]<=target && target<=arr[mid]) high=mid-1;
                else low=mid+1;
            }

            else{
                if(arr[mid]<=target && target<=arr[high]) low=mid+1;
                else high=mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{4,5,7,9,1,2};

        System.out.println(searchSortedRotatedArray(sample,14));
    }
}
