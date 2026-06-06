import java.util.HashSet;
import java.util.Set;

public class cf95 {
    static int countPairs(LLNode h1,LLNode h2, int target){

        if(h1==null || h2==null) return -1;

        Set<Integer> chk = new HashSet<>();

        LLNode mover = h1;
        while (mover != null){
            chk.add(mover.data);
            mover = mover.next;
        }

        int count = 0;

        mover = h2;
        while (mover != null){
            if(chk.contains(target - mover.data)) {
                System.out.println(mover.data+"-"+(target - mover.data));
                count++;
            }
            mover = mover.next;
        }

        return count;
    }

    public static void main(String[] args) {
        LLNode h15 = new LLNode(6);
        LLNode h14 = new LLNode(5,h15);
        LLNode h13 = new LLNode(4,h14);
        LLNode h12 = new LLNode(3,h13);
        LLNode h11 = new LLNode(2,h12);
        LLNode h1 = new LLNode(1,h11);

        LLNode h25 = new LLNode(15);
        LLNode h24 = new LLNode(3,h25);
        LLNode h23 = new LLNode(10,h24);
        LLNode h22 = new LLNode(9,h23);
        LLNode h21 = new LLNode(11,h22);
        LLNode h2 = new LLNode(7,h21);

        System.out.println(countPairs(h1,h2,15));
    }
}
