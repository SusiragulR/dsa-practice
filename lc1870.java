public class lc1870 {
    static int minSpeedOnTime(int[] dist, double hour) {
        int low=1, high=10000000;

        //for (int i: dist) if(i > high) high=i;

        //if(hour < hoursTaken(dist,high)) return -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(hoursTaken(dist, mid) > hour) low = mid+1;
            else high = mid-1;
        }

        return low;
    }

    static double hoursTaken(int[] dist, int speed) {
        double hoursTaken = 0;

        for (int i : dist) {
            hoursTaken = Math.ceil(hoursTaken);
            hoursTaken += (double) i / speed;
        }

        return hoursTaken;
    }

    public static void main(String[] args) {
        int[] dist = new int[]{1,3,2}; //h=6 op:1
        int[] dist2 = new int[]{1,3,2}; //h=2.7 op:3
        int[] dist3 = new int[]{1,3,2}; //h=1.9 op:-1
        int[] dist4 = new int[]{1,1,100000}; //h=2.01 op:10000000

        System.out.println(minSpeedOnTime(dist,2));

        System.out.println(hoursTaken(new int[]{1,1,100000}, 100000));
    }
}
