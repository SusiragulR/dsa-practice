public class LL {

    static void printAllInLL(LLNode head1){
        //traversal
        LLNode head = head1;
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    static boolean checkInLL(LLNode head, int target){
        LLNode mover = head;
        while (mover!=null){
            if(mover.data == target) return true;
            mover = mover.next;
        }
        return false;
    }

    static LLNode deleteInLL(LLNode head, int target){

        if(head.data == target) head=head.next;
        LLNode mover = head;
        while (mover != null){
            if(mover.next!=null && mover.next.data == target) mover.next = (mover.next.next == null) ? null : mover.next.next;
            mover = mover.next;
        }

        return head;
    }

    //reverse a linkedList
    static LLNode reverseLinkedList(LLNode head) {
        if(head == null) return null;

        LLNode mover = head;
        LLNode prev = null;
        LLNode temp = mover.next;

        while(temp!=null){

            mover.next = prev;
            prev = mover;
            mover = temp;

            temp = temp.next;
        }
        mover.next = prev;

        return mover;
    }

    public static LLNode arrToLL(int[] arr){
        LLNode start = new LLNode(arr[0]);
        LLNode mover = start;
        for (int i=1; i<arr.length; i++){
            LLNode temp = new LLNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return start;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,4,6,8,10,12,14,16,18,20};

        //arr to linkedList
        LLNode head = arrToLL(arr);


//        //length ofLL
//        Node head2 = start;
//        int length = 0;
//        while (head2!=null){
//            length++;
//            head2 = head2.next;
//        }
//        System.out.println("Length:"+length);
//
//        //to Check for element in LL
//        System.out.println("Check for element:");
//        System.out.println(checkInLL(start,1000));
//
//        //to delete a node in LL
//        Node newHead = deleteInLL(start,2);
//        deleteInLL(start,6);
//        deleteInLL(start,10);
//        printAllInLL(newHead);

        //to rev a LL
        LLNode y = new LLNode(5);
        LLNode x = new LLNode(4,y);
        System.out.println(x.next);

        LLNode newHead2 = reverseLinkedList(x);
        printAllInLL(newHead2);
        System.out.println(newHead2.next);
    }
}
