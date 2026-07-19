package Greedy;

public class G17_minimumCostOfRopes {

//  The solution planned below shouldn't work ideally.
//  Because, while writing the code we realise that swapping may seem good
//  but the value in the swapped position is not guaranteed to be less than the values next to it
//  Pq is the best approach

//    public static int minCost(int[] arr) {
//        if(arr.length == 1) return 0;
//
//        Arrays.sort(arr);
//
//        int cost = arr[0];
//        int sumOfTotalCost = 0;
//
//        for(int i=1; i<arr.length; i++) {
//            if(i+1<arr.length && arr[i+1]<cost) {
//                int temp = cost;
//                cost = arr[i+1];
//                arr[i+1] = temp;
//            }
//            cost += arr[i];
//            sumOfTotalCost += cost;
//        }
//
//        return sumOfTotalCost;
//    }


}
