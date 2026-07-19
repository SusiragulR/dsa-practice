package Greedy;

public class G10_minNumOfCoins {
    public int findMin(int n) {
        int numOfCoins = 0;

        int[] coins = new int[]{10, 5, 2, 1};

        for( int c: coins ) {
            numOfCoins += n/c;
            n = n%c;
        }

        return numOfCoins;
    }
}
