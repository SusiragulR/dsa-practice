public class cf91 { //tortoise and hare algo
    static LLNode middleOfLL(LLNode head){ //RETURN M2 IN EVEN LENGTH
        LLNode slow = head, fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static LLNode middleOfLL2(LLNode head){ //RETURN M1 IN EVEN LENGTH
        LLNode mid = head, ahead = head;

        while (ahead.next!=null && ahead.next.next!=null){
            mid = mid.next;
            ahead = ahead.next.next;
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,2,3,4,5,6,7,8};
        LLNode head = LL.arrToLL(sample);

        System.out.println( middleOfLL2(head).data );
    }
}
