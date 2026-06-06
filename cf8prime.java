public class cf8prime {
    public static boolean isPrime(int n){
        int i=2;
        boolean p=true;
        while (i<=n/2){
            if (n%i==0){
                p=false;
                break;
            }
            i++;
        }
        return p;
    }

    static boolean checkPrime(int n){
        if(n%2==0){
            return false;
        }
        for(int i=3;i<Math.sqrt(n);i+=2){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(97));
        System.out.println(checkPrime(97));
    }
}
