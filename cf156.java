import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cf156 {
//    static long[] printFirstNegativeInteger(long[] a, int n, int k)
//    {
//        ArrayList<Long> chk = new ArrayList<>();
//        long[] ans = new long[n-k+1];
//
//        for( int i=0; i<k; i++){
//            if(a[i] < 0) chk.add(a[i]); //if -ve add to list
//        }
//
//        if(!chk.isEmpty()) ans[0] = chk.get(0);
//
//        int l=0, r=k-1;
//
//        while (r < n-1){
//            r++;
//            if(a[r] < 0) chk.add(a[r]); //if incoming is -ve add it to the list
//
//            if(a[l] < 0) if(!chk.isEmpty()) chk.remove(0); //if outgoing is -ve remove 1st el from the list
//            l++;
//
//            if(!chk.isEmpty()) ans[l] = chk.get(0);
//        }
//
//        return ans;
//    }


    static List<Integer> firstNegIntTCExceeded(int arr[], int k) { //TIME-LIMIT Exceeded
        int l = arr.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<k; i++) {
            if(arr[i] < 0) q.add(arr[i]);
        }

        ans.add(q.isEmpty() ? 0 : q.peek());

        for(int i=k; i<l; i++) {
            if(arr[i-k] < 0 && !q.isEmpty()) q.remove();
            if(arr[i] < 0) q.add(arr[i]);
            ans.add(q.isEmpty() ? 0 : q.peek());
        }

        return ans;
    }

    static List<Integer> firstNegIntTCtestCasesPassed(int arr[], int k) { // storing indices - TC passed
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>(); // store indices of negative numbers
        List<Integer> ans = new ArrayList<>();

        // process first window
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) q.add(i);
        }
        ans.add(q.isEmpty() ? 0 : arr[q.peek()]);

        // sliding window
        for (int i = k; i < n; i++) {

            // remove indexes that go out of window
            while (!q.isEmpty() && q.peek() <= i - k) {
                q.remove();
            }

            // add new element
            if (arr[i] < 0) q.add(i);

            ans.add(q.isEmpty() ? 0 : arr[q.peek()]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{-8, 2, 3, -6, 10}; //k=2
        int[] sample2 = new int[]{12, -1, -7, 8, -15, 30, 16, 28}; //k=3

        System.out.println(firstNegIntTCtestCasesPassed(sample2, 3));
    }
}
