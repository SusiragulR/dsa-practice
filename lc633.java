public class lc633 {
    static boolean judgeSquareSum(int c) {
        for(long i=0; i*i<=c; i++){

            long low=0, high=c;

            while(low <= high){
                long mid = low + (high - low)/2;

                if( ((i*i) + (mid*mid)) == c ) {
                    System.out.println(i+" "+mid);
                    return true;
                }
                else if (((i*i) + (mid*mid)) < c) low = mid+1;
                else high = mid-1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println( judgeSquareSum(131072) );
    }
}
