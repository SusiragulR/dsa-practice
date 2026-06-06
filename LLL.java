public class LLL {
    static void printAllInLLL(LLLNode head1){
        //traversal
        LLLNode head = head1;
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
