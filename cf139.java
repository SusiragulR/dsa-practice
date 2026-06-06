import java.util.Stack;

public class cf139 {

//    static Stack<Integer> reverseStack(Stack<Integer> stk){
//        Stack<Integer> ans = new Stack<>();
//        while(!stk.empty()) ans.push(stk.pop());
//        return ans;
//    }//TC:O(N) SC:O(N)

    static void revStack(Stack<Integer> stk, int target, int i){
        int f = stk.pop();
        int b = stk.pop();
        stk.push(f);

        if(i==target) {
            stk.push(b);
            return;
        }

        revStack(stk, target, i+1);
        stk.push(b);
    }

    static void reverse(Stack<Integer> s)
    {
        for (int i=s.size()-1; i>=1; i--) {
            revStack(s, i, 1);
        }
    }//TC:O(N^2) SC:O(1)

    public static void main(String[] args) {
        Stack<Integer> sample = new Stack<>();
        sample.push(1);
        sample.push(2);
        sample.push(3);

        reverse(sample);

        System.out.println(sample);
    }
}
