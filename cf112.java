public class cf112 {
    static LLNode reorderLL(LLNode head){
        if(head==null || head.next==null || head.next.next==null) return head;

        LLNode s=head, f=head;

        while (f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
        }

        LLNode temp = s.next;
        s.next = null;
        if(temp==null) return head;

        LLNode toAdd = reverse(temp);
        LLNode mover = head;

        while (toAdd!=null){
            temp = mover.next;
            mover.next = toAdd;
            toAdd = toAdd.next;
            mover.next.next = temp;
            mover = temp;
        }

        return head;
    }//TC:O(1.5N) SC:O(1)
    // SC:O(N/2)-->recursive stack space if recursive reverse is used

    static LLNode reverseLL(LLNode head){
        //b
        if(head==null || head.next == null) return head;

        //r
        LLNode newHead = reverseLL(head.next);
        LLNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    static LLNode reverse(LLNode head){
        if(head == null) return head;

        LLNode mover=head, prev=null;
        while(mover!=null){
            LLNode temp = mover.next;
            mover.next = prev;
            prev = mover;
            mover = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        LLNode h20 = new LLNode(11);
        LLNode h19 = new LLNode(10,h20);
        LLNode h18 = new LLNode(9, h19);
        LLNode h17 = new LLNode(8, h18);
        LLNode h16 = new LLNode(7, h17);
        LLNode h15 = new LLNode(6, h16);
        LLNode h14 = new LLNode(5, h15);
        LLNode h13 = new LLNode(4,h14);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

        LL.printAllInLL( reorderLL(h1) );
    }
}
