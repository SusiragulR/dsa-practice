public class cf104 {
    static LLNode merge2sortedLL(LLNode head1, LLNode head2){

        if(head1==null && head2!=null) return head2;
        if(head2==null && head1!=null) return head1;
        if(head1==null && head2==null) return null;

        LLNode mover1=head1, mover2=head2;

        if(mover2.data < mover1.data) return merge2sortedLL(head2, head1);

        LLNode prev1=null;
        while(mover1!=null && mover2!=null){
            prev1=mover1;

            if(mover2.data <= mover1.data){
                LLNode temp1 = mover1.next; //storing next node of m1
                mover1.next = mover2; //attaching the present node of m2
                mover2 = mover2.next; //moving m2 to next node
                mover1.next.next = temp1; //attaching back to next node of m1
                mover1 = mover1.next; //moving m1 to next node
                //System.out.println(mover1.data+"-->"+ mover2.data);
            }

            else if(mover1.next!=null && mover1.next.data > mover2.data){
                LLNode temp1 = mover1.next; //storing next node of m1
                mover1.next = mover2; //attaching the present node of m2
                mover2 = mover2.next; //moving m2 to next node
                mover1.next.next = temp1; //attaching back to next node of m1
                mover1 = mover1.next; //moving m1 to next node
                //System.out.println(mover1.data+"-->"+ mover2.data);
            }

            else mover1 = mover1.next;
        }

        if(mover2!=null) prev1.next = mover2;
        //because if mover1 is null --> it's not a problem as we merge m2 nodes into m1
        //but if m2 has some elements pending, then they must be attached to m1 end

        return head1;
    }

    public static void main(String[] args) {
        LLNode h20 = new LLNode(81);
        LLNode h19 = new LLNode(70,h20);
        LLNode h18 = new LLNode(69,h19);
        LLNode h17 = new LLNode(58,h18);
        LLNode h16 = new LLNode(47,h17);
        LLNode h15 = new LLNode(36,h16);
        LLNode h14 = new LLNode(92);
        LLNode h13 = new LLNode(79,h14);
        LLNode h12 = new LLNode(53,h13);
        LLNode h11 = new LLNode(39,h12);
        LLNode h1 = new LLNode(36,h11);

        LLNode h30 = new LLNode(70);
        LLNode h29 = new LLNode(67,h30);
        LLNode h28 = new LLNode(54,h29);
        LLNode h27 = new LLNode(44,h28);
        LLNode h26 = new LLNode(33,h27);
        LLNode h25 = new LLNode(6,h26);
        LLNode h24 = new LLNode(99);
        LLNode h23 = new LLNode(87,h24);
        LLNode h22 = new LLNode(49,h23);
        LLNode h21 = new LLNode(9,h22);
        LLNode h2 = new LLNode(8,h21);

        LL.printAllInLL( merge2sortedLL(h1,h2) );
    }
}
