import java.util.Stack;

public class cf124 {
    static boolean isValidParenthesis(String str){
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='{' || c=='[' || c=='(') stk.push(c);
            else{
                if(stk.empty()) return false;
                if( !isPar(stk.pop(), c) ) return false;
            }
        }
        return stk.empty();
    }

    static boolean isPar(char open,char close){
        if(open=='{' && close=='}') return true;
        if(open=='[' && close==']') return true;
        if(open=='(' && close==')') return true;
        return false;
    }

    public static void main(String[] args) {
        String str = "}";
        System.out.println(isValidParenthesis(str));
    }
}
