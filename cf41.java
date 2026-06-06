import java.util.ArrayList;
import java.util.List;

public class cf41 {

    static boolean[] createSieve(int n){
        boolean[] sieve = new boolean[n+1];

        for(int i=2; i<=n; i++){
            sieve[i] = true;
        }

        for( int i=2; i*i<=n; i++ ){
            if(sieve[i]) {
                for ( int j=i*i; j<=n; j+=i ) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

    //************************************
    //************************************
    //TO FIND A PAIR OF PRIME NUMBERS IN A RANGE WITH SMALLEST DIFFERENCE BETWEEN THEM
    static int[] closestPrimes(int left, int right) {

        boolean[] isPrime = createSieve(right);
        List<Integer> primes = new ArrayList<>();

        for(int i=left; i<=right; i++) if(isPrime[i]) primes.add(i);

        if(primes.size() < 2) return new int[]{-1,-1};

        else if(primes.size() == 2) return new int[]{ primes.get(0), primes.get(1) };

        else{
            int i1=0, i2=1, min=Integer.MAX_VALUE;

            for(int i=0; i<primes.size()-1; i++){
                int diff = primes.get(i+1)-primes.get(i);

                if( diff < min ){
                    min = diff;
                    i1 = i;
                    i2 = i+1;
                }
            }

            return new int[]{ primes.get(i1), primes.get(i2) };
        }
    }

    public static void main(String[] args) {
        int[] pair = closestPrimes(101,113);

        for(int i: pair) System.out.println(i+" ");
    }
}
