import java.util.Arrays;

public class cf35majorityElement {

    static int majorityElement(int[] arr) {
        Arrays.sort(arr);
        int count=0,maxCount=0,majorityElement=arr[0];

        for(int i=0;i<arr.length;i++){
            if(i==0 || arr[i]!=arr[i-1]){
                if(maxCount < count) maxCount=count;
                count=1;
            }
            else{
                count++;
                if(count>maxCount) majorityElement=arr[i];
            }
        }

        return majorityElement;
    }//TC:O(N+NlogN) SC:O(1)  *********** gvn in qn that one majorityElement exists ***********


}
