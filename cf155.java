import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cf155 {
//    static ArrayList<Integer> countDistinct(int[] arr, int n, int k){
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        HashMap<Integer, Integer> chk = new HashMap<>();
//
//        for(int i=0; i<k; i++){
//            if( chk.containsKey(arr[i]) ) chk.put( arr[i], chk.get(arr[i])+1 );
//            else chk.put(arr[i],1);
//        }
//
//        ans.add(chk.size());
//
//        int l=0, r=k-1;
//
//        while (r<n-1){
//            if(chk.get(arr[l])==1) chk.remove(arr[l]);
//            else chk.put( arr[l], chk.get(arr[l])-1 );
//            l++;
//
//            r++;
//            if( chk.containsKey(arr[r]) ) chk.put( arr[r], chk.get(arr[r])+1 );
//            else chk.put(arr[r],1);
//
//            ans.add( chk.size() );
//        }
//
//        return ans;
//    }

    static ArrayList<Integer> countDistinctWithCleanCode(int arr[], int k) {
        int l = arr.length;
        HashMap<Integer, Integer> chk = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<k; i++) {
            if( chk.containsKey(arr[i]) ) chk.put( arr[i], chk.get(arr[i])+1 );
            else chk.put( arr[i], 1 );
        }

        ans.add(chk.size());

        for(int i=k; i<l; i++) {
            int removingKey = arr[i-k];

            //removing
            if (chk.get(removingKey) == 1) {
                chk.remove(removingKey);
            } else {
                chk.put(removingKey, chk.get(removingKey) - 1);
            }

            //adding
            if( chk.containsKey(arr[i]) ) chk.put( arr[i], chk.get(arr[i])+1 );
            else chk.put( arr[i], 1 );

            ans.add(chk.size());
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1,2,1,3,4,2,3}; //n=7 k=4
        int[] sample2 = new int[]{4,1,1}; //n=3 k=2

        System.out.println( countDistinctWithCleanCode(sample, 4) );
        System.out.println( countDistinctWithCleanCode(sample2, 2) );
    }
}
