import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class cf130 {
    public static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Stack< List<Integer> > stk = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stk.empty() && stk.peek().get(0)<=price[i]) stk.pop();

            List<Integer> toPush = new ArrayList<>();
            if(stk.empty()){
                toPush.add( price[i] );
                toPush.add( i );

                ans[i] = i-(-1); //-1 since 0-(-1)=1
                stk.push(toPush);
            }else{
                toPush.add( price[i] );
                toPush.add( i );

                ans[i] = i-stk.getLast().get(1);
                stk.push(toPush);
            }
        }

        return ans;
    }

//    DIDN'T WORK - FAILED CASE

//    public static List<Integer> calculateSpanNew(int price[]) {
//        int l = price.length;
//        Stack<Integer> stk = new Stack<>();
//        List<Integer> ans = new ArrayList<>(Collections.nCopies(l, 0));
//
//        for(int i=0; i<l; i++) {
//            if(stk.isEmpty()){
//                stk.push(price[i]);
//            } else {
//                if(stk.getLast() <= price[i]) stk.push(price[i]);
//                else {
//                    while (!stk.isEmpty()) stk.pop();
//                    stk.push(price[i]);
//                }
//            }
//
//            System.out.println("cycle:" + i);
//            System.out.println("stk:" + stk + " ---size--> "+stk.size());
//            ans.set(i, stk.size());
//            System.out.println("ansList updated to: " + ans);
//        }
//
//        return ans;
//    }

    public static List<Integer> calculateSpanNew(int[] price) {
        int l = price.length;
        Stack<Pair> stk = new Stack<>();
        List<Integer> ans = new ArrayList<>(Collections.nCopies(l, 0));

        for(int i=0; i<l; i++) {
            if(stk.isEmpty()){
                // stk empty case
                stk.push(new Pair(price[i],i));
                ans.set(i, i-(-1));
            } else {
                // stk isn't empty
                if(stk.getLast().first > price[i]) {
                    stk.push(new Pair(price[i], i));
                    ans.set(i, 1);
                }
                else {
                    while (
                            !stk.isEmpty() &&
                            price[i] >= stk.getLast().first // fails when condition gvn as price[i] > stk.getLast().first
                    ) stk.pop();
                    ans.set(i,  i - (stk.empty() ? -1 : stk.getLast().second) );
                    stk.push(new Pair(price[i], i)); // if this push isn't done, the sample4 output fails
                }
            }

//            System.out.println("======================================");
//            System.out.println("cycle:" + i);
//            System.out.println("stk--size--> "+stk.size());
//            System.out.println("stk:" + stk );
//            System.out.println("ansList updated to: " + ans);
//            System.out.println("======================================");
        }

        return ans;
    }

    public static List<Integer> calculateSpanNewSimplifiedCode(int[] price) {
        int n = price.length;
        Stack<Pair> stk = new Stack<>();
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            // Pop all prices <= current price (they are not "next greater to left")
            while (!stk.isEmpty() && stk.peek().first <= price[i]) {
                stk.pop();
            }

            // Compute span: if stack empty, span = i - (-1) = i+1, else difference in indices
            int span = i - (stk.isEmpty() ? -1 : stk.peek().second);
            ans.set(i, span);

            // Push current pair for future elements
            stk.push(new Pair(price[i], i));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample1 = new int[]{100 ,80 ,60 ,70 ,60 ,75 ,85};
        int[] sample2 = new int[]{10 ,4 ,5 ,90 ,120 ,80};
        int[] sample3 = new int[]{0, 0, 0, 0, 0, 0, 0};
        int[] sample4 = new int[]{7, 10, 4, 8, 7, 2};

        int[] ans10 = calculateSpan(sample1, sample1.length);
        for(int i: ans10) System.out.print(i+" ");

        List<Integer> ans11 = calculateSpanNewSimplifiedCode(sample1);
        System.out.println(ans11);

        int[] ans20 = calculateSpan(sample2, sample2.length);
        for(int i: ans20) System.out.print(i+" ");

        List<Integer> ans21 = calculateSpanNewSimplifiedCode(sample2);
        System.out.println(ans21);

        int[] ans30 = calculateSpan(sample3, sample3.length);
        for(int i: ans30) System.out.print(i+" ");

        List<Integer> ans31 = calculateSpanNewSimplifiedCode(sample3);
        System.out.println(ans31);

        int[] ans40 = calculateSpan(sample4, sample4.length);
        for(int i: ans40) System.out.print(i+" ");

        List<Integer> ans41 = calculateSpanNewSimplifiedCode(sample4);
        System.out.println(ans41);
    }
}
