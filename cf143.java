import java.util.Stack;

public class cf143 {
    static int countReversals(String s){
        Stack<Character> stk = new Stack<>();
        int openCount=0, closeCount=0;

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='{') {
                stk.push(c);
                openCount++;
            }
            else if(!stk.empty() && c=='}' && stk.peek()=='{') {
                stk.pop();
                openCount--;
            }
            else {
                stk.push(c);
                closeCount++;
            }
        }

        if(stk.size()%2 != 0) return -1; //if odd return -1

        //if even
        int numOfRevsReqd = 0;
        numOfRevsReqd += openCount/2;
        numOfRevsReqd += openCount%2;
        numOfRevsReqd += closeCount/2;
        numOfRevsReqd += closeCount%2;

        return numOfRevsReqd;
    }
    static int countReversalsNew(String s){
        Stack<Character> stk = new Stack<>();
        int openCount=0, closeCount=0;

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='{') {
                stk.push(c);
                openCount++;
            }
            else if(!stk.empty() && c=='}' && stk.peek()=='{') {
                stk.pop();
                openCount--;
            }
            else {
                stk.push(c);
                closeCount++;
            }
        }

        if(stk.size()%2 != 0) return -1; //if odd return -1

        //if even
        int numOfRevsReqd = 0;
        numOfRevsReqd += openCount/2;
        numOfRevsReqd += openCount%2;
        numOfRevsReqd += closeCount/2;
        numOfRevsReqd += closeCount%2;

        return numOfRevsReqd;
    }

    public static void main(String[] args) {
        String str1 = "}{{}}{{{";
        String str2 = "{{}{{{}{{}}{{}";
        String str3 = "}{}{}{}}}{{{{{}{}{}}{{}{}{}}{{}}{{";
        String str4 = "}}}}}}{}{}{}{}{}{}{{}}";

        System.out.println(countReversals(str4));
    }
}
