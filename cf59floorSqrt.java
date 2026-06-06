public class cf59floorSqrt {
    static int bsSqrtOf(int n){
        int low=0,high=n,ans=n;
        while(low<=high){
            int mid=(low+high)/2;

            if(mid*mid==n) return mid;

            else if (mid*mid>n) high=mid-1;

            else{
                ans=mid;
                low=mid+1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(bsSqrtOf(1));
    }
}
