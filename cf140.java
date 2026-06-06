import java.util.Stack;

public class cf140 {

    static void bubbleSortOfStack(Stack<Integer> stk) {
        int max = stk.pop();
        int min = stk.pop();

        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        //System.out.println(max + " min:" + min);
        stk.push(min);

        if (stk.size() == 1) {
            stk.push(max);
            return;
        }
        //System.out.println(stk);
        bubbleSortOfStack(stk);
        stk.push(max);
    }

    static Stack<Integer> sort(Stack<Integer> stk) {

        if(stk.size()==1) return stk;

        for (int i = 0; i < stk.size(); i++) {
            bubbleSortOfStack(stk);
        }
        return stk;
    }

    public static void main(String[] args) {
        Stack<Integer> sample = new Stack<>();
        sample.push(19);
        sample.push(47);
        sample.push(22);
        sample.push(32);

        System.out.println(sort(sample));
    }
}
