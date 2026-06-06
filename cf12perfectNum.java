public class cf12perfectNum {
    public static boolean isPerfect(int n){
        int pr=0,i=1;
        while(i<=n/2){
            if (n%i==0){
                //System.out.println(i);
                pr+=i;
                //System.out.println(pr);
            }
            i++;
        }

        return (n==pr);
    }

    public static void main(String[] args) {
        System.out.println(isPerfect(496));
    }
}
