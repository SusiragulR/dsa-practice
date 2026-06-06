public class cf36kadanesalgo {
    //to find subarray with max sum
    static String[] subArrayWithMaxSum(int[] arr){
        long sum=0,maxSum=Long.MIN_VALUE;
        int start=0,ansStart=0,ansEnd=0;
        for(int i=0;i<arr.length;i++){
            if(sum==0) start=i;

            sum+=arr[i];

            if(sum>maxSum){
                maxSum=sum;
                ansStart=start;
                ansEnd=i;
            }

            if(sum<0) sum=0;
        }

        String[] ans = new String[3];
        ans[0] = "sum:"+maxSum;
        ans[1] = "start:"+ansStart;
        ans[2] = "end:"+ansEnd;

        return ans;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{5,4,7};
        int[] sample2 = new int[]{1,2,3,-2,5};

        String[] ans = subArrayWithMaxSum(sample);

        for(String i: ans) System.out.println(i);
    }
}
