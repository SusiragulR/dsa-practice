public class cf113 {
    static LLLNode traversalFlatten(LLLNode root)
    {
        if(root == null) return root;

        LLLNode mover = root;

        while(mover!=null){
            LLLNode nextRoot = mover.next; //storing next LL's head
            mover.next = mover.bottom; // -> to |

            LLLNode curr = mover;

            while(curr.next != null){
                curr = curr.next;
                curr.next = curr.bottom;
            }

            mover = curr;
            mover.next = nextRoot;
            mover = mover.next;
        }

        return root;
    }

//    static LLLNode sortedFlatten(LLNode head){
//
//    }

    public static void main(String[] args) {
        LLLNode h20 = new LLLNode(22);
        LLLNode h19 = new LLLNode(21,null,h20);
        LLLNode h18 = new LLLNode(20,null,h19);
        LLLNode h6 = new LLLNode(19,null,h18);

        LLLNode h16 = new LLLNode(18,null,null);
        LLLNode h15 = new LLLNode(17,null,h16);
        LLLNode h14 = new LLLNode(16,null,h15);
        LLLNode h5 = new LLLNode(15,h6,h14);

        LLLNode h12 = new LLLNode(14,null,null);
        LLLNode h11 = new LLLNode(13,null,h12);
        LLLNode h4 = new LLLNode(12,h5,h11);

        LLLNode h30 = new LLLNode(11,null,null);
        LLLNode h3 = new LLLNode(10,h4,h30);

        LLLNode h2 = new LLLNode(9,h3,null);

        LLLNode h27 = new LLLNode(8,null,null);
        LLLNode h26 = new LLLNode(7,null,h27);
        LLLNode h25 = new LLLNode(6,null,h26);
        LLLNode h24 = new LLLNode(5,null,h25);
        LLLNode h23 = new LLLNode(4,null,h24);
        LLLNode h22 = new LLLNode(3,null,h23);
        LLLNode h21 = new LLLNode(2,null,h22);
        LLLNode h1 = new LLLNode(1,h2,h21);

        LLL.printAllInLLL( traversalFlatten(h1) );
    }
}
