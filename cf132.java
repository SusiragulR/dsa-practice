import java.util.Stack;

public class cf132 {
    static long giveMaxRect(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] leftValid = new int[arr.length];

        for (int i=0; i<arr.length; i++){
            while (!stk.empty() && arr[stk.peek()]>=arr[i]) stk.pop();

            leftValid[i] = stk.empty() ? 0 : stk.peek()+1;

            stk.push(i);
        }

        long maxArea = Long.MIN_VALUE;

        stk = new Stack<>();

        for (int i=arr.length-1; i>=0; i--){
            while (!stk.empty() && arr[stk.peek()]>=arr[i]) stk.pop();

            int rightValid = stk.empty() ? arr.length-1 : stk.peek()-1;

            long product = (long)arr[i] * (rightValid-leftValid[i]+1);
            System.out.print(product+" ");
            maxArea = Math.max(maxArea, product);

            stk.push(i);
        }

        System.out.println();
        return maxArea;
    }
}
