public class LLLNode {
    int data;
    LLLNode next;
    LLLNode bottom; //LL in LL

    LLLNode(int data1, LLLNode next1, LLLNode btm) {
        this.data = data1;
        this.next = next1;
        this.bottom = btm;
    }

    LLLNode(int data1) {
        this.data = data1;
        this.next = null;
        this.bottom = null;
    }
}
