import java.util.HashSet;
import java.util.Set;

public class cf92 {
    static LLNode giveInterSection(LLNode head1, LLNode head2){
        LLNode mover = head1;
        Set<LLNode> chk = new HashSet<>();

        while (mover != null){
            chk.add(mover);
            mover = mover.next;
        }

        mover = head2;
        while (mover != null){
            if(chk.contains(mover)) return mover;
            mover = mover.next;
        }

        return null;
    }

    static int giveIsOf(LLNode head1, LLNode head2){

        if( head1==null || head2==null ) return -1;

        LLNode mover1=head1, mover2=head2;

        while(mover1 != mover2){
            mover1 = mover1.next;
            mover2 = mover2.next;

            if(mover1 == mover2) return (mover1!=null) ? mover1.data: -1;

            if(mover1==null) mover1 = head2;
            if(mover2==null) mover2 = head1;
        }

        return -1;
    }

    static int intersectionOfYShapedLinkedLists(LLNode head1, LLNode head2){
        Set<LLNode> chk = new HashSet<>();
        chk.add(head1);

        LLNode mover = head1;
        while(mover != null) {
            System.out.println(chk );
            chk.add(mover);
            mover = mover.next;
        }

        mover = head2;
        while (mover != null){
            if(chk.contains(mover)) return mover.data;
            mover = mover.next;
        }

        return -1;
    }

    public static void main(String[] args) {


        LLNode h14 = new LLNode(7);
        LLNode h15 = new LLNode(6,h14);
        LLNode s = new LLNode(5,h15);

        LLNode h13 = new LLNode(4,s);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

        LLNode h21 = new LLNode(3,s);
        LLNode h2 = new LLNode(1,h21);

//        LL.printAllInLL(h1);
//        System.out.println();
//        LL.printAllInLL(h2);
//        System.out.println();

//        System.out.println(giveIsOf(h1,h2));
        System.out.println(intersectionOfYShapedLinkedLists(h1,h2));
    }
}
