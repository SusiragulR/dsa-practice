import java.util.Stack;

public class cf126 {
    static long top(Stack<Long> chk){
        if(chk.empty()) return -1;

        long top = chk.pop();
        chk.push(top);
        return top;
    }

    static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[n];
        Stack<Long> chk = new Stack<>();

        for(int i=n-1;i>=0;i--){
            if (chk.empty()) {
                ans[i] = -1;
                chk.push(arr[i]);
            }

            else {
                while( top(chk)!=-1 && top(chk)<=arr[i] ) {
                    chk.pop();
                }
                ans[i] = top(chk);
                chk.push(arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        long[] sample = new long[]{1 ,3 ,2 ,4};
        long[] sample1 = new long[]{10, 20, 30, 50};
        long[] sample2 = new long[]{50, 40, 30, 10};
        long[] sample3 = new long[]{6 ,8 ,0 ,1 ,3};

        long[] ans = nextLargerElement(sample2,4);
        for (long i: ans) System.out.print(i+" ");
    }
}
