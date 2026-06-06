public class cf250 {
    public boolean isSumString(String s) {
        int n = s.length();

        for (int l1=0; l1<n; l1++) {
            for (int l2=0; l1+l2<n; l2++) {
                if ( checkSumString(s, 0, l1, l2) ) return true;
            }
        }

        return false;
    }

    private static boolean checkSumString (
            String s,
            int start,
            int l1,
            int l2
    ) {
        int n = s.length();

        if (start + l1 + l2 >= n) return false;

        String sum = addStrings(
                s.substring(start, start + l1),
                s.substring(start + l1, start + l1 + l2)
        );

        int nextStart = start + l1 + l2;

        if (!s.startsWith(sum, nextStart)) return false;

        if (nextStart + sum.length() == n) return true;

        return checkSumString(s, start + l1, l2, sum.length());
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return result.reverse().toString();
    }


}
