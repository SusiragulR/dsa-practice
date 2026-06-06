public class cf98 {
    static boolean detectLoop(LLNode head) {
        LLNode slow = head, fast = head;

        if(head==null || head.next==null || head.next.next==null) return false;

        slow = slow.next;
        fast = fast.next.next;

        while(fast!=null && fast.next!=null){
            if(slow == fast) {
                System.out.println(slow);
                System.out.println(slow.data);
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        LLNode h15 = new LLNode(6);
        LLNode h14 = new LLNode(5,h15);
        LLNode h13 = new LLNode(4,h14);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1  = new LLNode(1,h11);

        h15.next = h11;

        System.out.println(detectLoop(h1));
    }
}
