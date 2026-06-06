public class numberComplement {
    public static int findComplement(int num) {
        if(num==0) return 1;

        int i=0,copy=num;
        while(copy!=0){
            copy >>= 1;
            i++;
        }
        int maxBin = 2*((int)Math.pow(2,i-1))  -1;
        return maxBin-num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(15));
    }
}
