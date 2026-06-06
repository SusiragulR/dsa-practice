import java.util.HashMap;
import java.util.Map;

public class cf33 {
    static int longestSubArraylength(int[] arr,int target){
        int count=1,l=arr.length;
        long sum = 0;


        for(int i: arr){
            sum+=i;
        }

        while(count<l){
            long newSum = sum;
            for(int i=0;i<count;i++){
                newSum-=arr[l-1-i];
            }

            if(newSum==target){
                return l-count;
            }

            long checksum = newSum;
            for(int i=0;i<count;i++){
                checksum = checksum - arr[i] + arr[l-1-i];
                if(checksum==target) {
                    return l-count;
                }
            }

            count++;
        }

        return 0;
    }//CONSUMES MORE TIME

    //HASHING APPROACH
    static int hashingApproachOfLengthOfLongestSubarray(int[] arr,int target){
        int length=0,sum=0;
        Map<Integer,Integer> sumAndIndex = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum==target) length=i+1;

            else if(sumAndIndex.containsKey(sum-target)){
                int newLength = i-sumAndIndex.get(sum-target);
                if (newLength>length) length=newLength;
            }

            //sumAndIndex.put(sum,i);
            //the above line is wrong as it does not work with 0s in the array
            //because the sum won't change when the arr[i] is 0 but updates the rightmost index
            //which is not appreciable when we need max length subarray
            //so, it can be written as
            if(!sumAndIndex.containsKey(sum)) sumAndIndex.put(sum,i);
        }

        return length;
    }//TC:O(N logN) SC:O(N)

    //TWO-POINTER APPROACH
    static int twoPapproachofMaxSubArray(int[] arr,int target){
        int arrLen = arr.length;
        int i=0,j=0,maxLen=0;
        long sum=0;

        while(j<arrLen){
            while(i<=j && sum>target){
                sum-=arr[i];
                i++;
            }
            if(sum==target){
                int newLen = j-i+1;
                if(newLen>maxLen) maxLen=newLen;
            }
            j++;
            if(j<arrLen) sum+=arr[j];
        }

        return maxLen;
    }
    // DOESN'T WORK FOR NEGATIVE VALUES.ONLY POSITIVES AND ZEROS
    // TC:O(2N) SC:O(1)

    public static void main(String[] args) {
        int[] sample= new int[]{1,3,5,6,13,2,13,2,2,4,3,7,6,8};

        System.out.println(longestSubArraylength(sample,30));
        System.out.println(hashingApproachOfLengthOfLongestSubarray(sample,30));
        System.out.println(twoPapproachofMaxSubArray(sample,30));

    }
}
