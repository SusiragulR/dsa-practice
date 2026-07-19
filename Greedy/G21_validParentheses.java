package Greedy;

public class G21_validParentheses {
    public int minAddToMakeValid(String s) {
        int n = s.length();

        int count = 0;

        int ans = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '(') count++;
            else count--;

            if(count<0) {
                ans++;
                count++;
            }
        }

        return ans + (count<0 ? -1*count : count);
    }
}
