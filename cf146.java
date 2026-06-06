import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class cf146 {

    static Queue<Integer> revQ(Queue<Integer> q){
        Stack<Integer> stk = new Stack<>();

        while (!q.isEmpty()){
            stk.push( q.remove() );
        }

        while (!stk.empty()){
            q.add( stk.pop() );
        }

        return q;
    } //TC: O(2N)  SC:O(N)

    static void revQbyRecursive(Queue<Integer> q){
        //b
        if(q.isEmpty()) return;

        //r
        int el = q.remove();
        revQbyRecursive(q);
        q.add(el);
    } //TC: O(N)  SC:O(N)

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<Integer>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println(q1.peek());

//        Queue<Integer> ans = revQ(q1);

        revQbyRecursive(q1);
        while (!q1.isEmpty()) System.out.print(q1.remove()+" ");
    }
}
