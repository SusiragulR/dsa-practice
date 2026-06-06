import java.util.ArrayList;

public class cf242 {
    public static ArrayList<String> generateParentheses(int n) {
        int[] openCount = new int[]{0};
        int[] closedCount = new int[]{0};

        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();

        generateParenthesesUtil( n/2, openCount, closedCount, sb, ans );

        return ans;
    }

    public static void generateParenthesesUtil(
            int n,
            int[] openCount,
            int[] closedCount,
            StringBuilder sb,
            ArrayList<String> ans
    ) {
        if(openCount[0]==n && closedCount[0]==n) {
            ans.add( sb.toString() );
            return;
        }

        if(openCount[0] < n){
            sb.append('(');
            openCount[0]++;
            generateParenthesesUtil( n, openCount, closedCount, sb, ans );
            openCount[0]--;
            sb.deleteCharAt( sb.length()-1 );
        }

        if(closedCount[0]<n && closedCount[0]<openCount[0]){
            sb.append(')');
            closedCount[0]++;
            generateParenthesesUtil( n, openCount, closedCount, sb, ans );
            closedCount[0]--;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println( generateParentheses(4) );
    }
}
