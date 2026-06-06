import org.w3c.dom.Node;

public class cf102 {

    static void sort012LLUsingTwoPointers(LLNode head){
        LLNode mover = head, ptr = head;

        while (mover!=null) {
            if(mover.data == 0) {
                mover.data = ptr.data;
                ptr.data = 0;
                ptr = ptr.next;
            }
            mover = mover.next;
        }

        // now ptr will stand at first non-zero node
        mover = ptr;
        while (mover!=null) {
            if(mover.data == 1) {
                mover.data = ptr.data;
                ptr.data = 1;
                ptr = ptr.next;
            }
            mover = mover.next;
        }
    }
    static LLNode sort012ofLL(LLNode head){
        LLNode temp = head;
        LLNode p0h=null, p1h=null, p2h=null, p0=null, p1=null, p2=null;
        while (temp!=null){
            if(temp.data==0){
                if(p0h==null) {
                    p0h = new LLNode(0);
                    p0 = p0h;
                }
                else {
                    LLNode newNode = new LLNode(0);
                    p0.next = newNode;
                    p0 = newNode;
                }
            }

            if(temp.data==1){
                if(p1h==null) {
                    p1h = new LLNode(1);
                    p1 = p1h;
                }
                else {
                    LLNode newNode = new LLNode(1);
                    p1.next = newNode;
                    p1 = newNode;
                }
            }

            if(temp.data==2){
                if(p2h==null) {
                    p2h = new LLNode(2);
                    p2 = p2h;
                }
                else {
                    LLNode newNode = new LLNode(2);
                    p2.next = newNode;
                    p2 = newNode;
                }
            }

            temp = temp.next;
        }

        if(p0h!=null) p0.next = p1h;
        if(p1h==null) if(p0h!=null) p0.next = p2h;
        if(p1h!=null) p1.next = p2h;

//        LL.printAllInLL(p0h);
//        System.out.println();
//        LL.printAllInLL(p1h);
//        System.out.println();
//        LL.printAllInLL(p2h);
//        System.out.println();

        return (p0h!=null) ? p0h : (p1h!=null) ? p1h : p2h;
    }

    public static void main(String[] args) {
        LLNode h21 = new LLNode(0);
        LLNode h20 = new LLNode(1,h21);
        LLNode h19 = new LLNode(1,h20);
        LLNode h18 = new LLNode(2,h19);
        LLNode h17 = new LLNode(1,h18);
        LLNode h16 = new LLNode(2,h17);
        LLNode h15 = new LLNode(1,h16);
        LLNode h14 = new LLNode(1,h15);
        LLNode h13 = new LLNode(2,h14);
        LLNode h12 = new LLNode(2,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(0,h11);

        LLNode h31 = new LLNode(0);
        LLNode h30 = new LLNode(2,h31);
        LLNode h29 = new LLNode(2,h30);
        LLNode h28 = new LLNode(2,h29);
        LLNode h27 = new LLNode(2,h28);
        LLNode h26 = new LLNode(2,h27);
        LLNode h25 = new LLNode(2,h26);
        LLNode h24 = new LLNode(2,h25);
        LLNode h23 = new LLNode(2,h24);
        LLNode h22 = new LLNode(2,h23);

        LL.printAllInLL(sort012ofLL(h1));

        sort012LLUsingTwoPointers(h22);
        LL.printAllInLL(h22);
    }
}
