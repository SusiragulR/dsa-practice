public class cg248 {
    static int index = 0;

    public static String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                index++;
            }
            else if (ch == '[') {
                index++; // skip '['
                String decodedPart = decode(s);

                for (int i = 0; i < num; i++) {
                    result.append(decodedPart);
                }
                num = 0; // reset number
            }
            else if (ch == ']') {
                index++; // skip ']'
                return result.toString();
            }
            else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "4[a3[b]]";
        String s2 = "1[1[1[1[1[t]]]]]";
        System.out.println(decodeString(s2));
    }
}
