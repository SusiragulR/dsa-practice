public class cf80uglyNum {
    static int minOf(int a,int b){
        if(a<b) return a;
        else return b;
    }
    static int nthUglyNum(int n){
        int[] uglyNums = new int[n];
        uglyNums[0]=1;

        int p2=0, p3=0, p5=0;

        for (int i=1;i<n;i++){
            int twoMultiple = uglyNums[p2]*2;
            int threeMultiple = uglyNums[p3]*3;
            int fiveMultiple = uglyNums[p5]*5;

            uglyNums[i] = Math.min( twoMultiple, Math.min(threeMultiple,fiveMultiple) );

            if(uglyNums[i]==twoMultiple) p2++;
            if(uglyNums[i]==threeMultiple) p3++;
            if(uglyNums[i]==fiveMultiple) p5++;
        }

        return uglyNums[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNum(12));
    }
}
