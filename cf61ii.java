public class cf61ii {
    static int searchRotatedWithDuplicates(int[] arr,int target){
        //WORKS WITH DUPLICATES
        int low=0, high=arr.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target) return mid;

            if(arr[mid]==arr[low] && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }

            //LEFTSIDE
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]) high=mid-1;
                else low=mid+1;
            }

            //RIGHTSIDE
            else{
                if(arr[mid]<=target && target<=arr[high]) low=mid+1;
                else high=mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};

        System.out.println(searchRotatedWithDuplicates(sample,13));
    }
}
