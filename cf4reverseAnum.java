public class cf4reverseAnum {


    //To find length and then find rev
    public  static int revOfNum (int n){
        //int l = cf3countDigits.countDigit(n);
        int l = (int)Math.floor(Math.log10(n)+1);
        int i=0, rev=0, num=n;
        while(i<l){
            int ld = num%10;
            rev = rev*10 + ld;
            num = num/10;
            i++;
        }

        return rev;
    }

    //NO NEED OF LENGTH
    public static int revOf(int n){
        int num=n,rev=0;
        while(num>0){
            rev*=10;
            rev+=(num%10);
            num/=10;
        }
        return rev;
    }

    public static void main(String[] args) {

        System.out.println(revOfNum(1374));
        System.out.println(revOf(1374));
    }
}
