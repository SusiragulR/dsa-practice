public class cf6gcd {
    public static int gcdOf(int[] nums){
        int gcd=1;

        //to find smallest digit
        int sd=nums[0];
        for(int k=0;k<nums.length;k++){
            if (nums[k]<sd){
                sd=nums[k];
            }
        }

        for(int i=1;i<=sd;i++){
            boolean nd=false;
            for(int j=0;j<nums.length;j++){
                if (nums[j] % i != 0) {
                    nd = true;
                    break;
                }
            }

            if (!nd){
                gcd = i;
            }
        }

        return gcd;
    }

    static int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
        }
        if(a==0){
            return b;
        }
        return a;
    }//TC:O(log N) SC:O(1)

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0]=250;
        nums[1]=250;
        nums[2]=750;
        nums[3]=500;
        //System.out.println(gcdOf(nums));

        System.out.println(gcd(56,98));
    }
}
