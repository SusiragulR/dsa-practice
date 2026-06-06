public class cf11sqrt {
    public static int sqrtOf(int n){
        //repeated subtraction method
        int i=1,num=n,ans=0;
        while(num>0){
            num-=i;
            i+=2;
            ans++;
        }
        return ans;
    }

    static int sqrt(int n){
        int i=1,ans=1;
        while(ans<=n){
            i++;
            ans=i*i;
        }
        return i-1;
    }

    public static int findSquareRoot(int x) {
        if (x < 0)
            // Handle negative numbers
            return -1;
        if (x == 0 || x == 1)
            // The square root of 0 is 0, and the square root of 1 is 1.
            return x;

        // Calculate the floating-point square root using Math.exp and Math.log
        double sqrtApprox = Math.exp(Math.log(x) / 2);

        // Round the result to the nearest integer
        int floorResult = (int) Math.floor(sqrtApprox);

        // Verify if the result is indeed correct
        if (floorResult * floorResult == x) {
            return floorResult;
        }

        // Check if incrementing the floor result gives the correct square root
        if ((floorResult + 1) * (floorResult + 1) == x) {
            return floorResult + 1;
        }

        return floorResult;
    }//TC:O(1) SC:O(1)

    public static void main(String[] args) {
        System.out.println(sqrtOf(225));
        System.out.println(sqrt(225));
    }
}
