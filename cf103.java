public class cf103 {
    static LLNode pairwiseSwap(LLNode head){
        LLNode temp = head;

        while (temp!=null && temp.next!=null){
            int swap = temp.data;
            temp.data = temp.next.data;
            temp.next.data = swap;

            temp = temp.next.next;
        }

        return head;
    }

    static LLNode pairSwapNodesInLL (LLNode head) { //swap the nodes not the data alone
        if (head == null || head.next == null) return head;

        LLNode prev = null;
        LLNode curr = head;
        LLNode ansHead = head.next;  // After the first swap, this becomes the new head

        while (curr != null && curr.next != null) {
            LLNode next = curr.next;
            LLNode firstNodeOfNextPair = next.next;

            // Swap the pair
            next.next = curr;
            curr.next = firstNodeOfNextPair;

            // Connect previous pair with the current swapped pair
            if (prev != null) {
                prev.next = next;
            }

            // Move pointers ahead
            prev = curr;
            curr = firstNodeOfNextPair;
        }

        return ansHead;
    }

//BAD RECURSION****************

//    static LLNode pairSwap(LLNode head) { //swapping nodes
//        // b
//        if(head==null || head.next==null) return head;
//
//        //r
//        LLNode second = head.next;
//
//        LLNode nextSwapped = pairSwap(second.next);
//
//        second.next = head;
//        head.next = nextSwapped;
//
//        return head;
//    }

    static LLNode pairSwapDataInLL(LLNode head) { //swapping nodes
        // b
        if (head == null || head.next == null) return head;

        //r
        LLNode second = head.next;

        head.next = pairSwapDataInLL(second.next);

        second.next = head;

        return second;
    }

    public static void main(String[] args) {
        LLNode h21 = new LLNode(12);
        LLNode h20 = new LLNode(11,h21);
        LLNode h19 = new LLNode(10,h20);
        LLNode h18 = new LLNode(9,h19);
        LLNode h17 = new LLNode(8,h18);
        LLNode h16 = new LLNode(7,h17);
        LLNode h15 = new LLNode(6,h16);
        LLNode h14 = new LLNode(5,h15);
        LLNode h13 = new LLNode(4,h14);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

//        LL.printAllInLL( pairSwapDataInLL(h1) );
//        System.out.println();
        LL.printAllInLL( pairSwapNodesInLL(h1) );
    }
}
