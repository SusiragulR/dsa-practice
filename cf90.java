import java.util.Stack;

public class cf90 {
    static boolean isLLPallindrome(LLNode head){  //USING STACKS
        Stack<Integer> chk = new Stack<>();
        LLNode mover = head;

        while (mover!=null){
            chk.add(mover.data);
            mover = mover.next;
        }

        mover = head;
        while (mover!=null){
            if(mover.data != chk.pop()) return false;
            mover = mover.next;
        }

        return true;
    }

    static boolean isLLPallindrome2(LLNode head){  //BY FINDING MID AND CHECK
        LLNode mid = cf91.middleOfLL(head);

        LLNode reversed = LL.reverseLinkedList(mid);

        LLNode mover1 = head, mover2 = reversed;

        while (mover1!=null && mover2!=null){
            if(mover1.data != mover2.data) return false;
            mover2 = mover2.next;
            mover1 = mover1.next;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1, 2, 2, 2, 1};
        LLNode head = LL.arrToLL(sample);

        System.out.println( isLLPallindrome2(head) );
    }
}
