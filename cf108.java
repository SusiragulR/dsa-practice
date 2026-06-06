public class cf108 {
    static LLNode seggregateEvenOdd(LLNode head){
        if(head==null || head.next==null) return head;

        LLNode low=null, high=head, prevHigh=null;
        if(head.data%2 == 0) {
            low = head;
            prevHigh = high;
            high = high.next;
        }

        while (high != null){
            if(high.data%2 == 0) { //even
                if(low == null){
                    LLNode nextHigh = high.next;
                    high.next = head;
                    head = high; //newHead
                    low = head;
                    prevHigh.next = nextHigh;
                    high = nextHigh;
                }

                else{
                    if(high == low.next){
                        prevHigh = high;
                        low = high;
                        high = high.next;
                        continue;
                    }

                    LLNode nextHigh = high.next;

                    high.next = low.next;
                    low.next = high;

                    low = low.next;

                    prevHigh.next = nextHigh;
                    high = nextHigh;
                }
            }

            else { //odd
                prevHigh = high;
                high = high.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LLNode h20 = new LLNode(99);
        LLNode h19 = new LLNode(98,h20);
        LLNode h18 = new LLNode(98,h19);
        LLNode h17 = new LLNode(98,h18);
        LLNode h16 = new LLNode(97,h17);
        LLNode h15 = new LLNode(86,h16);
        LLNode h14 = new LLNode(84,h15);
        LLNode h13 = new LLNode(81,h14);
        LLNode h12 = new LLNode(80,h13);
        LLNode h11 = new LLNode(80,h12);
        LLNode h1 = new LLNode(70,h11);
        LLNode h30 = new LLNode(70,h1);
        LLNode h29 = new LLNode(5,h30);
        LLNode h28 = new LLNode(4,h29);
        LLNode h27 = new LLNode(4,h28);
        LLNode h26 = new LLNode(3,h27);
        LLNode h25 = new LLNode(2,h26);
        LLNode h24 = new LLNode(2,h25);
        LLNode h23 = new LLNode(13);
        LLNode h22 = new LLNode(295,h23);
        LLNode h21 = new LLNode(228,h22);
        LLNode h2 = new LLNode(132,h21);

        LL.printAllInLL( seggregateEvenOdd(h2) );
    }
}
