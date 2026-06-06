public class cf75 {
    static int minDays(int[] bloomDay, int m, int k) {
        //m=num of boquets
        //k=num of flowers

        if(bloomDay.length < (m*k)) return -1;

        int min=bloomDay[0], max=bloomDay[0];

        for(int i: bloomDay){
            if(i<min) min=i;
            if(i>max) max=i;
        }

        int low=min, high=max;
        //System.out.println("low:"+low+" high:"+high);

        while(low<=high){
            int mid = low+(high-low)/2;

            if( numOfBoquets(bloomDay,k,mid) >= m ) high=mid-1;
            else low=mid+1;
        }

        return low;
    }

    static int numOfBoquets(int[] arr, int flowersPerBoquet, int nthDay){
        int numOfBoquets = 0, lastCount=0;
        for (int j : arr) {
            if (j <= nthDay) {
                lastCount++;
                if (lastCount == flowersPerBoquet) {
                    numOfBoquets++;
                    lastCount = 0;
                }
            } else lastCount = 0;
        }

        return numOfBoquets;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,10,3,10,2}; //m=3 k=1
        int[] sample2 = new int[]{1,10,3,10,2}; //m=3 k=2
        int[] sample3 = new int[]{7,7,7,7,12,7,7}; //m=2 k=3

        System.out.println(minDays(sample,3,1));
        System.out.println(minDays(sample2,3,2));
        System.out.println(minDays(sample3,2,3));
        System.out.println("**************");
        //System.out.println(numOfBoquets(sample,1,9));
    }
}
