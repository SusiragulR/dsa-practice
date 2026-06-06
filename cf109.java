public class cf109 {
    static LLNode add1toNumberLL(LLNode head) {
        if (head == null) return head;

        LLNode mover = head,
        start9 = null;

        while(mover.next!=null && mover.data == 9) mover=mover.next;

        while (mover.next != null){
            if(mover.next.data == 9){
                start9 = mover;
                while (mover.next!=null && mover.next.data==9) mover=mover.next;
            }

            if(mover.next == null) break; //it reached tail
            else mover = mover.next; //if it's not tail then it should not stop at last contiguous 9
        }

        if(mover.data == 9){
            if(start9 == null){
                LLNode newHead = new LLNode(1);
                newHead.next = head;
                head = newHead;

                newHead = newHead.next;
                while (newHead != null) {
                    newHead.data = 0;
                    newHead = newHead.next;
                }
            }

            else{
                start9.data = start9.data + 1;

                start9 = start9.next;
                while (start9 != null){
                    start9.data = 0;
                    start9 = start9.next;
                }
            }
        }

        else mover.data = mover.data + 1;

        return head;
    }

    static LLNode add1recursive(LLNode head){
        int carry = helper(head);

        if(carry == 0) return head;

        LLNode newHead = new LLNode(1);
        newHead.next = head;
        return newHead;
    }

    static int helper(LLNode temp){
        //b
        if(temp == null) return 1; //return carry 1 (adding 1)

        //r
        int carry = helper(temp.next);

        if(carry == 1) {
            temp.data = temp.data + 1;
            if (temp.data == 10) {
                temp.data = 0;
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LLNode h20 = new LLNode(9);
        LLNode h19 = new LLNode(9, h20);
        LLNode h18 = new LLNode(9, h19);
        LLNode h17 = new LLNode(9, h18);
        LLNode h16 = new LLNode(9, h17);
        LLNode h15 = new LLNode(9, h16);
        LLNode h14 = new LLNode(9, h15);
        LLNode h13 = new LLNode(9, h14);
        LLNode h12 = new LLNode(9, h13);
        LLNode h11 = new LLNode(9, h12);
        LLNode h1 = new LLNode(9, h11);

        LL.printAllInLL( add1recursive(h1) );
    }
}
