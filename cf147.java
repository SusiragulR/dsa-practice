import java.util.LinkedList;
import java.util.Queue;

public class cf147 {
    static void reverseQueue(Queue<Integer> q) {
        int l = q.size();
        if(l == 0 || l == 1) return ;

        int poppedElement = q.remove();
        reverseQueue(q);

        for(int i=0; i<l-1; i++){
            q.add(q.remove());
        }

        q.add(poppedElement);
    }

    static void optimisedReverseQueue(Queue<Integer> q) {
        if(q.isEmpty()) return;

        int popped = q.remove();
        reverseQueue(q);
        q.add(popped);
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);

        System.out.println(q1);
        optimisedReverseQueue(q1);
        System.out.println(q1);
    }
}
