import java.util.Scanner;

class twoStacks {
    private int[] arr;
    private int top1,top2;

    twoStacks() {
        arr = new int[1000];
        top1 = -2;
        top2 = -1;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        top1+=2;
        arr[top1]=x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        top2+=2;
        arr[top2]=x;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        top1-=2;
        if(top1!=-4) return arr[top1+2];
        else return -1;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        top2-=2;
        if(top2!=-3) return arr[top2+2];
        else return -1;
    }

    //{ Driver Code Starts
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0) {
                twoStacks g = new twoStacks();
                int Q = sc.nextInt();
                while (Q > 0) {
                    int stack_no = sc.nextInt();
                    int QueryType = sc.nextInt();

                    if (QueryType == 1) {
                        int a = sc.nextInt();
                        if (stack_no == 1)
                            g.push1(a);
                        else if (stack_no == 2)
                            g.push2(a);
                    } else if (QueryType == 2) {
                        if (stack_no == 1)
                            System.out.print(g.pop1() + " ");
                        else if (stack_no == 2)
                            System.out.print(g.pop2() + " ");
                    }

                    Q--;
                }
                System.out.println();
                T--;
            }
        }
}
