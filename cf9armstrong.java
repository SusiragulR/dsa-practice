public class cf9armstrong {
    public static boolean isArmstrong(int n){
        int i=1,arm=0,num=n;
        while (num>=1){
            arm+=(cf5powerOfNum.power(num%10,3));
            num/=10;
        }

        return (arm==n);
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(407));
    }
}
