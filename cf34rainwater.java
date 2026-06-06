import java.util.HashMap;
import java.util.Map;

public class cf34rainwater {
    static int hashingRainWater(int[] arr){
        int heap=0;
        Map<Integer,Integer> rainWater = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if (heap<arr[i]) {
                heap = arr[i];
                rainWater.put(-1, i);
            }
            //System.out.println("heap:"+heap);
            //System.out.println(i+"->"+(heap-arr[i]));
            rainWater.put(i,heap-arr[i]);
        }

        //System.out.println("last:"+arr[arr.length-1]+" heap:"+heap);
        if((arr[arr.length-1])<heap){
            int tempHeap = rainWater.get(-1);
            heap=0;

            for(int i=arr.length-1;i>=tempHeap;i--){
                if (heap<arr[i]) heap=arr[i];
                //System.out.println("heap:"+heap);
                //System.out.println(i+"->"+(heap-arr[i]));
                rainWater.put(i,heap-arr[i]);
            }
        }

        int ans = 0;
        for (int i=0;i< arr.length;i++){
            ans+=rainWater.get(i);
            //System.out.println("ans:"+ans);
        }

        return ans;
    }

    

    public static void main(String[] args) {
        int[] sample = new int[]{12,0,5,0,2,3,4,5,7,0,4};
        int[] sample2 = new int[]{8,8,2,4,5,5,1};

        System.out.println(hashingRainWater(sample2));
    }
}
