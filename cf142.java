import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class cf142 {

    static String resCandyCrush(String s, int k){
        Stack<List<Character>> stk = new Stack<>();
        char k1 = (char)(k + '0');
        String ans = "";

        for (int i=0; i<s.length(); i++){
            if( !stk.empty() && stk.peek().get(1)==k1 ) {
                for(int x=0; x<k; x++) stk.pop();
            }

            char c = s.charAt(i);

            if(stk.empty() || stk.peek().get(0) != c) {
                List<Character> toPush = new ArrayList<>();
                toPush.add(c);
                toPush.add('1');
                stk.push(toPush);
                //System.out.println(stk);
            }

            else {
                List<Character> toPush = new ArrayList<>();
                toPush.add(c);
                toPush.add((char) (stk.peek().get(1) + 1));
                stk.push(toPush); //incrementing count by 1
                //System.out.println(stk);
            }
        }

        if( !stk.empty() && stk.peek().get(1)==k1 ) {
            for(int x=0; x<k; x++) stk.pop();
        } //final check which could be missed as we check at top of the loop
        //System.out.println(stk);

        while(!stk.empty()) ans+=stk.pop().get(0);
        StringBuilder sb = new StringBuilder(ans);
        sb.reverse();
        return sb.toString();
    }

    static String restrictiveCandyCrush(String s, int k){
        if(k==1) return "";

        Stack<CharNumPair> stk = new Stack<>();

        for(int i=s.length()-1; i>=0; i--){
            char selectedChar = s.charAt(i);
            if(stk.empty()) stk.push(new CharNumPair(selectedChar, 1));
            else {
                if(stk.peek().character == selectedChar){
                    stk.peek().num += 1;
                    if(stk.peek().num == k){
                        stk.pop();
                    }
                } else {
                    stk.push(new CharNumPair(selectedChar, 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stk.isEmpty()) {
            CharNumPair p = stk.pop();
            sb.append(String.valueOf(p.character).repeat(p.num));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "sggeeegssforgeeks";
        String s1 = "ssggeeff";
        String s2 = "ggeeegsskksk";

        System.out.println(resCandyCrush(s,1));
        System.out.println(restrictiveCandyCrush(s, 1));
    }
}
