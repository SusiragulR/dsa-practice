import java.util.LinkedList;
import java.util.Queue;

public class n2lessthanN {

    static int countSquares(int N) {
        int low = 0, high = N, n = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long sq = (long) mid * mid;
            //does not work if i give long sq = mid * mid;
            //(long) is important

            if (sq < N) {
                n = mid;
                low = mid + 1;
            } else high = mid - 1;
        }

        return n;
    }


    public static void main(String[] args) {
        System.out.println(countSquares(265));
    }

}
