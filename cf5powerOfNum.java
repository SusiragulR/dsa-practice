public class cf5powerOfNum {
    public  static int power(int n,int p){
        int i=0,ans=1;
        while (i<p){
            ans*=n;
            i++;
        }
        return ans;
    }//TC:O(P) SC:O(1)

    public static int powerOf(int n, int p){
        int ans=1;
        while(p>0) {
            if (p % 2 != 0) {
                ans*=n;
            }
            n *= n;
            p=p/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(power(4,3));
        System.out.println(powerOf(4,3));
    }
}
