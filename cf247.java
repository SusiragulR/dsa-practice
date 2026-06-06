import java.util.ArrayList;

public class cf247 {
    public static ArrayList<ArrayList<String>> palinParts(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();

        palindromePartsUtil( s, 0, path, ans );

        return ans;
    }

    static void palindromePartsUtil (
            String s,
            int indx,
            ArrayList<String> path,
            ArrayList<ArrayList<String>> ans
    ) {
        if(indx == s.length()){
            ans.add( new ArrayList<>(path) );
            return;
        }

        for(int i=indx; i<s.length(); i++) {
            if( isPalindrome(s, indx, i) ) {
                path.add( s.substring(indx, i+1) );
                palindromePartsUtil( s, i+1, path, ans );
                path.removeLast();
            }
        }
    }

    static boolean isPalindrome ( String s, int start, int end ) {
        while( start <= end ) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "abcba";

        System.out.println( palinParts(s1) );
        System.out.println( palinParts(s2) );
    }
}
