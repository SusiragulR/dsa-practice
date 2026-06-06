import java.util.Stack;

public class cf134 {
    static int priorityOf(Character i){
        if( i=='(' || i==')' ) return 0;
        else if( i=='^' ) return 3;
        else if( i=='*' || i=='/' ) return 2;
        else return 1;
    }
    public static String infixToPostfix(String str){
        Stack<Character> stk = new Stack<>();

        String ans = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if( ( c>='A' && c<='Z' )
                || ( c>='a' && c<='z')
                || (c>='0' && c<='9') ) ans += c;

            else{
                if(stk.empty()) stk.push(c);

                else if(c=='(') stk.push(c);

                else if(c==')') {
                    while (!stk.empty() && stk.peek() != '(') ans+=stk.pop(); //to remove until (
                    if(!stk.empty()) stk.pop(); //to remove (
                }

                else {
                    while (!stk.empty() && priorityOf(stk.peek()) >= priorityOf(c)) ans+=stk.pop();
                    stk.push(c);
                }
            }
        }

        while (!stk.empty()) ans+=stk.pop();

        return ans;
    }

    public static void main(String[] args) {
        String sample = "a+b*(c^d-e)^(f+g*h)-i";
        String sample2 = "A*(B+C)/D";

        System.out.println(infixToPostfix(sample2));
    }
}
