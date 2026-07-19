package Greedy;

public class G2_minimumOperations {
    public int minOperation(int n) {
        int count = 0;

        while( n!=0 ) {
            if (n%2!=0) n--;
            else n/=2;
            count++;
        }

        return count;
    }
}
