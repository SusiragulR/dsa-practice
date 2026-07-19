package Greedy;

public class G4_largestNumberPossible {
    static String findLargest(int n, int s) {
        //edge cases:
        //if sum is 0 and numOfDigits is 1, return 1
        //if sum is 0 nd numOfDigits > 1 not possible right? we can return -1
        if(s==0) return n==1 ? "0" : "-1";

        //even if we arrive the largest digit possible for
        //the given numOfDigits
        //say 999 for 3 and 99999 for 5, this is max sum possible too
        //if sum is greater than sum of these digits, not possible
        if(s > 9*n) return "-1";

        StringBuilder ans = new StringBuilder();

        while(n!=0) {
            ans.append( Math.min(s,9) );
            s -= Math.min( s, 9 );
            n--;
        }

        return ans.toString();
    }
}
