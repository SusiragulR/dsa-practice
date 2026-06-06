public class cf10pallindrome {
    public static boolean isPallindrome(int n){
        int pal=cf4reverseAnum.revOfNum(n);
        return (pal==n);
    }

    public static void main(String[] args) {
        System.out.println(isPallindrome(114565411));
    }
}
