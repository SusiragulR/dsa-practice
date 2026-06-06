import java.util.*;

public class cf25ii {
    //to return count of triplets whose sum is 0;

    public static int countOfTriplet0(int[] arr,int n){
        if(n<3) return 0;

        int count=0;
        Arrays.sort(arr);

        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            if(i==0 || arr[i]!=arr[i-1]){
                while(j<k){
                    int arrSum = arr[i]+arr[j];
                    if(arrSum==arr[k]) count++;

                    k--;
                    while(j<k && arr[k]==arr[k+1]) k--;

                    if(j>=k){
                        j++;
                        while(j<k && arr[j]==arr[j-1]) j++;
                        k=n-1;
                    }
                }
            }
        }

        return count;
    }

    static int count0triplets(int[] arr,int n){
        if(n<3) return 0;

        int count=0;
        Map<Integer,Integer> hashchk = new HashMap<>();

        for(int i=0;i<n;i++){
            hashchk.put(arr[i], hashchk.getOrDefault(arr[i], 1));
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int arrSum = arr[i]+arr[j];

                if(arr[i]==0 && arr[j]==0) if(hashchk.get(0)==3) count++;

                else if(arr[i]==0 && arr[j]!=0) if(hashchk.get(arr[j])>=2) count++;

                else if(arr[i]!=0 && arr[j]==0) if(hashchk.get(arr[i])>=2) count++;

                if(hashchk.get(arrSum)!=null){
                    count++;
                }
            }
        }

        return count;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<n;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int j = i+1, k = n-1;

                while(j<k){
                    long arrSum = nums[i] + nums[j] + nums[k];

                    if(arrSum==0){
                        //System.out.println("1");
                        List<Integer> toAdd = new ArrayList<>();
                        toAdd.add(nums[i]);
                        toAdd.add(nums[j]);
                        toAdd.add(nums[k]);

                        //System.out.println("added:"+toAdd);
                        ans.add(toAdd);

                        j++;
                        while( j<k && nums[j] == nums[j-1] ) j++;
                        //System.out.println("j increased:"+j);

                        k--;
                        while( j<k && nums[k] == nums[k+1] ) k--;
                        //System.out.println("k decreased:"+k);
                    }

                    else if(arrSum<0){
                        //System.out.println("2");
                        j++;
                        while( j<k && nums[j] == nums[j-1] ) j++;
                        //System.out.println("j increased:"+j);
                    }

                    else{
                        //System.out.println("3");
                        k--;
                        while( j<k && nums[k] == nums[k+1] ) k--;
                        //System.out.println("k decreased:"+k);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample= new int[]{-1,0,1,2,-1,-4};
        int[] sample2= new int[]{0,0,0};

        //System.out.println(countOfTriplet0(sample,4));
        System.out.println(countOfTriplet0(sample2, sample2.length));
    }
}
