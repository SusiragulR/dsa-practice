import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class cf93 {
    public static LLNode findUnion(LLNode head1, LLNode head2) {
        Set<Integer> ansSet = new HashSet<>();

        LLNode mover = head1;
        while(mover != null){
            ansSet.add(mover.data);
            mover = mover.next;
        }

        mover = head2;
        while(mover != null){
            ansSet.add(mover.data);
            mover = mover.next;
        }

        LLNode head=null;
        boolean isHeadGiven = false;

        for (Object i: ansSet.toArray()){
            if(!isHeadGiven){
                isHeadGiven = true;
                head = new LLNode((int)i);
                mover = head;
            }
            else{
                LLNode temp = new LLNode((int) i);
                mover.next = temp;
                mover = temp;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LLNode h14 = new LLNode(7);
        LLNode h15 = new LLNode(6,h14);
        LLNode s = new LLNode(5,h15);
        LLNode h13 = new LLNode(4,s);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

        LLNode h21 = new LLNode(3,s);
        LLNode h2 = new LLNode(1,h21);

        List<Integer> chk = new ArrayList<>();
        chk.add(1);
        chk.add(2);
        chk.add(3);

        System.out.println(chk.contains(4));
    }
}
