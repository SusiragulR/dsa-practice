import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cf2LastDigit {
    public static int lastDigit(int n) {
        return n%10;
    }

    public static int lastDigitOfPower(String a, String b) {
        List<List<Integer>> possibilities = new ArrayList<List<Integer>>();
        possibilities.add(Arrays.asList(0));              // 0
        possibilities.add(Arrays.asList(1));              // 1
        possibilities.add(Arrays.asList(2, 4, 8, 6));     // 2
        possibilities.add(Arrays.asList(3, 9, 7, 1));     // 3
        possibilities.add(Arrays.asList(4, 6));           // 4
        possibilities.add(Arrays.asList(5));              // 5
        possibilities.add(Arrays.asList(6));              // 6
        possibilities.add(Arrays.asList(7, 9, 3, 1));     // 7
        possibilities.add(Arrays.asList(8, 4, 2, 6));     // 8
        possibilities.add(Arrays.asList(9, 1));           // 9

        int x = Integer.parseInt(a.substring(a.length() - 1));  // Only need the last digit of `a`
        if (b.equals("0")) return 1;
        if (x == 0 || x == 1 || x == 5 || x == 6) return x;

        List<Integer> cycle = possibilities.get(x);
        int cycleLength = cycle.size();

        // Reduce large exponent `b` modulo the cycle length
        int mod = 0;
        for (char digit : b.toCharArray()) {
            mod = (mod * 10 + (digit - '0')) % cycleLength;
        }

        int index = (mod == 0) ? cycleLength - 1 : mod - 1;
        return cycle.get(index);
    }


    public static void main(String[] args) {
        System.out.println( 645 );
        System.out.println(lastDigitOfPower("123", "645"));
    }
}
