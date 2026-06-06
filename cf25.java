import java.util.*;

public class cf25 {
//    public static boolean find3Numbers(int arr[], int n, int x) {
//        Arrays.sort(arr);
//
//        int l=0,r=n-1;
//
//        while(l+2<=r){
//            int sum1=arr[l]+arr[l+1]+arr[r];
//            int sum2=arr[l]+arr[r-1]+arr[r];
//            System.out.println(l+"---"+r);
//            System.out.println(arr[l]+" "+arr[l+1]+" "+arr[r]+"-->sum1:"+sum1);
//            System.out.println(arr[l]+" "+arr[r-1]+" "+arr[r]+"-->sum2:"+sum2);
//
//            if(sum1==x || sum2==x){
//                return true;
//            }
//
//            if(sum2<x) {
//                l++;
//                r=n-1;
//            }
//
//            if(sum2>x) {
//                r--;
//            }
//        }
//
//        return false;
//    }
//**********************************above approach failed*************************************



    public static void printTripletSum(int[] arr,int n,int sum){
        if(n<3){
            System.out.println("Impossible");
        }

        Arrays.sort(arr);

        boolean isPresent = false;

        for(int i=0;i<n;i++) {
            int j=i+1,k=n-1;
            if (i == 0 || arr[i]!=arr[i - 1]) {
                while (j < k) {
                    int arrSum = arr[i]+arr[j]+arr[k];
                    if(arrSum==sum) {
                        System.out.println("true");
                        System.out.println(arr[i]+"-"+arr[j]+"-"+arr[k]);
                        isPresent=true;
                        k--;
                        while (j<k && arr[k]==arr[k+1]) k--;
                        j++;
                        while (j<k && arr[j]==arr[j-1]) j++;
                    } else if (arrSum>sum) {
                        k--;
                        while (j<k && arr[k]==arr[k+1]) k--;
                    } else {
                        j++;
                        while (j<k && arr[j]==arr[j-1]) j++;
                    }
                }
            }
        }

        if(!isPresent) System.out.println("false");
    }
    //TC:O(N logN) for sorting + ~O(N^2) for traversal of i & j
    //SC:O(no. of unique triplets)

    //*88888888888888888888888888888888*****************************************88

    //HASHING APPROACH
    static Set<List<Integer>> hashingApproachToTriplets(int[] arr, int n, int sum){

        Set<List<Integer>> ansSet = new HashSet<>();

        for(int i=0;i<n-2;i++){
            int j=i+1;

            Map<Integer,Integer> hashchk = new HashMap<>();

            while (j<n){
                int expectingValue = sum-(arr[i]+arr[j]);
                List<Integer> triplet = new ArrayList<>();

                if(hashchk.containsKey(expectingValue)) {
                    Collections.addAll(triplet, arr[i], arr[j], expectingValue);
                    Collections.sort(triplet);
                    ansSet.add(triplet);
                }
               if(hashchk.containsKey(arr[j])) {
                   hashchk.put(arr[j], hashchk.get(arr[j]) + 1);
               }else {
                   hashchk.put(arr[j], 1);
               }
                j++;
            }
        }

        return ansSet;
    }
    // TC:O(N^2 logM)
    // M-> varies according to i & j
    // logM -> to search in a hashmap

    // SC:O(N) + O(2 * (no. of unique triplets))
    // O(N) is for hashmap for which atmost we'll store N-2 entries
    // O(2 * (no. of unique triplets) for set of list
    // have to get more clarity on this ^ (2 * (no. of unique triplets))

    public static void main(String[] args) {
        int[] sample= new int[]{1,2,4,3,6,7};

        printTripletSum(sample,6,10);

        System.out.println("***************");

        Set<List<Integer>> ans = hashingApproachToTriplets(sample,6,10);
        for ( List<Integer> i: ans){
            System.out.println(i);
        }
    }
}
