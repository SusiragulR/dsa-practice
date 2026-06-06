public class nCr {
    static int denOf(int r){
        if (r==1) return 1;
        return (r*denOf(r-1));
    }

    static int nCr(int n, int r)
    {
        if(r>n) return 0;

        int num = n;

        for(int i=1;i<r;i++){
            num*=(num-i);
        }

        int den = denOf(r);

        return (num/den)%1000000007;
    }

    public static void main(String[] args) {
        System.out.println(nCr(11,6));
    }
}
