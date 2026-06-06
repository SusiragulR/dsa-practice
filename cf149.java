import java.util.LinkedList;
import java.util.Queue;

public class cf149 {

// DIDN'T WORK
//    public static void removeIfExistsAndInsert(Queue<Character> q, char c) {
//        Queue<Character> chkQ = new LinkedList<>();
//        boolean isExists = false;
//
//        while(!q.isEmpty()) {
//            char popped = q.remove();
//            if(popped == c) isExists = true;
//            else chkQ.add(popped);
//        }
//
//        if( !isExists ) chkQ.add(c);
//
//        q=chkQ;
//    }
//
//    public static String firstNonRepeating(String s) {
//        Queue<Character> q = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char charAtIndex = s.charAt(i);
//
//            if (q.isEmpty()) {
//                q.add(charAtIndex);
//                sb.append(charAtIndex);
//            } else if (charAtIndex == q.peek()) {
//                q.remove();
//                sb.append( q.isEmpty() ? '#' : q.peek() );
//            } else {
//                sb.append(q.peek());
//                removeIfExistsAndInsert(q, charAtIndex);
//            }
//        }
//
//        return sb.toString();
//    }

    public static String firstNonRepeating(String s) {
        if (s == null || s.isEmpty()) return "";

        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length());

        for (char ch : s.toCharArray()) {
            // 1) update frequency
            freq[ch - 'a']++;

            // 2) push this character into the queue (it might be a candidate)
            q.add(ch);

            // 3) remove from queue any characters that are no longer non-repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // 4) top of queue (if exists) is the first non-repeating; otherwise '#'
            sb.append(q.isEmpty() ? '#' : q.peek());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "aabcd";
        String s3 = "dlghjklmn";
        String s4 = "abcba";

        System.out.println(firstNonRepeating(s1));
        System.out.println(firstNonRepeating(s2));
        System.out.println(firstNonRepeating(s3));
        System.out.println(firstNonRepeating(s4));
    }
}
