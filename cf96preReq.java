public class cf96preReq {
    static LLNode reverseFirstKNodesOfLL(LLNode givenHead, int k){ // always 1 <= k <= sizeOfLinkedList
        // store gvn head which will be the tail of reversed k nodes
        LLNode mover = givenHead;
        int count = 0;
        LLNode prev = null;

        while (count != k){
            LLNode temp = mover.next;
            mover.next = prev;
            prev = mover;
            mover = temp;
            count++;
        }
        // after the while loop, mover will be (k+1)th Node
        // so the gvnHead.next shall be mover (linking tail of reversed LL to k+1 node)
        // prev will be the new head
        givenHead.next = mover;
        return prev;
    }

//    static LLNode reverseLLinKGroup (LLNode head, int k) {
//        LLNode headerOfSelectedGroup = head, ans = null;
//
//        while (headerOfSelectedGroup != null){ // nested while loops to repeat the above for every K group
//            LLNode mover = headerOfSelectedGroup, prev = null;
//            int count = 0;
//
//            while(mover != null && count != k){
//                LLNode temp = mover.next;
//                mover.next = prev;
//                prev = mover;
//                mover = temp;
//                count++;
//            }
//
//            // the condition (headerOfSelectedGroup == head) indicates this is the first group
//            // When it's the first group, the prev will the head of the reversed part
//            // the head of the reversed part will the new head of reversed LL in K Group
//            if(headerOfSelectedGroup == head) ans = prev;
//
//            headerOfSelectedGroup.next = mover;
//            headerOfSelectedGroup = mover;
//        }
//
//        return ans;
//    }
//
// THE o/p OF ABOVE CODE
//  for input
//  LLNode newHead = reverseLLinKGroup(h1, 4);
//  LL.printAllInLL( newHead );
//  is 4 3 2 1 5 9 as I assigned headerOfSelectedGroup.next = mover;

//    ***********************************************************
//    ***********************************************************

//  A recursive implementation of reverseFirstKNodesOfLL will be the identical solution
//  as each recursive call will give the new head of the reversed k group chosen
//  which can be linked to the actual headerOfTheSelectedGroup which would form a k reversed LL as expected

    static LLNode reverseLLinKGroup (LLNode givenHead, int k) {
        // BREAK CASE
        if(givenHead == null) return null;

        // RECURSIVE CASE
        LLNode mover = givenHead;
        int count = 0;
        LLNode prev = null;

        while (count!=k && mover!=null){
            LLNode temp = mover.next;
            mover.next = prev;
            prev = mover;
            mover = temp;
            count++;
        }
        // after the while loop, mover will be (k+1)th Node (actual head of next group)
        // so the gvnHead.next shall be head of reversed part of next group (linking tail of reversed LL to k+1 node)
        // prev will be the new head
        givenHead.next = reverseLLinKGroup(mover, k);
        return prev;
    }

    public static void main(String[] args) {
        LLNode h23 = new LLNode(14);
        LLNode h22 = new LLNode(13, h23);
        LLNode h21 = new LLNode(12, h22);
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

//        LLNode ans = reverseFirstKNodesOfLL(h1, 11);
//        LL.printAllInLL( ans );

        LLNode newHead = reverseLLinKGroup(h1, 4);
        LL.printAllInLL( newHead );
    }
}
