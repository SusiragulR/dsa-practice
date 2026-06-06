import java.util.Stack;

public class cf135 {
    public static int evaluatePostfix(String str){
        Stack<Integer> stk = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c>='0' && c<='9') stk.push(c - '0');

            else{
                int b = stk.pop();
                int a = stk.pop();

                switch (c){
                    case '+': {
                        stk.push(a + b);
                        break;
                    }
                    case '-': {
                        stk.push(a - b);
                        break;
                    }
                    case '*': {
                        stk.push(a * b);
                        break;
                    }
                    case '/': {
                        stk.push(a / b);
                        break;
                    }
                }
            }
        }

        return stk.peek();
    }

    public static void main(String[] args) {
        String sample = "231*+9-";
        String sample2 = "123+*8-";

        System.out.println(evaluatePostfix(sample));
    }
}
