public class cf96reverseLLinGrp {
    static LLNode reverseInGrp(LLNode head, int k){
        LLNode temp = head;
        LLNode prevLast = null;

        while (temp!=null) {
            LLNode kthNode = kthNode(temp, k);
            LLNode nextNode = kthNode.next;
            kthNode.next = null;

            cf89reverseLL.revevereLLthroughRecursion(temp);

            if (temp == head) head = kthNode;

            if(prevLast!=null) prevLast.next = kthNode;

            prevLast = temp;
            temp.next = nextNode;
            temp = nextNode;
        }

        return head;
    }

    static LLNode kthNode(LLNode head, int k){
        if(head == null) return null;

        for (int i=1; i<k; i++){ //if k=3 run 2 which is (k-1) times
            if(head.next == null) break;
            head = head.next;
        }

        return head;
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

        LL.printAllInLL( reverseInGrp(h1, 2) );
    }
}
