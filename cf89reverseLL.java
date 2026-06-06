public class cf89reverseLL { //OPTIMAL APPROACH
    static LLNode revevereLLthroughRecursion(LLNode head){
        //b
        if(head == null || head.next==null) return head;

        //r
        LLNode newHead = revevereLLthroughRecursion(head.next);

        LLNode front = head.next; //the next element to the head i'm giving (the ele in front of head)
        front.next = head; //reversing the direction
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

        LLNode h15 = new LLNode(6);
        LLNode h14 = new LLNode(5,h15);
        LLNode h13 = new LLNode(4,h14);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

        LL.printAllInLL( revevereLLthroughRecursion(h1) );
    }
}
