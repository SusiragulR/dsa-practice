public class cf77 {
    static int numOfHours(int[] arr,int eatingSpeed){
        int numOfHours=0;
        for(int i: arr){
            numOfHours+=(i/eatingSpeed);
            if(i%eatingSpeed != 0) numOfHours++;
        }
        return numOfHours;
    }

    static int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE; //min=piles[0];
        for(int i: piles){
            if(i>max) max=i;
            //if(i<min) min=i;
        }

        int low=1, high=max;

        while (low<=high){
            int mid = low+(high-low)/2;

            if(calculateTotalHours(piles,mid)<=h) high=mid-1;
            else low=mid+1;
        }

        return low;
    }

    //STRIVER'S
    public static int calculateTotalHours(int[] arr, int eatingSpeed) {
        int numOfHours = 0;
        int n = arr.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            numOfHours += Math.ceil((double)(arr[i]) / (double)(eatingSpeed));
        }
        return numOfHours;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{3,6,7,11}; //h=8 o/p:4
        int[] sample2 = new int[]{30,11,23,4,20}; //h=5 o/p:30
        int[] sample3 = new int[]{30,11,23,4,20}; //h=6 o/p:23
        int[] sample4 = new int[]{805306368,805306368,805306368}; //h=1000000000 o/p:3
        int[] sample5 = new int[]{2, 2}; //h=4 o/p:1

        System.out.println(minEatingSpeed(sample4,1000000000));
        //System.out.println(numOfHours(sample4,444));
    }
}
