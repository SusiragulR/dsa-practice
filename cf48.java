import java.util.ArrayList;
import java.util.Arrays;

public class cf48 {
    static void print_1toN_UsingRecursion(int n){
        if(n == 1) System.out.println(n);
        else {
            print_1toN_UsingRecursion(n - 1);
            System.out.println(n);
        };
    }

    static long factorialOfN(int n){
        if(n==1) return 1;
        else return n * factorialOfN(n-1);
    }

    static long nthFibonacciNumber(long n){
        if(n==0) return 0;
        if(n==1) return 1;
        else return nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);
    }

    static long powerUsingRecursion(long base, long power){
        if(power == 0) return 1;
        if(power == 1) return base;
        else return base * powerUsingRecursion(base, power - 1);
    }

    static ArrayList<Integer> nthRowOfPascalTriangle(int targetRow, int n, ArrayList<Integer> previousRow) {
        //System.out.println("processing row -> "+n);
        //System.out.println("i/p prev row: "+previousRow);

        ArrayList<Integer> presentRow = new ArrayList<>(n);
        presentRow.add(1);
        //System.out.println("initial 1 added:"+presentRow);

        //System.out.println(presentRow);

        for(int i=1; i<=n-2; i++){
            //System.out.println("for loop i: "+i);
            presentRow.add(previousRow.get(i-1)+previousRow.get(i));
        }

        if(n != 1) {
            presentRow.add(1);
            //System.out.println("last 1 added:" + presentRow);
        }

        //System.out.println("row-"+n+"->"+presentRow);

        if(n == targetRow) return presentRow;
        else return nthRowOfPascalTriangle(targetRow, n+1, presentRow);
    }

    static int recursiveAtoI(String str){
        int startIndex = 0, strLength = str.length();
        boolean isNegative = false;

        if(strLength == 0) return 0; // empty string handled

        while(
                (str.charAt(startIndex)==' ') && (startIndex+1 <= strLength-1)
        ) startIndex++; // leading whitespaces handled
        if(startIndex == ' ') return 0; // string with empty spaces alone handled

        if(str.charAt(startIndex) == '-') {
            isNegative = true; // negative sign handled
            startIndex++;
        } else if (str.charAt(startIndex) == '+') {
            startIndex++; // positive sign neglected
        }

        if(startIndex > strLength-1) return 0;

        while(str.charAt(startIndex) == '0') startIndex++; // leading zeros handled

        return multiplyBy10AndAddPresentNumber(0, startIndex, str);
    }

    static int multiplyBy10AndAddPresentNumber(int ans, int index, String str){
        if(index == str.length()) return 0;
        int difference = str.charAt(index) - '0';
        if(difference<0 || difference>9) return 0; // first non-digit character handled
        return (ans*10) + difference + multiplyBy10AndAddPresentNumber((ans*10) + difference, index+1, str);
    }

    static int AtoIUsingForLoop(String str) {
        int strLength = str.length();
        boolean hasReachedFirstNonSpaceCharacter = false;
        boolean isNegativeNumber = false;
        int ans = 0;
        int INT_MAX = Integer.MAX_VALUE; //  2^31 - 1
        int INT_MIN = Integer.MIN_VALUE; // -2^31

        for (int i=0; i<strLength; i++) {
            char charAtIndex = str.charAt(i);
            int diff = charAtIndex - '0';

            if(!hasReachedFirstNonSpaceCharacter){
                if(charAtIndex == ' ') continue;
                else if(charAtIndex == '-') {
                    hasReachedFirstNonSpaceCharacter = true;
                    isNegativeNumber = true;
                    continue;
                } else if(charAtIndex == '+') {
                    hasReachedFirstNonSpaceCharacter = true;
                    continue;
                } else if(diff<0 || diff>9){ // a non-digit character
                    return ans;
                } else { // a digit character
                    hasReachedFirstNonSpaceCharacter = true;
                    ans = (ans*10) + diff;
                }
            } else {
                if (diff < 0 || diff > 9) { // stop if non-digit
                    break;
                }

                // ✅ check overflow before adding digit
                if (ans > (INT_MAX - diff) / 10) {
                    return isNegativeNumber ? INT_MIN : INT_MAX;
                }

                ans = ans * 10 + diff;
            }
        }

        return isNegativeNumber ? ans * -1 : ans;
    }

    public static void main(String[] args) {
//        print_1toN_UsingRecursion(7);
//        System.out.println(factorialOfN(4));
//        System.out.println(nthFibonacciNumber(500));
//        System.out.println(powerUsingRecursion(2,5));
//        System.out.println(nthRowOfPascalTriangle(9, 1, new ArrayList<>(Arrays.asList())));
//        System.out.println(recursiveAtoI("321"));
        System.out.println(AtoIUsingForLoop(" +45242"));
        System.out.println(AtoIUsingForLoop(" -91283472332"));
        System.out.println(AtoIUsingForLoop("  9999999999"));
    }
}
