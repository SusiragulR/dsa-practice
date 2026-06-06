import java.util.*;

public class cf26 {
    static Set<List<Integer>> hashingApproachOfQuadruples(int[] arr, int n, int target){

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int k=j+1;
                Map<Integer,Integer> hashchk = new HashMap<>();
                while(k<n){
                    int expectedValue = target - (arr[i]+arr[j]+arr[k]);

                    if(hashchk.containsKey(expectedValue)){
                        List<Integer> quadruple = new ArrayList<>();
                        Collections.addAll(quadruple,arr[i],arr[j],arr[k],expectedValue);
                        Collections.sort(quadruple);
                        ans.add(quadruple);
                    }

                    if (hashchk.containsKey(arr[k])) {
                        hashchk.put(arr[k], hashchk.get(arr[k])+1);
                    } else {
                        hashchk.put(arr[k], 1);
                    }
                    k++;
                }
            }
        }

        return ans;
    }

    //TWO-POINTER APPROACH
    static Set<List<Integer>> twoPointerApproachQuads(int[] arr, int n, int target){

        Arrays.sort(arr);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i=0;i<n;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                for (int j=i+1;j<n;j++){
                    if(j==i+1 || arr[j]!=arr[j-1]){
                        int k=j+1,l=n-1;
                        while(k<l){
                            int sum = arr[i]+arr[j]+arr[k]+arr[l];

                            if(sum>target){
                                l--;
                                while (k<l && arr[l]==arr[l+1]) l--;
                            }
                            else if (sum<target) {
                                k++;
                                while (k<l && arr[k]==arr[k-1]) k++;
                            }
                            else{
                                List<Integer> quads = new ArrayList<>();
                                Collections.addAll(quads,arr[i],arr[j],arr[k],arr[l]);
                                Collections.sort(quads);
                                ans.add(quads);
                                l--;
                                k++;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample= new int[]{1,2,4,3,6,7,3,5,7,5,8,9,15,0,0,0};
        int[] sample2= new int[]{0,0,0,0};

        //hashingApproach answer
        Set<List<Integer>> ans = hashingApproachOfQuadruples(sample, sample.length, 15);
        for(List<Integer> i: ans){
            System.out.println(i);
        }
        System.out.println(ans.size());
        System.out.println("**********");

        //TwoPointerApproach
        Set<List<Integer>> ans2 = twoPointerApproachQuads(sample2, sample2.length, 1);
        for(List<Integer> i: ans){
            System.out.println(i);
        }
        System.out.println(ans.size());
        System.out.println("**********");
    }
}
