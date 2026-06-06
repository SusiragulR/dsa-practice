import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class cf38mergeIntervals {
    static List<List<Integer>> mergeIntervals(int[][] arr){

        List<List<Integer>> ans = new ArrayList<>();


        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for(int i=0;i< arr.length;i++){
            if(ans.isEmpty() || arr[i][0] > ans.getLast().get(1)){
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }

            else{
                if(!ans.isEmpty()) ans.getLast().set(1,Math.max(ans.getLast().get(1),arr[i][1]));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{0,1},{1,4},{2,6},{8,9},{8,11},{11,17},{19,23}};

        List<List<Integer>> ans = mergeIntervals(sample);

        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
    }
}
