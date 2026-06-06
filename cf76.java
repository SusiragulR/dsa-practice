public class cf76 {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // n=length of arr
        // d=number of days
        long max=arr[0], summation=0;

        for (int i: arr){
            summation+=i;
            if(i>max) max=i;
        }

        long low=max, high=summation;

        while(low<=high){
            long mid=low+(high-low)/2;

            if(numberOfDays(arr,mid) > d) low=mid+1;
            else high=mid-1;
        }

        return (int)low;
    }

    static int numberOfDays(int[] arr,long maxWeight){
        long weightLoaded=0;
        int numberOfDays=1;
        for(int i: arr){
            if(weightLoaded+i<=maxWeight) weightLoaded+=i;
            else{
                numberOfDays++;
                weightLoaded=i;
            }
        }

        return numberOfDays;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{9, 8, 10}; //d=3 o/p:10
        int[] sample2 = new int[]{1, 2, 1}; //d=2 o/p:3

        System.out.println(leastWeightCapacity(sample2,3,2));
        System.out.println(numberOfDays(sample2,4));
    }
}
