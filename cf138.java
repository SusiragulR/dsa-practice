import java.util.Stack;

public class cf138 {
    static void insertAndGive(Stack<Integer> stk, int x){
        //base
        if(stk.empty()){
            stk.push(x);
            return;
        }

        //recursive
        else{
            int el = stk.pop();
            insertAndGive(stk, x);
            stk.push(el);
        }
    }

    static Stack<Integer> insertAtBottom(Stack<Integer> stk, int x) {
        insertAndGive(stk,x);

        return stk;
    }

    static Stack<Integer> insertAtBottomNew(Stack<Integer> st, int x) {
        System.out.println("+++++++++");
        System.out.println("st: " + st);
        System.out.println("x: " + x);
        if(st.empty()){
            st.push(x);
            return st;
        }
        else {
            int temp = st.pop();
            Stack<Integer> stNew = insertAtBottomNew(st, x);
            stNew.push(temp);
            return stNew;
        }
    }

    public static Stack<Integer> insertAtBottomNew2(Stack<Integer> st, int x) {
        if(st.empty()){
            st.push(x);
            return st;
        }
        else {
            int temp = st.pop();
            Stack<Integer> stNew = insertAtBottomNew2(st, x);
            stNew.push(temp);
            return stNew;
        }
    }

    static Stack<Integer> revStack(Stack<Integer> stk) {
        if(stk.empty()) return stk;

        else {
            int topEle = stk.pop();
            revStack(stk);
            return insertAtBottomNew2(stk, topEle);
        }
    }

    static Stack<Integer> insertAtSortedPosition(Stack<Integer> stk, int x){
        if(stk.empty() || stk.peek()<=x) {
            stk.push(x);
            return stk;
        }

        else{
            int poppedGreaterElement = stk.pop();
            Stack<Integer> recStack = insertAtSortedPosition(stk, x);
            recStack.push(poppedGreaterElement);
            return recStack;
        }
    }

    static Stack<Integer> sortStack(Stack<Integer> stk) {
        if(stk.empty()) return stk;

        else {
            int topEle = stk.pop();
            sortStack(stk);
            return insertAtSortedPosition(stk, topEle);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> sample = new Stack<>();
        sample.push(3);
        sample.push(22);
        sample.push(38);
        sample.push(45);
        sample.push(32);
        sample.push(67);
        sample.push(34);
        sample.push(74);
        sample.push(3);
        sample.push(89);
        sample.push(90);
        sample.push(90);
        sample.push(45);
        sample.push(1);


        Stack<Integer> sample1 = new Stack<>();
        Stack<Integer> sample2 = new Stack<>();
        sample2.push(1);
        sample2.push(2);
        sample2.push(3);

        //System.out.println(insertAtBottom(sample,4));
        //System.out.println(insertAtBottomNew2(sample1,4));
        System.out.println(sample);
        System.out.println(sortStack(sample));
    }
}
