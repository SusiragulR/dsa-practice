import java.util.Arrays;

public class cf72XXXXXXX {
    public static long findPages(int n, int[] arr, int m) {

        long minSum=Long.MAX_VALUE;

        Arrays.sort(arr);

        if(m>n) return -1;

        else if(m==1){
            long sum=0;
            for(int i: arr) sum+=i;
            return sum;
        }

        else if(m==n) return arr[n-1];

        else{
            int grp= n-m;

            for(int i=0;i<n-grp;i++){
                long sum=0;
                sum+=arr[i];

                for(int j=1;j<=n-grp;j++){
                    sum+=arr[i+j];
                }

                if(sum<minSum) minSum=sum;
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        
    }
}
