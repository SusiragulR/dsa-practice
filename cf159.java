import java.util.*;

public class cf159 {
    static int countOfSubstrings(String s, int k) {
        HashMap<Character, Integer> chk = new HashMap<>();
        int count=0;

        for(int i=0; i<k; i++){
            if( chk.containsKey(s.charAt(i)) ) chk.put(s.charAt(i), chk.get(s.charAt(i))+1);
            else chk.put(s.charAt(i), 1);
        }

        if(chk.size() == k-1) count++;

        int l=0, r=k-1;
        while (r < s.length()-1){
            r++;
            if( chk.containsKey(s.charAt(r)) ) chk.put(s.charAt(r), chk.get(s.charAt(r))+1);
            else chk.put(s.charAt(r), 1);

            if( chk.get(s.charAt(l))==1 ) chk.remove(s.charAt(l));
            else chk.put( s.charAt(l), chk.get(s.charAt(l))-1 );
            l++;

            if(chk.size() == k-1) count++;
        }

        return count;
    }

    static ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;

        // arrays to store prevSmallerElement and nextSmallerElement
        int[] prevSmallerIndex = new int[n];
        int[] nextSmallerIndex = new int[n];

        //Fill them with -1 for prevSmaller (imagining the prev smaller ele is at index -1)
        //Fill them with n for prevSmaller (imagining the prev smaller ele is at index n)
        //for calculating range by this (nextSmallerIndex[i] - prevSmallerIndex[i] - 1)
        Arrays.fill(prevSmallerIndex, -1);
        Arrays.fill(nextSmallerIndex, n);

        Stack<Integer> stk = new Stack<>();

        //finding pse
        for(int i=0; i<n; i++) {
            while(
                    !stk.empty()
                    && (arr[stk.peek()] >= arr[i])
            ) {
                stk.pop();
            }

            if(!stk.empty()) prevSmallerIndex[i] = stk.peek();
            stk.push(i);
        }

        stk.clear();

        //finding nse
        for(int i=n-1; i>=0; i--) {
            while(
                    !stk.empty()
                            && (arr[stk.peek()] >= arr[i])
            ) {
                stk.pop();
            }

            if(!stk.empty()) nextSmallerIndex[i] = stk.peek();
            stk.push(i);
        }

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));// here indx 0 will hold max of mins of window of len 1

        for(int i=0; i<n; i++) {
            int l = nextSmallerIndex[i] - prevSmallerIndex[i] - 1;
            int indexOfLen = l-1;
            ans.set(indexOfLen, Math.max(ans.get(indexOfLen), arr[i]));
        }

        // filling from back
        for(int i=n-2; i>=0; i--) {
            ans.set(i, Math.max(ans.get(i), ans.get(i+1)));
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abcc"; //K = 2
        String str2 = "aabab"; //K = 3

        System.out.println( countOfSubstrings(str2, 3) );
    }
}
