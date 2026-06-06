import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    static int searchSortedArrayUsingBinarySearch( int[] arr, int target ) {
        int low = 0;
        int high = arr.length;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) high = mid - 1;
            else if (arr[mid] == target) {
                while(mid-1 >= 0 && arr[mid-1] == target) mid--;
                return mid;
            }
            else low = mid + 1;
        }

        return -1;
    }

    static int floorOfNumInSortedArrayUsingBinarySearch( int[] arr, int target ) {
        int low = 0;
        int high = arr.length;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }

        return (high>=0 && high<arr.length && arr[high]<=target) ? high : -1;
    }

    static ArrayList<Integer> getFirstAndLastIndexOfANumInSortedArray(int[] arr, int target){
        int low1 = 0, high1 = arr.length-1;
        int low2 = 0, high2 = arr.length-1;

        while(low1 <= high1) {
            int mid = (low1 + high1) / 2;

            if(arr[mid] < target) low1 = mid + 1;
            else high1 = mid -1;
        }
        System.out.println("low1 --> " + low1);

        while(low2 <= high2) { // when i gave low < high, for low2 i got the low2 at expectedIndex+1
            int mid = (low2 + high2) / 2;

            if(arr[mid] > target) high2 = mid -1;
            else low2 = mid + 1;
        }
        System.out.println("high2 --> " + high2);

        if (!(low1>=0 && low1<arr.length && arr[low1]==target)) low1 = -1;
        if (!(high2>=0 && high2<arr.length && arr[high2]==target)) high2 = -1;

        return new ArrayList<>(Arrays.asList(low1, high2));
    }

    static boolean isArrangingCowsWithThisDistancePossible(int[] arr, int spaceBetween, int n){
        int numOfCows = 1, lastCowStall = arr[0];
        ArrayList<Integer> stallPositions = new ArrayList<>();
        stallPositions.add(arr[0]);
        for (int i=1; i<arr.length; i++) {
            if((arr[i] - lastCowStall) >= spaceBetween) {
                numOfCows++;
                stallPositions.add(arr[i]);
                lastCowStall = arr[i];
            }
        }

        System.out.println(stallPositions);
        return numOfCows >= n;
    }

    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while(low <= high) {
            int mid = (low + high)/2;

            if(!isArrangingCowsWithThisDistancePossible(stalls, mid, k)) high = mid - 1;
            else low = mid+1;
        }

        return high;
    }

    static boolean willThisNumberOfPagesWork(int[] arr, int givenNumOfStudents, int givenNumOfPages){
        int calculatedNumOfStudents = 1;
        int calculatedNumOfPages = arr[0];
        for (int i=1; i<arr.length; i++) {
            if(calculatedNumOfPages >= givenNumOfPages) {
                calculatedNumOfStudents += 1;
                calculatedNumOfPages = arr[i];
            } else {
                calculatedNumOfPages += arr[i];
            }
        }

        return calculatedNumOfStudents >= givenNumOfStudents;
    }

    static int minimizeMaxNumOfPagesAllocated(int[] arr, int numOfStudents){
        if(arr.length < numOfStudents) return -1;

        int low = arr[0], high = 0;
        for (int j : arr) {
            if (low > j) low = j;
            high += j;
        }

        while (low <= high) {
            int mid = (low + high)/2;
            if(!willThisNumberOfPagesWork(arr,numOfStudents,mid)) high = mid -1;
            else low = mid + 1;
        }

        return high;
    }

    static boolean isThisMaxCapacityBoatSufficient(int[] arr, int numOfDaysGiven, int givenMaxCapacity) {
        int calculatedWeight = 0;
        int numOfDays = 1;

        for(int i: arr) {
            if((calculatedWeight + i) <= givenMaxCapacity) calculatedWeight += i;
            else {
                numOfDays++;
                calculatedWeight=i;
            }
        }

        System.out.println("given: "+givenMaxCapacity+" numOfDay: "+numOfDays);
        return numOfDays <= numOfDaysGiven;
    }

    static int leastWeightCapacity(int[] arr, int n, int d) {
        int low = arr[0];
        int high = 0;

        for(int i: arr) {
            if(i > low) low = i; // the lowest value possible is maximum weight in the array, as we can't split and ship
            high += i;
        }

        System.out.println(low + " --- " + high);

        while (low <= high) {
            int mid = (low + high)/2;

            if(!isThisMaxCapacityBoatSufficient(arr,d,mid)) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    static int countOfDigitsLessThanOrEqualTo(int m, int n, int givenNum){
        int count = 0;
        for(int i=1; i<=m; i++) {
            count += Math.min(givenNum/i, n);
        }
        return count;
    }

    static int giveKthSmallestNumberInAMultiplicationMatrix(int m, int n, int k) {
        if(k > m*n) return -1;

        int low = 1, high = m*n;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(countOfDigitsLessThanOrEqualTo(m, n, mid) < k) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr1, arr2;
        if(nums1.length <= nums2.length){
            arr1 = nums1;
            arr2 = nums2;
        } else {
            arr1 = nums2;
            arr2 = nums1;
        }

        int arr1length=arr1.length, arr2length=arr2.length;

        int low1=0, high1=arr1.length;

        int symmetricArrayLength = (arr1length + arr2length + 1) / 2;

        while(low1 <= high1){
            int mid1 = low1 + (high1 - low1)/2;
            int mid2 = symmetricArrayLength - mid1;
            System.out.println("for: ("+low1+","+high1+")  --->  mid1: "+mid1+", mid2: "+mid2);

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(0 <= mid1 && mid1 <= arr1length-1) r1 = arr1[mid1];
            if(0 <= mid2 && mid2 <= arr2length-1) r2 = arr2[mid2];
            if(0 <= mid1-1 && mid1-1 <= arr1length-1) l1 = arr1[mid1-1];
            if(0 <= mid2-1 && mid2-1 <= arr2length-1) l2 = arr2[mid2-1];
            System.out.println("l1-"+l1+" l2-"+l2+" r1-"+r1+" r2-"+r2);

            if(l2 > r1) low1 = mid1 + 1;
            else if(l1<=r2 && l2<=r1) {
                System.out.println("Answer case ran....");
                if((arr1length + arr2length) % 2 == 0) { // even
                    System.out.println("even case");
                    return ((double)Math.max(l1, l2) + (double)Math.min(r1, r2)) / 2;
                } else { // odd
                    System.out.println("odd case");
                    return (double)Math.max(l1, l2);
                }
            }
            else high1 = mid1 - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1,-1,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,90,100};
        int[] arr2 = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
//        System.out.println(searchSortedArrayUsingBinarySearch(arr1, -1));
//        System.out.println(floorOfNumInSortedArrayUsingBinarySearch(arr1, 91));
//        System.out.println(getFirstAndLastIndexOfANumInSortedArray(arr1, 90));

//        int[] cowStalls = new int[]{0,8,7,9,18};
//        System.out.println(isArrangingCowsWithThisDistancePossible(cowStalls, 17, 2));
//        System.out.println(aggressiveCows(new int[]{2, 12, 11, 3, 26, 7}, 5));
//        System.out.println(aggressiveCows(new int[]{10, 1, 2, 7, 5}, 3));
//        System.out.println(aggressiveCows(new int[]{1, 2, 4, 8, 9}, 3));

//        System.out.println(minimizeMaxNumOfPagesAllocated(new int[]{12, 34, 67, 90}, 2));
//        System.out.println(minimizeMaxNumOfPagesAllocated(new int[]{15, 17, 20}, 5));
//        System.out.println(minimizeMaxNumOfPagesAllocated(new int[]{12, 34, 67, 90}, 1));

//        System.out.println(leastWeightCapacity(new int[]{1, 2, 1}, 3, 2));
//        System.out.println(leastWeightCapacity(new int[]{9, 8, 10}, 3, 3));

//        System.out.println(giveKthSmallestNumberInAMultiplicationMatrix(3,3,5));
//        System.out.println(giveKthSmallestNumberInAMultiplicationMatrix(2,3,6));

//        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0, 0}));
    }
}
