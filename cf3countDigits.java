public class cf3countDigits {
    public static int countDigit(int n){
        int l=0;
        int num=n;
        while(num>=1){
            l++;
            num=num/10;
        }
        return l;
    } //TC:O(log N)  SC:O(1)

    public static int countDigOf(int n){
        return (int)Math.floor(Math.log10(n) + 1);
    } //TC:O(1)  SC:O(1)

    public static void main(String[] args) {
        System.out.println(countDigit(145667));
        System.out.println(countDigOf(1433));
        //System.out.println(1/10);
    }
}
