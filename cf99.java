public class cf99 {
    static int lenOfLoop(LLNode head) {
        LLNode slow = head, fast = head;

        if(head==null || head.next==null || head.next.next==null) return 0;

        slow = slow.next;
        fast = fast.next.next;

        while(fast!=null && fast.next!=null){
            if(slow == fast){
                fast = fast.next;
                int count=1;
                while (fast!=slow){
                    count++;
                    fast = fast.next;
                }
                count++;

                return count;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return 0;
    }
}
