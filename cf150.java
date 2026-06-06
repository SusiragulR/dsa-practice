import java.util.Queue;
import java.util.Stack;

public class cf150 {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        int qLen = q.size();
        if( qLen < k ) return q;

        int nonReversedCount = qLen - k;
        Stack<Integer> st = new Stack<>();

        for(int i=1; i<=k; i++) {
            st.push(q.remove());
        }

        for(int i=1; i<=k; i++) {
            q.add(st.pop());
        }

        for(int i=1; i<=nonReversedCount; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
