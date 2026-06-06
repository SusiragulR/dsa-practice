import java.util.HashMap;

public class cf170 {
    static int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> fruitsAndCount = new HashMap<>();

        int l=0, maxFruits=0;

        for(int r=0; r<n; r++) {
//            System.out.println("+".repeat(25));
//            System.out.println("r: " + r);
//            System.out.println("Map at step: " + fruitsAndCount);

            if( fruitsAndCount.containsKey(fruits[r]) ){
//                System.out.println("Already present in fruitsAndCount");
                fruitsAndCount.put( fruits[r], fruitsAndCount.get(fruits[r])+1 );
            } else {
                if( fruitsAndCount.size()<2 ) {
//                    System.out.println("--- else if case ---");
                    fruitsAndCount.put( fruits[r], 1 );
                } else {
//                    System.out.println("--- else else case ---");
                    while (fruitsAndCount.size()>=2) {
                        if( fruitsAndCount.get(fruits[l]) == 1 ) {
//                            System.out.println("removed - " + fruits[l]);
                            fruitsAndCount.remove(fruits[l]);
                        }
                        else {
                            fruitsAndCount.put(fruits[l], fruitsAndCount.get(fruits[l]) - 1);
                        }
                        l++;
                    }
                    fruitsAndCount.put(fruits[r], 1);
                }
            }

//            System.out.println("After pushing: " + fruitsAndCount);

//            System.out.println("r -> "+r);
//            System.out.println("l -> "+l);
//            System.out.println("r-l => " + (r-l+1));
            maxFruits = Math.max(maxFruits, r-l+1);
//            System.out.println("final max of step -> " + maxFruits);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,1};
        int[] arr2 = new int[]{0,1,2,2};
        int[] arr3 = new int[]{1,2,3,2,2};

        System.out.println( totalFruit(arr1) );
        System.out.println( totalFruit(arr2) );
        System.out.println( totalFruit(arr3) );
    }
}
