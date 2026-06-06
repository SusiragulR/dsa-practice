public class cf109test {
    static LLNode add1toANumRepresentedAsLL(LLNode head) {
        int firstDigitOfAnsSum = recursiveAddition(head);
        if(firstDigitOfAnsSum != 0) {
            return new LLNode(firstDigitOfAnsSum, head);
        }
        return head;
    }

    static int recursiveAddition(LLNode head) {
        //BREAK CASE
        if(head == null){
            return 1;
        }

        //RECURSIVE CASE
        int sum = head.data + recursiveAddition(head.next);
        head.data = sum%10;
        return sum/10;
    }

    public static void main(String[] args) {
        LLNode h20 = new LLNode(9);
        LLNode h19 = new LLNode(9, h20);
        LLNode h18 = new LLNode(9, h19);
        LLNode h17 = new LLNode(9, h18);
        LLNode h16 = new LLNode(9, h17);
        LLNode h15 = new LLNode(9, h16);
        LLNode h14 = new LLNode(9, h15);
        LLNode h13 = new LLNode(9, h14);
        LLNode h12 = new LLNode(9, h13);
        LLNode h11 = new LLNode(9, h12);
        LLNode h1 = new LLNode(9, h11);

        LL.printAllInLL( add1toANumRepresentedAsLL(h1) );
    }
}
